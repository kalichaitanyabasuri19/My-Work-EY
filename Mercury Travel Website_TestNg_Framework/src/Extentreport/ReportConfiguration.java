package Extentreport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Reusables.common_methods;
public class ReportConfiguration  extends common_methods{
 
 public static ExtentHtmlReporter htmlReporter;
 public static ExtentReports extent;
 public static ExtentTest logger;
 
 public  static void ExtendReportConfiguraiton() {
  System.out.print(System.getProperty("user.dir"));
  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport/ExtentReport.html");
  extent = new ExtentReports();
  extent.attachReporter(htmlReporter);
  extent.setSystemInfo("Host Name", "");
  extent.setSystemInfo("Environment", "QA");
  extent.setSystemInfo("User Name", "");
  htmlReporter.config().setDocumentTitle("Auatomaiton Results");
 }
}

