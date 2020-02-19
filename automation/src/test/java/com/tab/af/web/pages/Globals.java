package com.tab.af.web.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;

public class Globals {
	private List<String> email = new ArrayList<String>();
	private static Map<String, Set<String>> kiqKeySet = new HashMap();
	/**Fetch Build Version from Source Code of Onboard UI
	 * @param Source
	 * @return
	 */
	public String getBuildVersionFromSource(String Source) {
		int a = Source.indexOf("\"applicationVersion\": ");
		int b = Source.indexOf("});");
		String m = Source.substring(a, b);
		return m.replace("applicationVersion", "").replace("\"", "").replace(":", "");
	}

	/** Validate whether the Download Directory contains File with Specified Name and then Delete 
	 * @param fileName
	 * @return
	 */
	public boolean isFileDownloaded(String fileName) {
		String home = System.getProperty("user.home");
		File dir = new File(home + "/Downloads/");
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {

				dirContents[i].delete();
				return true;
			}
		}
		return false;
	}

	/**
	 * List of Email which are least likely to be flagged by System
	 * 
	 * @return Email String
	 */
	public String lowRiskEmail() {
		if (email.size() == 0) {
			email.add("johnsmith1975@gmail.com");
			email.add("stephensmith@gmail.com");
			email.add("billsmith@yahoo.com");
			email.add("bobsmith@aol.com");
		}
		return email.get(new Random().nextInt(email.size()));

	}

	/** Format yyyyMMdd date to MMddyyyy
	 * @param input
	 * @return
	 */
	public String formatDateString(String input) {
		SimpleDateFormat inSDF = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat outSDF = new SimpleDateFormat("MMddyyyy");
		Date date = null;
		try {
			date = inSDF.parse(input);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		input = outSDF.format(date);
		return input;
	}


	 
	public void setKIQKeySet() throws Exception {
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		String FilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\OnBoardTestData\\KIQKeys.xlsx";
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
					Cell currentCell = currentRow.getCell(j,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					try {
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
					}
					catch(NullPointerException ee)
					{
						System.out.print("sdsd");
					}
					kiqKeySet.put(currentRow.getCell(0).getStringCellValue(), keySet);
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new Exception("Exception Occured While Reading KIQ KeyMap Excel");
		}
		 

	}

	public Map<String, Set<String>> getKIQKeyMap() throws Exception {
		 if(kiqKeySet.isEmpty()) {
			setKIQKeySet();
		 }
		return kiqKeySet;
	}
	public void assertStringEquals(String actualText,String expectedText) throws Exception {
		
		if(actualText.equals(expectedText)){
			Assert.assertTrue(true);
		}
		else {
			throw new Exception("Assert Equals Fail Expected: "+expectedText+",Actual: "+actualText);
		}
		
	}
public void assertEquals(boolean actual,boolean expected) throws Exception {
		
		if(actual==expected){
			Assert.assertTrue(true);
		}
		else {
			throw new Exception("Assert Equals Fail Expected: "+expected+",Actual: "+actual);
		}
		
	}
}

 
