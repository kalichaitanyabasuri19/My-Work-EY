package GlobalReusables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class Browser {
	WebDriver driver = null;
	public static WebDriver Open(WebDriver  driver,String browser ){
	if(browser.equals("IE")){
		
	System.setProperty("webdriver.ie.driver","D:\\Drivers\\IEDriverServer.exe");
	driver=new InternetExplorerDriver();  
	}
	else 
	if(browser.equals("Chrome")){
	System.setProperty("webdriver.chrome.driver","/home/pt025/workspace/Framework jars/chromedriver");
	driver=new ChromeDriver();
	}	 
	else 
	if(browser.equals("FF")){
	driver=new FirefoxDriver();	 
	}
	else
	System.out.println("Browser "+browser+" doesn't exist");
	 return driver;
}
}