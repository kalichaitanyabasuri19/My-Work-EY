
package GlobalReusables;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class HTMLResults {

	public static final String DATE_FORMAT_NOW = "dd-MM-yyyy HH:mm:ss";
	
	public static String DateTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());
	}

	public static void CreateHTMLResult(String strFilePath, long time,
			String startTime, String endTime, String app_version,
			String browser, String browser_version,String URL) {
		String strHTMLFileName = strFilePath.replace(".xls", " Report.html");
		// Create new HTML file.
		File file = new File(strHTMLFileName);
		try {
			file.createNewFile();
			FileWriter fstream = new FileWriter(strHTMLFileName);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(getHTMLPageHeader());
			out.write(getTestDetails(time, startTime, endTime, app_version,
					browser, browser_version,URL));
			out.write(getTestResults(strFilePath));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void HTMLTestCases(String strFilePath, long time,
			String startTime, String endTime, String app_version,
			String browser, String browser_version,String URL) {
		String strHTMLFileName = strFilePath.replace(".xls", "_Test_Report.html");
		// Create new HTML file.
		File file = new File(strHTMLFileName);
		try {
			file.createNewFile();
			FileWriter fstream = new FileWriter(strHTMLFileName);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(getHTMLPageHeader());
			out.write(getTestDetails(time, startTime, endTime, app_version,
					browser, browser_version,URL));
			out.write(TestCases_Result(strFilePath));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public static void HTMLPassTestCases(String strFilePath) {
		String strHTMLFileName = strFilePath.replace(".xls",
				"_Passed_TestCase_Report.html");
		// Create new HTML file.
		File file = new File(strHTMLFileName);
		try {
			file.createNewFile();
			FileWriter fstream = new FileWriter(strHTMLFileName);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(getHTMLPageHeader());
			
			out.write(PassTestCases_Result(strFilePath));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void HTMLFailTestCases(String strFilePath) {
		String strHTMLFileName = strFilePath.replace(".xls",
				"_Failed_TestCase_Report.html");
		// Create new HTML file.
		File file = new File(strHTMLFileName);
		try {
			file.createNewFile();
			FileWriter fstream = new FileWriter(strHTMLFileName);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(getHTMLPageHeader());
			out.write(FailTestCases_Result(strFilePath));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void HTMLSkipTestCases(String strFilePath) {
		String strHTMLFileName = strFilePath.replace(".xls",
				"_Skipped_TestCases_Report.html");
		// Create new HTML file.
		File file = new File(strHTMLFileName);
		try {
			file.createNewFile();
			FileWriter fstream = new FileWriter(strHTMLFileName);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(getHTMLPageHeader());
			out.write(Skipped_TestCases_Result(strFilePath));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static String getHTMLPageHeader() {

		String strCSS = " body { 	" +
				"margin-top: 10px; 	" +
				"margin-right: 0px; 	" +
				"margin-bottom: 0px; 	" +
				"margin-left: 0px; 	" +
				"background-image:url(); } " +
				" .formTable {" +
				"clear:both;padding-bottom:30px;padding-left:1px;padding-bottom:1px;text-align:center;font-size:90%;height:1%; border:1px solid #2166ab;} " +
				".formTable table " +
				"{" +
				"border:1px solid #fff;" +
				"width:100%;height:25%" +
				"} " +
				".formTable tr " +
				"{" +
				"background-color:#fff;" +
				"} " +
				".formTable th {height:35px;} " +
				".formTable td {height:25px;} .formTable .header {padding:3px;background-color:#1ECE56;border-bottom:1px solid #fff;border-top: 0px solid #fff;border-right:1px solid #bbb;vertical-align:center;color:#ffffff;font-family:Arial;font-weight:bold;font-size:13px;text-align:left;} .formTable .first {padding-left:5px;background-color:#C5C7DC;border-right:1px solid #bbb;color:#000000;font-family:Arial;font-weight:Bold;font-size:11px;} .formTable " +
				".second " +
				" {" +
				"padding-left:5px;" +
				"background-color:#5C5A5A;" +
				"border-right:1px solid #bbb;" +
				"color:#ede9e9;" +
				"font-family:Arial;font-weight:" +
				"bold;font-size:12px;" +
				"line-height:25px; " +
				"vertical-align:top" +
				"}" +
				".fail " +
				" {" +
				"padding-left:5px;" +
				"background-color:#5C5A5A;" +
				"border-right:1px solid #bbb;" +
				"color:#E64646;" +
				"font-family:Arial;font-weight:" +
				"bold;font-size:12px;" +
				"line-height:25px; " +
				"vertical-align:top" +
				"}"+
				".skip " +
				" {" +
				
				"background-color:#5C5A5A;" +
				"padding-left:5px;" +
				"border-right:1px solid #bbb;" +
				"color:#f3e805;" +
				"font-family:Arial;font-weight:" +
				"bold;font-size:12px;" +
				"line-height:25px; " +
				"vertical-align:top" +
				"}"+
				".Pass " +
				" {" +
				
				"background-color:#5C5A5A;" +
				"padding-left:5px;" +
				"border-right:1px solid #bbb;" +
				"color:#1ECE56;" +
				"font-family:Arial;font-weight:" +
				"bold;font-size:12px;" +
				"line-height:25px; " +
				"vertical-align:top" +
				"}"+
				" .formTable .third  {padding-left:5px;background-color:#ecedef;border-right:1px solid #bbb;color:#000000;font-family:Arial;font-weight:Regular;font-size:11px;line-height:22px; vertical-align:top} .formTable a:link, a:visited {color:#FF0A0A;} .formTable .a {color:#FF0A0A;font-family:Arial;font-weight:Regular;font-size:11px;text-decoration:underline;} " +
				".formTable .text {text-align:left;} " +
				".formTable .num {text-align:right;}  .row_alter{ 	background-color:#ecedef; 	}  table { 	width:100%; 	 }" +
				".div_bg_heading" +
				"{" +
				"font-family: Arial, Helvetica, sans-serif;" +
				"font-size: 13px;" +
				"font-weight:bold;" +
				"color: #000000;" +
				"padding-top:12px; 	" +
				"padding-left:8px; 	" +
				"padding-bottom:8px; 	 	" +
				"}   " +
				"a.link " +
				"{ 	" +
				"font-family:\"Arial,verdana,tahoma\";" +
				"font-size:11px;" +
				"font-weight:normal; 	" +
				"color: #013d72; 	" +
				"text-decoration:underline; 	" +
				"cursor:pointer; " +
				"} " +
				"a.link:hover { 	" +
				"font-family:\"Arial,verdana,tahoma\"; 	" +
				"font-size:11px; 	" +
				"font-weight:normal; 	" +
				"color: #013d72; 	" +
				"text-decoration:none; " +
				"} " +
				"/* Bottom */ .footer " +
				"{ 	" +
				"height:21px;" +
				" 	background-color:#2166ab; 	" +
				"border-top:1px solid #e6e6e6;	 " +
				"} .ALTText {    background: none repeat scroll 0 0;    border-bottom: 0px solid #FFFFFF;    border-left: 0px solid #FFFFFF;   border-right: 0px solid white;    color: White;    font-family: Tahoma,Helvetica,sans-serif;    font-size: 35px;    font-weight: bold;    height: 70px;    padding-bottom: 5px;    padding-left: 1px;    padding-top: 4px;    text-align: center;}";

		String strPageHeader = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"><html><head><title>Result</title><meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">"
				+ "<style type=\"text/css\">"

				+ strCSS
				+ "</style>"
				+ "</head><body>"

				+ "<a name=\"section0\"><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" height=\"35%\"><tr><td><img src=\"file:\\C:\\Users\\RU819TQ\\eclipse-workspace\\Hybrid_Framework\\src\\main\\java\\TestData\\Ey.png\" alt=\"logo\" style=\"border-width:0px;\"></td><td class=\"ALTText\">"
				+ "EY Training:"
				+ "</td></tr><tr  class=\"header\">";

		return strPageHeader;

	}

	@SuppressWarnings("unused")
	private static String getValidationDetails() {
		String strTestResult = null;
		String ValidationCases = "./testResultValidationTestCases.html";
		strTestResult = strTestResult
				+ "<td class=\"div_bg_heading\"><a class=\"div_bg_heading\" href=\""
				+ ValidationCases
				+ "\" style=\"color:#ffffff\">Click here for Validation Results</td>";
		return strTestResult;
	}

	private static String getTestDetails(long time, String startTime,
			String endTime, String version, String browser,
			String browser_version,String URL) {

		long millis = time;
		String hms = String.format(
				"%02d:%02d:%02d",
				TimeUnit.MILLISECONDS.toHours(millis),
				TimeUnit.MILLISECONDS.toMinutes(millis)
						- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
								.toHours(millis)),
				TimeUnit.MILLISECONDS.toSeconds(millis)
						- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
								.toMinutes(millis)));

		// String
		// strTestDetails="<tr><td class=\"div_bg_heading\">"+"Total Time of Execution :: "+hms+" Seconds</td><td class=\"div_bg_heading\"></td></tr>";
		String strTestDetails = "<tr><td class=\"div_bg_heading\">"
				+ "Application URL: " + URL + "</tr>";
		strTestDetails = strTestDetails + "<tr><td class=\"div_bg_heading\">"
				+ "Executed on system:" +" "+  System.getProperty("user.name") +"</td></tr>";
			
		strTestDetails = strTestDetails + "<tr><td class=\"div_bg_heading\">"
		+ "Browser Type : " + browser+ "</td><td class=\"div_bg_heading\">"
				+ "Execution Start Time: " + startTime + "</td></tr>";
		strTestDetails = strTestDetails + "<tr>	<td class=\"div_bg_heading\">" + "Browser Version      : "
		+ browser_version + "</td><td class=\"div_bg_heading\">"
				+ "Execution End Time: " + endTime + "</td></tr>";
		strTestDetails = strTestDetails + "<tr><td class=\"div_bg_heading\">"
		+ "Operating System: " + System.getProperty("os.name")
		+ "</td><td class=\"div_bg_heading\">"
				+ "Total Test Execution Time: " + hms + " Seconds</td></tr>";
		return strTestDetails;
	}private static String getTestDetails1(long time, String startTime,
			String endTime, String version, String browser,
			String browser_version,String URL) {

		long millis = time;
		String hms = String.format(
				"%02d:%02d:%02d",
				TimeUnit.MILLISECONDS.toHours(millis),
				TimeUnit.MILLISECONDS.toMinutes(millis)
						- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
								.toHours(millis)),
				TimeUnit.MILLISECONDS.toSeconds(millis)
						- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
								.toMinutes(millis)));

		String strTestDetails = "<tr><td class=\"div_bg_heading\">"
			+ "Performance Test Results For Danaher"+ "</td></tr>";
		 strTestDetails = "<tr><td class=\"div_bg_heading\">"
				+ "Application URL: " + URL
				+ "</td><td class=\"div_bg_heading\">"
				+ "Application Version: " + version + "</td></tr>";
		strTestDetails = strTestDetails + "<tr><td class=\"div_bg_heading\">"
		+ "Company Code: <b>6700</b>"
		+ "</td><td class=\"div_bg_heading\">"
				+ "Executed on system:" +" "+  System.getProperty("user.name") +"</td></tr>";
			
		strTestDetails = strTestDetails + "<tr><td class=\"div_bg_heading\">"
		+ "Browser Type : " + browser+ "</td><td class=\"div_bg_heading\">"
				+ "Execution Start Time: " + startTime + "</td></tr>";
		strTestDetails = strTestDetails + "<tr>	<td class=\"div_bg_heading\">" + "Browser Version      : "
		+ browser_version + "</td><td class=\"div_bg_heading\">"
				+ "Execution End Time: " + endTime + "</td></tr>";
		strTestDetails = strTestDetails + "<tr><td class=\"div_bg_heading\">"
		+ "Operating System: " + System.getProperty("os.name")
		+ "</td><td class=\"div_bg_heading\">"
				+ "Total Test Execution Time: " + hms + " Seconds</td></tr>";
		strTestDetails = strTestDetails + "<tr><td class=\"div_bg_heading\">"
		+ "<b>Performance Test Results For Danaher:</b>"
		+ "</td><td class=\"div_bg_heading\">"
				+ "Executed on system:" +" "+  System.getProperty("user.name") +"</td></tr>";
		return strTestDetails;
	}

	
	private static String TestCases_Result(String strFilePath) {
		String strTestCases = null;
		strTestCases = "<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" height=\"40%\">" +
				"<tr><td></td></tr>" +
				"<tr class=\"div_bg\"><td class=\"div_bg_heading\">"+ "</td></tr>" +
				"<tr><td class=\"con\" valign=\"top\"><div class=\"formTable\">"
				+ "<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" height=\"100%\"><tr><th class=\"header\" width=\"15%\">Test Scenario Name</th>"
				+ "<th class=\"header\" width=\"10%\">Test Case Status</th></tr>";

		Datatable dtResults = new Datatable();

		dtResults.openExcelSheet(strFilePath);
		
	
		for (int iTestStep = 1; iTestStep < dtResults.getRowCount(); iTestStep++) {
			
			String testCases1 = dtResults.getValuefromCell("TestCase", iTestStep);
			String[] tcs = testCases1.split("/");
			
			 String testScenario = dtResults.getValuefromCell("Scenario",iTestStep);
						
			String testCases = dtResults.getValuefromCell("Scenario", iTestStep);
		

			// null is not splitting
			if (!testCases.equalsIgnoreCase("")) {
				String[] methods = testCases.split("/");
				String testCaseStatus = dtResults.getValuefromCell("TEST RESULT", iTestStep);
			
				if (testCaseStatus.equalsIgnoreCase("Fail")) {
					strTestCases = strTestCases + "<tr>"
							+ "<td class=\"second\">" + testScenario + "</td>";
					String r1 = "./src/Screen shots\\" + tcs[1]+".png";
					String resultPath="file:///" + r1;
					strTestCases = strTestCases
							
						+
							"<td class=\"fail\"><a href=\""
							+ resultPath + "\" >"
							+ testCaseStatus + "</td>";
									
				} 
				else if (testCaseStatus.equalsIgnoreCase("Skipped")) {
				
					strTestCases = strTestCases + "<tr>"
							+ "<td class=\"second\">" + testScenario + "</td>";
					strTestCases = strTestCases
							+ "<td class=\"second\">" 
							+ testCaseStatus+ "</td>";
				} 
				else if(testCaseStatus.equalsIgnoreCase("Pass")){
					
					strTestCases = strTestCases + "<tr>"
					+ "<td class=\"second\">" + testScenario + "</td>";
			strTestCases = strTestCases
					+ "<td class=\"second\">" 
				
					+ testCaseStatus+ "</td>";
							
				}
			}
		
		}
		return strTestCases;
	
		}
	
//	private static String Performance(String strFilePath) {
//		String strTestCases = null;
//		
//		strTestCases = "<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" height=\"40%\">" +
//				"<tr><td></td></tr>" +
//				"<tr class=\"div_bg\"><td class=\"div_bg_heading\">"+ "</td></tr>" +
//				"<tr><td class=\"con\" valign=\"top\"><div class=\"formTable\">"
//				+ "<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" height=\"100%\"><tr><th class=\"header\" width=\"15%\">Test Scenario Name</th><th class=\"header\" width=\"10%\">Time in Secs</th>"+"</tr>";
//
//		Datatable dtResults = new Datatable();
//		dtResults.openExcelSheet(strFilePath);
//		
//	
//		for (int iTestStep = 1; iTestStep < dtResults.getRowCount(); iTestStep++) {
//			 String testScenario = dtResults.getValuefromCell("Scenario Name",iTestStep);
//			 String ScenarioRequired=dtResults.getValuefromCell("Scenario_Required", iTestStep);
//			String testCases = dtResults.getValuefromCell("TestCase", iTestStep);
//			// null is not splitting
//			if (!testCases.equalsIgnoreCase("")) {
//				if(ScenarioRequired.equalsIgnoreCase("Yes")||ScenarioRequired.equalsIgnoreCase("yes")){
//				String[] methods = testCases.split("/");
//				String testCaseStatus = dtResults.getValuefromCell("Time in sec", iTestStep);
//			//	HTMLResults h=new HTMLResults();
//				if(!(testCaseStatus=="")){
////				value=Integer.parseInt(testCaseStatus);
//			if(testCaseStatus!=null){
//				int c=5;
//			
//				
//				
////				if (value>=c) {
////					strTestCases = strTestCases + "<tr>"
////							+ "<td class=\"second\">" + testScenario + "</td>";
//////					strTestCases = strTestCases + "<td class=\"second\">"
//////							+ methods[1] + "</td>";
////					strTestCases = strTestCases
////							+ "<td class=\"fail\">" +value+ "</td>"+"</tr>";
////									
////				
////				} 
////				else if(value==0){
////					strTestCases = strTestCases + "<tr>"
////					+ "<td class=\"skip\">" + testScenario + "</td>";
//////			strTestCases = strTestCases + "<td class=\"second\">"
//////					+ methods[1] + "</td>";
////			strTestCases = strTestCases
////					+ "<td class=\"fail\">" +" "+ "</td>"+"</tr>";
//				}
//			
//				else {
//					strTestCases = strTestCases + "<tr>"
//					+ "<td class=\"second\">" + testScenario + "</td>";
////			strTestCases = strTestCases + "<td class=\"second\">"
////					+ methods[1] + "</td>";
////			strTestCases = strTestCases
////					+ "<td class=\"second\">" +value+ "</td>"+"</tr>";
//				}
//				}
//			
//			}
//			}
//		
//	
//		}
//		return strTestCases;
//	
//		}
	private static String PassTestCases_Result(String strFilePath) {
		String strTestCases = null;
		strTestCases = "<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" height=\"40%\"><tr><td></td></tr><tr class=\"div_bg\"><td class=\"div_bg_heading\">Passed Test Case Details"
				+ "</td></tr><tr><td class=\"con\" valign=\"top\"><div class=\"formTable\">"
				+ "<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" height=\"100%\"><tr><th class=\"header\" width=\"10%\">Test Case Details</th><th class=\"header\" width=\"10%\">Test Case Status</th></tr>";

		Datatable dtResults = new Datatable();

		dtResults.openExcelSheet(strFilePath);
		for (int iTestStep = 1; iTestStep < dtResults.getRowCount(); iTestStep++) {
			// String resultPath="D://Execution/VisiLog_3.2.1/logo.jpg";
			// String testScenario=dtResults.getValuefromCell(1, iTestStep);
			String testCases = dtResults
					.getValuefromCell("TestCase", iTestStep);
			String[] tcs = testCases.split("/");
			String testCaseStatus = dtResults.getValuefromCell("TEST RESULT",
					iTestStep);
			if (testCaseStatus.equalsIgnoreCase("Pass")) {
				strTestCases = strTestCases + "<tr>" + "<td class=\"second\">"
						+ tcs[0] + "</td>";
				strTestCases = strTestCases + "<td class=\"second\">"
						+ testCaseStatus + "</td>";
				// <a class=\"second\" href=\""+resultPath+"\"
				// style=\"color:#ffffff\">
			}
		}
		return strTestCases;
		
	}

	private static String FailTestCases_Result(String strFilePath) {
		String strTestCases = null;
		strTestCases = "<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" height=\"40%\"><tr><td></td></tr><tr class=\"div_bg\"><td class=\"div_bg_heading\">Failed Test Case Details"
				+ "</td></tr><tr><td class=\"con\" valign=\"top\"><div class=\"formTable\">"
				+ "<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" height=\"100%\"><tr><th class=\"header\" width=\"10%\">Test Case Details</th><th class=\"header\" width=\"10%\">Test Case Status</th></tr>";

		Datatable dtResults = new Datatable();

		dtResults.openExcelSheet(strFilePath);
		for (int iTestStep = 1; iTestStep < dtResults.getRowCount(); iTestStep++) {

			String testCases = dtResults
					.getValuefromCell("TestCase", iTestStep);
			String[] tcs = testCases.split("/");
			String testCaseStatus = dtResults.getValuefromCell("TEST RESULT",
					iTestStep);
			if (testCaseStatus.equalsIgnoreCase("Fail")) {
				@SuppressWarnings("unused")
				String testMethod = dtResults.getValuefromCell("TestCase",
						iTestStep);

				String resultPath = ".\\src\\Screenshots\\" + tcs[1]
						+ ".jpg";
				String logPath = "./src/Error Log/" + tcs[0]
						+ ".html";

				// logPath="file:///"+logPath;
				resultPath = "file:///" + resultPath;
				strTestCases = strTestCases + "<tr>"
						+ "<td class=\"second\"><a class=\"second\" href=\""
						+ logPath + "\" style=\"color:#ffffff\">" + tcs[0]
						+ "</td>";
				strTestCases = strTestCases
						+ "<td class=\"second\"><a class=\"second\" href=\""
						+ resultPath + "\" style=\"color:#ffffff\">"
						+ testCaseStatus + "</td>";

			}
		}
		return strTestCases;
	}

	private static String Skipped_TestCases_Result(String strFilePath) {
		String strTestCases = null;
		strTestCases = "<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" height=\"40%\"><tr><td></td></tr><tr class=\"div_bg\"><td class=\"div_bg_heading\">Skipped Test Case Details"
				+ "</td></tr><tr><td class=\"con\" valign=\"top\"><div class=\"formTable\">"
				+ "<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" height=\"100%\"><tr><th class=\"header\" width=\"10%\">Test Case Details</th><th class=\"header\" width=\"10%\">Test Case Status</th></tr>";

		Datatable dtResults = new Datatable();

		dtResults.openExcelSheet(strFilePath);
		for (int iTestStep = 1; iTestStep < dtResults.getRowCount(); iTestStep++) {

			// String testScenario=dtResults.getValuefromCell(1, iTestStep);
			String testCases = dtResults
					.getValuefromCell("TestCase", iTestStep);
			String[] tcs = testCases.split("/");
			String testCaseStatus = dtResults.getValuefromCell("TEST RESULT",
					iTestStep);
			if (testCaseStatus.equalsIgnoreCase("Skipped")) {
				strTestCases = strTestCases + "<tr>" + "<td class=\"second\">"
						+ tcs[0] + "</td>";
				strTestCases = strTestCases + "<td class=\"second\">"
						+ testCaseStatus + "</td>";
				// <a class=\"second\" href=\""+resultPath+"\"
				// style=\"color:#ffffff\">
			}
		}
		return strTestCases;
		
	}

	@SuppressWarnings("static-access")
	private static String getTestResults(String strFilePath) {
		String strTestResult = null;
		// strTestResult="<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" height=\"40%\"><tr><td></td></tr><tr class=\"div_bg\"><td class=\"div_bg_heading\">Test Execution Details"+"</td></tr><tr><td class=\"con\" valign=\"top\"><div class=\"formTable\">"
		// +"<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" height=\"100%\"><tr><th class=\"header\" width=\"10%\">Test Step Details</th><th class=\"header\" width=\"10%\">Test Results</th></tr>";
		strTestResult = "<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" height=\"40%\"><tr><td class=\"con\" valign=\"top\"><div class=\"formTable\">"
				+ "<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" height=\"100%\"><tr><th class=\"header\" width=\"10%\">Test Step Details</th><th class=\"header\" width=\"10%\">Test Results</th></tr>";
		Datatable dtResults = new Datatable();

		dtResults.openExcelSheet(strFilePath);
		int passCount = 0;
		int tCCount = 0;
		int failCount = 0;
		int skipCount = 0;

		for (int iTestStep = 1; iTestStep < dtResults.getRowCount(); iTestStep++) {
			if (!dtResults.getValuefromCell("TestCase", iTestStep)
					.equalsIgnoreCase(""))
				tCCount = tCCount + 1;
			if (dtResults.getValuefromCell("TEST RESULT", iTestStep)
					.equalsIgnoreCase("Pass"))
				passCount = passCount + 1;
			if (dtResults.getValuefromCell("TEST RESULT", iTestStep)
					.equalsIgnoreCase("Fail"))
				failCount = failCount + 1;
			if (dtResults.getValuefromCell("TEST RESULT", iTestStep)
					.equalsIgnoreCase("Skipped"))
				skipCount = skipCount + 1;

		}
		// String resultPath="D://logo.jpg";
		String testCases = "./Training_Result_Test_Report.html";
		String PassTestCases = "./Training_Result_Passed_TestCase_Report.html";
		String FailTestCases = "./Training_Result_Failed_TestCase_Report.html";
		String SkipTestCases = "./Training_Result_Skipped_TestCases_Report.html";
		@SuppressWarnings("unused")
		String ValidationCases = "./testResultValidationTestCases.html";
		strTestResult = strTestResult + "<tr>" + "<td class=\"second\">"
				+ "Total Number Of Test Cases Executed" + "</td>";
		strTestResult = strTestResult
				+ "<td class=\"second\"><a class=\"second\" href=\""
				+ testCases + "\" style=\"color:#ffffff\">" + tCCount + "</td>";
		strTestResult = strTestResult + "<tr>" + "<td class=\"second\">"
				+ "Total Number Of Test Cases Passed" + "</td>";
		strTestResult = strTestResult
				+ "<td class=\"second\"><a class=\"second\" href=\""
				+ PassTestCases + "\" style=\"color:#ffffff\">" + passCount
				+ "</td>";
		strTestResult = strTestResult + "<tr>" + "<td class=\"second\">"
				+ "Total Number Of Test Cases Failed" + "</td>";
		strTestResult = strTestResult
				+ "<td class=\"second\"><a class=\"second\" href=\""
				+ FailTestCases + "\" style=\"color:#ffffff\">" + failCount
				+ "</td>";
		strTestResult = strTestResult + "<tr>" + "<td class=\"second\">"
				+ "Total Number Of Test Cases Skipped" + "</td>";
		strTestResult = strTestResult
				+ "<td class=\"second\"><a class=\"second\" href=\""
				+ SkipTestCases + "\" style=\"color:#ffffff\">" + skipCount
				+ "</td>";
		// strTestResult = strTestResult+
		// "<td class=\"div_bg_heading\"><a class=\"div_bg_heading\" href=\""+ValidationCases+"\" style=\"color:#ffffff\">Click here for Validation Results</td>";
		/*
		 * for(int iTestStep=1;iTestStep<dtResults.getRowCount();iTestStep++)
		 * if(dtResults.getValuefromCell(9,iTestStep).equalsIgnoreCase("Pail"))
		 * { String strImageFile="image_"+iTestStep+"_.png"; strTestResult =
		 * strTestResult+
		 * "<td class=\"second\"><a href=\""+strImageFile+"\">"+dtResults
		 * .getValuefromCell(9,iTestStep)+ "</a></td>"; strTestResult =
		 * strTestResult + "</tr>"; } else { strTestResult = strTestResult+
		 * "<td class=\"second\">"+dtResults.getValuefromCell(9,iTestStep)+
		 * "</td>"; strTestResult = strTestResult + "</tr>"; }
		 */
		dtResults.closeFile();
		return strTestResult;
	}

	/*
	 * public static void main(String[] args) { HTMLResults htm = new
	 * HTMLResults();
	 * htm.CreateHTMLResult("./src/Driver/VL_DriverSheet.xls",10);
	 * 
	 * }
	 */
//	private static String getTestResults1(String strFilePath) {
//		String strTestResult = null;
//		// strTestResult="<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" height=\"40%\"><tr><td></td></tr><tr class=\"div_bg\"><td class=\"div_bg_heading\">Test Execution Details"+"</td></tr><tr><td class=\"con\" valign=\"top\"><div class=\"formTable\">"
//		// +"<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" height=\"100%\"><tr><th class=\"header\" width=\"10%\">Test Step Details</th><th class=\"header\" width=\"10%\">Test Results</th></tr>";
//		strTestResult = "<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" height=\"40%\"><tr><td class=\"con\" valign=\"top\"><div class=\"formTable\">"
//				+ "<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" height=\"100%\"><tr><th class=\"header\" width=\"10%\">Test Step Details</th><th class=\"header\" width=\"10%\">Test Results</th></tr>";
//		Datatable dtResults = new Datatable();
//
//		dtResults.openExcelSheet(strFilePath);
//		int passCount = 0;
//		int tCCount = 0;
//		int failCount = 0;
//		int skipCount = 0;
//
//		for (int iTestStep = 1; iTestStep < dtResults.getRowCount(); iTestStep++) {
//			if (!dtResults.getValuefromCell("TestCase", iTestStep)
//					.equalsIgnoreCase(""))
//				tCCount = tCCount + 1;
//			if (!(dtResults.getValuefromCell("Time in sec", iTestStep)
//					.equalsIgnoreCase("")))
//				passCount = passCount + 1;
//		}
//		// String resultPath="D://logo.jpg";
//		String testCases = "./Training_Report Test Report.html";
//		String PassTestCases = "./Training_Report Passed_TestCase_Report.html";
//		@SuppressWarnings("unused")
//		String ValidationCases = "./testResultValidationTestCases.html";
//		strTestResult = strTestResult + "<tr>" + "<td class=\"second\">"
//				+ "Total Number Of Test Cases Executed" + "</td>";
//		strTestResult = strTestResult
//				+ "<td class=\"second\"><a class=\"second\" href=\""
//				+ testCases + "\" style=\"color:#ffffff\">" + tCCount + "</td>";
//		strTestResult = strTestResult + "<tr>" + "<td class=\"second\">"
//				+ "Total Number Of Test Cases Passed" + "</td>";
//		strTestResult = strTestResult
//				+ "<td class=\"second\"><a class=\"second\" href=\""
//				+ PassTestCases + "\" style=\"color:#ffffff\">" + passCount
//				+ "</td>";
////		strTestResult = strTestResult + "<tr>" + "<td class=\"second\">"
////				+ "Total Number Of Test Cases Failed" + "</td>";
////		strTestResult = strTestResult
////				+ "<td class=\"second\"><a class=\"second\" href=\""
////				+ FailTestCases + "\" style=\"color:#ffffff\">" + failCount
////				+ "</td>";
////		strTestResult = strTestResult + "<tr>" + "<td class=\"second\">"
////				+ "Total Number Of Test Cases Skipped" + "</td>";
////		strTestResult = strTestResult
////				+ "<td class=\"second\"><a class=\"second\" href=\""
////				+ SkipTestCases + "\" style=\"color:#ffffff\">" + skipCount
////				+ "</td>";
//		// strTestResult = strTestResult+
//		// "<td class=\"div_bg_heading\"><a class=\"div_bg_heading\" href=\""+ValidationCases+"\" style=\"color:#ffffff\">Click here for Validation Results</td>";
//		/*
//		 * for(int iTestStep=1;iTestStep<dtResults.getRowCount();iTestStep++)
//		 * if(dtResults.getValuefromCell(9,iTestStep).equalsIgnoreCase("Pail"))
//		 * { String strImageFile="image_"+iTestStep+"_.png"; strTestResult =
//		 * strTestResult+
//		 * "<td class=\"second\"><a href=\""+strImageFile+"\">"+dtResults
//		 * .getValuefromCell(9,iTestStep)+ "</a></td>"; strTestResult =
//		 * strTestResult + "</tr>"; } else { strTestResult = strTestResult+
//		 * "<td class=\"second\">"+dtResults.getValuefromCell(9,iTestStep)+
//		 * "</td>"; strTestResult = strTestResult + "</tr>"; }
//		 */
//		dtResults.closeFile();
//		return strTestResult;
//	}

}
