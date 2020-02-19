package com.tab.af.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Fillio {

	public static void UpdateTestResultsToExcel(String testDataFilePath, String sheetName, String tcStatus,
			String testCaseId) {
		Connection conn = null;
		Fillo fillo = new Fillo();
		try {
			conn = fillo.getConnection(
					"C:\\Users\\abhay\\git\\Tabparallel\\src\\test\\resources\\TestData\\TestDataSheet.xlsx");
			String query = String.format("UPDATE %s SET TestCaseStatus='%s' where TestCaseID='%s'", sheetName, tcStatus,
					testCaseId);
			conn.executeUpdate(query);
		} catch (FilloException e) {
			e.printStackTrace();
		}
	}

	private static Map<String, Set<String>> kiqKeySet = new HashMap();

	public static void getTestDataInMap()
			throws Exception {

		String question = "According to our records, within the last two years you purchased veterinary insurance for which one of the following pets?";
		String testDataFile = System.getProperty("user.dir") + "\\src\\main\\resources\\data\\KIQKeys.xlsx";
		String sheetName = "ANSWERKEYS";
		String fieldName = "SSN";
		if (question.contains("From the list below, what is the area code for phone number ending in")) {
			question = "From the list below, what is the area code for phone number ending in";
		}

		String query = String.format("SELECT * FROM " + sheetName);
		Fillo fillo = new Fillo();
		Connection conn = null;
		System.setProperty("ROW", "1");
		System.setProperty("COLUMN", "1");
		Recordset recordset = null;
		try {
			conn = fillo.getConnection(testDataFile);
			recordset = conn.executeQuery(query);
			Set<String> set = new HashSet<String>();
			while (recordset.next()) {
				ArrayList<String> mm = new ArrayList<String>();
//				for (int i=1;i<recordset.getFieldNames().size();i++) {
//
//					set.add(recordset.getField(i).name());
//
//				}
				for (String string : recordset.getFieldNames()) {
					mm.add(string);
				}
				kiqKeySet.put(recordset.getField(0).name(), set);
				System.out.print("sd");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Exception Occured While Readin KIQ KeyMap Excel");
		}
		conn.close();

	}

}
