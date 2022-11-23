package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass {
	
	
	public static String getDataFromExelSheet(String sheet, int row, int column) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("src/test/resources/testData/TestVagrant_TestData.xlsx");
		Cell expectedCell=WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(column);
		
		String cellValue="";
		
		try {
			cellValue=expectedCell.getStringCellValue();
		}catch(IllegalStateException ise) {
			double numCellValue=expectedCell.getNumericCellValue();
			//cellValue=NumCellValue+"";
			cellValue=Double.toString(numCellValue);
			
		}catch(NullPointerException npe) {
			npe.printStackTrace();
			npe.getMessage();
		}
		return cellValue;
	}
}
