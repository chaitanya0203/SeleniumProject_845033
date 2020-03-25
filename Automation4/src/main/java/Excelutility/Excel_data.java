package Excelutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class Excel_data {
	WebDriver driver;

	public Excel_data(WebDriver driver) {
		this.driver = driver;
	}

	public String Email(int a) throws IOException {

		FileInputStream fil = new FileInputStream(new File("Testdata//Automation3.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fil);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int count = sheet.getLastRowNum();
		System.out.println(count);

		XSSFRow row = sheet.getRow(a);
		XSSFCell cell = row.getCell(0);
		String un = cell.getStringCellValue();

		return un;
	}

	public String Password(int b) throws IOException {

		FileInputStream fil = new FileInputStream(new File("Testdata//Automation3.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fil);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int count = sheet.getLastRowNum();
		System.out.println(count);

		XSSFRow row = sheet.getRow(b);
		XSSFCell cell = row.getCell(1);
		String pwd = cell.getStringCellValue();

		return pwd;

	}
}
