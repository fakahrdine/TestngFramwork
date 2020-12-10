package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// we are creating 

public class ExecelUtility {
	private static Workbook wbook;
	private static Sheet sheet;

	/**
	 * this method will open excel file and specified sheet
	 * 
	 * @param filePath
	 * @param sheetName
	 */
	public static void openExcel(String filePath, String sheetName) {

		try {
			FileInputStream fis = new FileInputStream(filePath);
			wbook = new XSSFWorkbook(fis);
			sheet = wbook.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static int rowCount() {
		return sheet.getPhysicalNumberOfRows();

	}

	public static int cellCount() {
		return sheet.getRow(0).getLastCellNum();
	}

	public static String getCellData(int rowIndex, int cellIndex) {
		return sheet.getRow(rowIndex).getCell(cellIndex).toString();
	}

	/**
	 * this method will read any excel file and return data in 2d arrray
	 * 
	 * @param filePath
	 * @param sheetName
	 * @return
	 */
	public static Object[][] exelIntoArray(String filePath, String sheetName) {
		openExcel(filePath, sheetName);
		int rows = rowCount();
		int cols = cellCount();

		Object[][] data = new Object[rows - 1][cols];
		for (int r = 1; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				data[r - 1][c] = getCellData(r, c);

			}

		}
		return data;

	}

}
