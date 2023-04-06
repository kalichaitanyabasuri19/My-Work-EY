package TestCases;

import java.io.File;



public class Browser {
	WebDriver driver = null;
	public static WebDriver Open(WebDriver  driver,String browser ){
	if((browser.equals("IE"))||browser.equalsIgnoreCase("Interner Explorer")){
//	System.setProperty("webdriver.ie.driver","C:\\Users\\testuser\\Desktop\\workspace\\Frame Work jars\\Browsers jars\\IEDriverServer.exe");
//		DesiredCapabilities cap=DesiredCapabilities.internetExplorer();
//	cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
//			true);
//	
		WebDriverManager.InternetExplorer().setup();
	driver=new InternetExplorerDriver();  
//		DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
//	    driver = new PhantomJSDriver(capabilities);
//	    driver = new PhantomJSDriver();
		
		
	}
	else 
	if((browser.equals("Chrome"))||browser.equalsIgnoreCase("GC")){
	
		WebDriverManager.chromeDriver().setup();
		driver=new ChromeDriver();

	}	 
	
	else
	System.out.println("Browser "+browser+" doesn't exist");
	   return driver;
	}
}

