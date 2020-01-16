import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.examples.CellTypes;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class WriteExcel {
	//scanner if you want to use instead of JOptionPane
	//private static Scanner in = new Scanner(System.in);
	private ArrayList<Card> cards;
	
	
	//constructor
	public WriteExcel() {
		cards = new ArrayList<Card>();
	}

	public void main(XSSFWorkbook workbook) throws FileNotFoundException, IOException {
		//get input for however many cards user inputs
		userInput();
		
		//write user input to sheet
		writeToSheet(workbook);
		
	}//end of main method
	
	public void userInput() {
		//local variables
		String name, team, type;
		int year;
		
		//list of all MLB teams in alphabetical order
		String[] teams = {"Arizona Diamondbacks", "Atlanta Braves", "Baltimore Orioles", 
						  "Boston Red Sox", "Chicago White Sox", "Chicago Cubs",
						  "Cincinnati Reds", "Cleveland Indians", "Colorado Rockies",
						  "Detroit Tigers", "Houston Astros", "Kansas City Royals",
						  "Los Angeles Angels", "Los Angeles Dodgers", "Miami Marlins",
						  "Milwaukee Brewers", "Minnesota Twins", "New York Yankees",
						  "New York Mets", "Oakland Athletics", "Philadelphia Phillies",
						  "Pittsburgh Pirates", "San Diego Padres", "San Francisco Giants",
						  "Seattle Mariners", "St. Louis Cardinals", "Tampa Bay Rays", "Texas Rangers", 
						  "Toronto Blue Jays", "Washington Nationals"
						  };
		
		//get input to create card object
		name = JOptionPane.showInputDialog(null, "Enter name", "Name", JOptionPane.INFORMATION_MESSAGE);
		year = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter year", "Year", JOptionPane.INFORMATION_MESSAGE));
		team = (String) JOptionPane.showInputDialog(null, "Choose team", "Team", JOptionPane.INFORMATION_MESSAGE, null, teams, teams[0]);
		type = JOptionPane.showInputDialog(null, "Enter Type", "Type", JOptionPane.INFORMATION_MESSAGE);
		
		//create card object from input
		Card thisCard = new Card(name, year, team, type);
		
		//add card object to arraylist
		cards.add(thisCard);
		System.out.println("added card to array");
	}//end of userInput method
	
	public void writeToSheet(XSSFWorkbook excelSheet) throws FileNotFoundException, IOException {
		
		//open the workbook of the excel sheet in use
		
		/* possibly change FileInputStream string to variable for user input name */
		
		/* psudocode outline 
		 * 
		 * open up excel sheet and set all variables to the newest empty spot 
		 * get all attributes and place them along the cells in the row
		 * delete the card from the arraylist
		 * repeat last 2 steps until no more cards
		 * close excel sheet
		 * display
		 * */
		
		XSSFWorkbook workbook = excelSheet;
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowNum = sheet.getLastRowNum();
		int i = 1;
		
		//check newest created row and check if it has string value, if not, go up a row
		System.out.println(sheet.getLastRowNum());
		XSSFRow row = sheet.createRow(rowNum + 1);
		XSSFCell cell = row.createCell(0);
		System.out.println(row.getRowNum());
		while(cell.getStringCellValue().equals("") && (row.getRowNum() - 1) != 0) {
			row = sheet.getRow(rowNum - i);
			cell = row.getCell(0);
			i++;
		}
		System.out.println(row.getRowNum());
		
		//nested for loop for first transferring arraylist to excel sheet
				for(int j = 0; j <= cards.size() - 1; j++) {
					
					//set cell values to those in arraylist
					cell = row.createCell(0);
					cell.setCellValue(cards.get(j).getName());
					cell = row.createCell(1);
					cell.setCellValue(cards.get(j).getYear());
					cell = row.createCell(2);
					cell.setCellValue(cards.get(j).getTeam());
					cell = row.createCell(3);
					cell.setCellValue(cards.get(j).getType());
					
					//create next row depending on where the last row ended
					row = sheet.createRow(rowNum + 1);
					System.out.println("Added card to excel doc");
				}//end of outer for loop
				

				//auto-size
				sheet.autoSizeColumn(1);
			
				//write to the workbook/excel sheet and close the workbook
				FileOutputStream output_file = new FileOutputStream("excel.xls");  
				workbook.write(output_file);
				output_file.close();
				workbook.close();
				System.out.println("Closed workbook");
	}//end of writeToSheet method

}//end of WriteExcel class
