import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.examples.CellTypes;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class teamHistoryAnalyzer {
	ArrayList<player> highest = new ArrayList<player>();
	public teamHistoryAnalyzer() {
		
	}
	
	public void main(XSSFWorkbook workbook) {
		highestBA(workbook);
	}
	
	private void highestBA(XSSFWorkbook workbook) {
		String name = "";
		double BA = 0.0;
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow rows = sheet.getRow(1);
		XSSFCell cell = rows.getCell(18);
		
		// Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = sheet.iterator();
       
        // Traversing over each row of XLSX file
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            highest.add(row.getCell(1).setCellType(CellType.STRING);, row.getCell(18));
        }
        
        
	}
}
