package com.clx.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.clx.TestBase.TestBase;
public class ExcelReader {
	public static Object[][] getExcelData(String excelLocation,String  sheetName) throws IOException 
	{
		try {
			String dataSets[][]=null;
			FileInputStream file=new FileInputStream(new File(excelLocation));
			XSSFWorkbook worbook=new XSSFWorkbook(file);
			XSSFSheet sheet=worbook.getSheet("Sheet1");

			//count number of active rows
			int totalRow=sheet.getLastRowNum()+1;

			//count number of active columns
			int totalColumn=sheet.getRow(0).getLastCellNum(); 

			//create array of rows and columns
			dataSets=new String[totalRow-1][totalColumn];

			//Iterate thought each row one by one
			Iterator<Row> rowIterator = sheet.iterator();

			int i=0;
			int t=0;

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if(i++ !=0)
				{
					int k=t;
					t++;

					//for each row, iterate thought each column
					Iterator<Cell> cellIterator = row.cellIterator();
					int j=0;

					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						//check the cell type and format accordingly
						switch (cell.getCellType()) 
						{
						case Cell.CELL_TYPE_NUMERIC:
							//dataSets[k][j++]=cell.getStringCellValue();
							dataSets[k][j++] = String.valueOf(cell.getNumericCellValue());
							break;

						case Cell.CELL_TYPE_STRING:
							dataSets[k][j++]=cell.getStringCellValue();
							break;

						case Cell.CELL_TYPE_BOOLEAN:
							dataSets[k][j++]=cell.getStringCellValue();
							break;

						case Cell.CELL_TYPE_FORMULA:
							dataSets[k][j++]=cell.getStringCellValue();
							break;

						case Cell.CELL_TYPE_BLANK:
							dataSets[k][j++]=cell.getStringCellValue();
							break;
						}
					}
				}
			}
			file.close();
			return dataSets;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
