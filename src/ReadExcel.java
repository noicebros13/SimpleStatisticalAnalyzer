import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ReadExcel {

	public void main() throws FileNotFoundException, IOException { 
		
		System.out.println("in main of read");
		//open the workbook and set variables
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("excel.xlsx"));
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(0);
		int j = 0;
		
		while(row.getCell(0).getCellType() != CellType.BLANK){
			for(int i = 0; i < 4; i++) {
				System.out.print(row.getCell(i) + "   ");
			}//end of for loop for printing card
			
			System.out.println();
			j++;
			//System.out.println("out of loop in read");
			row = sheet.getRow(j);
		}
		
		//close workbook
		workbook.close();
	}	
}