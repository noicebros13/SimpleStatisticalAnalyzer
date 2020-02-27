import java.io.IOException;
import java.util.*;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class teamHistoryAnalyzer {
	ArrayList<player> playerStats;
	
	
	public teamHistoryAnalyzer(XSSFWorkbook workbook) {
		playerStats = new ArrayList<player>(); //array for stats, will expand
		loadArrayList(workbook);
	}

	/**
	 * main method is used as the execution hub for methods based on user choice
	 * from the driver class to show some basic analysis
	 * 
	 * @param choice
	 */
	public void main(int choice) {
		switch(choice){
			case -1:
				end();
				break;
			case 0:
				highestBA();
				break;
			case 1:
				getPlayerPosition();
				break;
		}
	}
	
	
	
	
	
	
	/**
	 * loadArrayList method used to get all stats from the worksheet for analysis
	 * by iterating through rows of an excel sheet and grabbing specific pieces of
	 * data from the sheet and storing them in an arraylist of type player
	 * 
	 * @param workbook; A workbook passed into the class from the driver of a .xlsx excel
	 * 					of batting statistics from baseball reference of any team
	 */
	public void loadArrayList(XSSFWorkbook workbook){
		//declare local variables to iterate, check iteration, and gather data
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		Row row = rowIterator.next();
		row =  rowIterator.next();
		XSSFCell checkLeftCell = sheet.getRow(0).getCell(0);
		
		//while loop to iterate over each row and grab specific cells if the row has player stats
		while(checkLeftCell.getCellType() != CellType.BLANK && rowIterator.hasNext()) {
			//more local variables to dynamically grab statistics from the rows of players
			double BA = row.getCell(17).getNumericCellValue();
			String name = row.getCell(2).getStringCellValue();
			String position = row.getCell(1).getStringCellValue();
			
			//add stats gathered to a player object, then place player object in arraylist of players
			player currPlayer = new player(name, BA, position);
			playerStats.add(currPlayer);
			
			//iterate to the next row and check if row has a player for the while loop
			row =  rowIterator.next();
			checkLeftCell = (XSSFCell) row.getCell(0);
		}
		
	}

	private void highestBA() {
		int highestBAIndex = 0;
		for(int i = 0; i < playerStats.size(); i++) {
			if(playerStats.get(highestBAIndex).getBA() < playerStats.get(i).getBA()) {
				highestBAIndex = i;
			}
		}
		System.out.println("Highest Batting Average: \n" + playerStats.get(highestBAIndex).getName() + ": " + playerStats.get(highestBAIndex).getBA());
		JOptionPane.showMessageDialog(null, "Highest Batting Average: \n" + playerStats.get(highestBAIndex).getName() + ": " + playerStats.get(highestBAIndex).getBA(),"Highest Batting Average", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void getPlayerPosition() {
		String[] playerNames = new String[playerStats.size()];
		
		for(int i = 0; i < playerStats.size(); i++) {
			playerNames[i] = playerStats.get(i).getName();
		}
		
		String opt = (String) JOptionPane.showInputDialog(null, "Chose player", "Player Position", JOptionPane.INFORMATION_MESSAGE, null, playerNames, playerNames[0]);
		
		for(int i = 0; i < playerStats.size(); i++) {
			if(opt.contentEquals(playerStats.get(i).getName())) {
				System.out.println(playerStats.get(i).getName() + ": " + playerStats.get(i).getPosition());
				JOptionPane.showMessageDialog(null, opt + " Position: " + playerStats.get(i).getPosition());
				break;
			}
		}
	}
	private void end() {
		JOptionPane.showMessageDialog(null, "Goodbye!", "End Program", JOptionPane.INFORMATION_MESSAGE );
	}
}
