package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Browser {
	WebDriver driver = null;
	public static WebDriver Open(WebDriver  driver,String browser ){
	if((browser.equals("IE"))||browser.equalsIgnoreCase("Interner Explorer")){
//	System.setProperty("webdriver.ie.driver","C:\\Users\\testuser\\Desktop\\workspace\\Frame Work jars\\Browsers jars\\IEDriverServer.exe");
	
	    
		WebDriverManager.iedriver().setup();
		  driver = new InternetExplorerDriver();
//		DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
//	    driver = new PhantomJSDriver(capabilities);
//	    driver = new PhantomJSDriver();
	}
	
	else if((browser.equals("Chrome"))||browser.equalsIgnoreCase("GC")){
	
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}	 
	else if((browser.equals("edge"))||browser.equalsIgnoreCase("EDGE")){
		
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}	 
	
	
	else
	System.out.println("Browser "+browser+" doesn't exist");
	   return driver;
	}
}

