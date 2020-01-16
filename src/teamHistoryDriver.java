import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.examples.CellTypes;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class teamHistoryDriver {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//joptionpane for displaying raw data or the analyze data
		int choice = JOptionPane.showConfirmDialog(null, "Do you want to see the raw data or the analyzed data?", "Choice", JOptionPane.INFORMATION_MESSAGE);
	
		//excel workbook imported for some team
		XSSFWorkbook myWorkBook = new XSSFWorkbook(new FileInputStream("Angels.xlsx"));
	
		while(choice != 2 && choice != -1) {
			if(choice == 0) {
				//class to write to excel file
				teamHistoryAnalyzer start = new teamHistoryAnalyzer();
				start.main(myWorkBook);
			}
			else if(choice == 1){
				// Return first sheet from the XLSX workbook
		        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
		       
		        // Get iterator to all the rows in current sheet
		        Iterator<Row> rowIterator = mySheet.iterator();
		       
		        // Traversing over each row of XLSX file
		        while (rowIterator.hasNext()) {
		            Row row = rowIterator.next();

		            // For each row, iterate through each columns
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
		        myWorkBook.close();
		        System.exit(0);
			}
		}
	}
}
