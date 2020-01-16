import java.io.*;
import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriver {

	public static void main(String[] args) throws IOException {
		 XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("excel.xlsx"));
		 
		 
		//decision for writing or reading
		int decision = JOptionPane.showConfirmDialog(null, "Do you want to write cards?", "Choice", JOptionPane.INFORMATION_MESSAGE);
		
		System.out.println(decision);
		
		while(decision != 2 && decision != -1) {
			if(decision == 0) {
				//class to write to excel file
				WriteExcel write = new WriteExcel();
				write.main(workbook);
			}
			else if(decision == 1){
				//class to read / display excel file
				ReadExcel read = new ReadExcel();
				read.main();
			}
			//System.out.println("decision? (true/false)");
			decision = JOptionPane.showConfirmDialog(null, "Write again?", "Input", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(decision);
		}
	}

}
