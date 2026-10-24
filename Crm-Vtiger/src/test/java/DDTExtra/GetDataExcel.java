package DDTExtra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
        
		FileInputStream fis = new FileInputStream("./src/test/resources/PD.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String Data = wb.getSheet("Data").getRow(2).getCell(2).getStringCellValue();
		System.out.println(wb.getSheet("Data").getLastRowNum());
		int totalRow = wb.getSheet("Data").getLastRowNum();
		
		for (int i = 0; i <= 5; i++) {
			
			System.out.println();
		}
		wb.close();
		fis.close();		
	}

}
