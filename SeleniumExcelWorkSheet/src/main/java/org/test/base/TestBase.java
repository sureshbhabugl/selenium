package org.test.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBase {
	
	/*
	 * Reading the xlsx file and storing the values in the autmation scripts
	 * 
	 * 
	 */
	
	
	@Test
	public void readWorkBookData() throws FileNotFoundException, IOException {
		
		
		XSSFWorkbook WorkBook = new XSSFWorkbook(new FileInputStream("./Data/Data.xlsx"));
		
		XSSFSheet sheetName = WorkBook.getSheet("Login");
		
		Iterator <Row>itr = sheetName.iterator();
		
		
		while(itr.hasNext()) {
			
			Row row = itr.next();
			
			Iterator<Cell> c = row.cellIterator();
			while(c.hasNext()) {
				Cell cell = c.next();
				System.out.println(cell.getStringCellValue());
				
			}
			
		}
		
		System.out.println("The number of row is "+sheetName.getLastRowNum());
		System.out.println("The number of column is "+sheetName.getRow(0).getLastCellNum());
		
		
		//The other way of getting the exact row and column count
		
		System.out.println("Row Count: "+sheetName.getPhysicalNumberOfRows());
		System.out.println("Col Count: "+sheetName.getRow(0).getPhysicalNumberOfCells());
		
		int rowCount = sheetName.getPhysicalNumberOfRows();
		int colCount = sheetName.getRow(0).getPhysicalNumberOfCells();
		
		
		for(int i=0;i<rowCount;i++) {
			Row row=sheetName.getRow(i);
			for(int j=0;j<colCount;j++) {
				Cell cell=row.getCell(j);
				if(cell.getCellType()==CellType.NUMERIC){
					System.out.print(" "+cell.getNumericCellValue());
				}
				if(cell.getCellType()==CellType.STRING){
					System.out.print(" "+cell.getStringCellValue());
				}
			}
			System.out.println();
		}
		
	}
	

}
