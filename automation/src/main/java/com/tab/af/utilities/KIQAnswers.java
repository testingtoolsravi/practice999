package com.tab.af.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class KIQAnswers {
	private static Map<String, Set<String>> kiqKeySet = new HashMap();

	@Test
	public void getKey() throws Exception {
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		String FilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\data\\KIQKeys.xlsx";
		try {
			fis = new FileInputStream(FilePath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}
		try {
			XSSFSheet sheet = workbook.getSheet("ANSWERKEYS");  
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
				Set<String> keySet = new HashSet<String>();
				Row currentRow = sheet.getRow(i);
				for (int j = 1; j < currentRow.getPhysicalNumberOfCells(); j++) {
					Cell currentCell = currentRow.getCell(j);
					if (currentCell.getCellType()==CellType.STRING) {
					 
						keySet.add(currentCell.getStringCellValue());
					}
					else if(currentCell.getCellType()==CellType.BLANK) {
						/////////////
					}
					else {
						currentCell.setCellType(CellType.STRING);
						keySet.add(currentCell.getStringCellValue());
						 
						 
					}
					kiqKeySet.put(currentRow.getCell(0).getStringCellValue(), keySet);
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new Exception("Exception Occured While Reading KIQ KeyMap Excel");
		}
		 

	}

	public Map<String, Set<String>> getKIQKeyMap() {
		return kiqKeySet;
	}

}
