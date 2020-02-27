import java.io.*;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class teamHistoryDriver {

	public static void main(String[] args) {
		
		//ask if ready to select file
		JOptionPane.showMessageDialog(null, ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n"
										  + ":: Winndustries© Baseball Batting Anaylysis ::\n"
										  + ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::", "", JOptionPane.INFORMATION_MESSAGE );
		
		//open a file selector to choose a file
		JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel File", "xlsx");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " + chooser.getSelectedFile().getAbsolutePath());
        }
        
        String excelSheet = chooser.getSelectedFile().getAbsolutePath();
		
      //Get the excel sheet that the user is working with from baseball reference
      		XSSFWorkbook myWorkBook = null;
			try {
				myWorkBook = new XSSFWorkbook(new FileInputStream(excelSheet));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      		teamHistoryAnalyzer start = new teamHistoryAnalyzer(myWorkBook);
        
        
        
		//declare and list options for user to pick from in JOptionPane
		String[] options = {"Highest Batting Average", "Player Position", "Raw Data"};
		String opt = (String) JOptionPane.showInputDialog(null, "Chose Analysis", "Batting Analysis", JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		
		
		
		while(opt != null) {
			
			
			if(opt.contentEquals(options[0])) {
				start.main(0);
			}
			else if(opt.contentEquals(options[1])) {
				start.main(1);
			}
			else if(opt.contentEquals(options[options.length - 1])) {
				XSSFSheet mySheet = myWorkBook.getSheetAt(0);
			    Iterator<Row> rowIterator = mySheet.iterator();
			    	while (rowIterator.hasNext()) {
			            Row row = rowIterator.next();
			            Iterator<Cell> cellIterator = row.cellIterator();
			            while (cellIterator.hasNext()) {
			                Cell cell = cellIterator.next();
			                switch (cell.getCellType()) {
			                case STRING:
			                    System.out.print(cell.getStringCellValue() + "\t");
			                    break;
			                case NUMERIC:
			                    System.out.print(cell.getNumericCellValue() + "\t");
			                    break;
			                case BOOLEAN:
			                    System.out.print(cell.getBooleanCellValue() + "\t");
			                    break;
			                default :
			             
			                }
			            }
			            System.out.println("");
			       }
			}
			
			opt = (String) JOptionPane.showInputDialog(null, "Chose Analysis", "Batting Analysis", JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		}
		
		if(opt == null) {
			start.main(-1);
		}
		
		try {
			myWorkBook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}
}
