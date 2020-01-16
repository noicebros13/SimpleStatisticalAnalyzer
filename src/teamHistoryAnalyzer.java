import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.examples.CellTypes;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class teamHistoryAnalyzer {
	ArrayList<player> highest;
	DataFormatter format;
	
	public teamHistoryAnalyzer() {
		highest = new ArrayList<player>(); //array for stats, will expand
		format = new DataFormatter(); //get string values from cell
	}
	
	public void main(XSSFWorkbook workbook) {
		highestBA(workbook);
		sortArray();
        displayArray();
	}
	
	private void highestBA(XSSFWorkbook workbook) {
		String name = "";
		double BA = 0.0;
		int rowNum = 1;
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow rows = sheet.getRow(rowNum);
		//XSSFCell cell = rows.getCell(17);
		
		// Get iterator to all the rows in current sheet
        //Iterator<Row> rowIterator = sheet.iterator();
       
        // Traversing over each row of XLSX file
        while (rows.getCell(0).getCellType() != CellType.BLANK) {
            rows = sheet.getRow(rowNum);
            //cell = (XSSFCell)rows.getCell(1);
            name = format.formatCellValue(rows.getCell(2));
            //BA = Double.parseDouble(format.formatCellValue((XSSFCell)rows.getCell(17)));
            BA = rows.getCell(17).getNumericCellValue();
            highest.add(new player(name, BA));
            //add 1 to row for iteration
            rowNum++;
        }//end of while loop
        
	}//end of highestBA
	
	private void sortArray() {
		
	}
	
	private void displayArray() {
		for(int i = 0; i < highest.size(); i++) {
			System.out.println(highest.get(i).toString());
		}
	}
}
