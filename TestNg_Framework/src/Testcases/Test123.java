package Testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Reusables.Steps;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test123  extends Steps {

	public Test123() {
		// TODO Auto-generated constructor stub
		
	
			
		}
	public static void main(String [] args ) throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver =new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.mercurytravels.co.in/flights");
		selectDate(driver,2022,"Nov","25");
		
	}
	 public static void selectDate(WebDriver driver,int year,String month, String select_day) throws InterruptedException
	 { Steps s= new Steps();
//	 s.verifyloginWithoutEnteringUserCreadentials(driver,"kalichaitanya.basuri19@gmail.com","password4321");	 
//	 s.login(driver,"kalichaitanya.basuri19@gmail.com","password4321");
	 driver.findElement(By.name("departDate")).click();
	 String d=driver.findElement(By.xpath("((//div[@class='datepicker-days'])[3]//th)[2]")).getText();
//	 String [] ss=d.split(" ");
	 
//	 String month1=ss[0].substring(1,3).toLowerCase();
//	 int year1 =Integer.parseInt(ss[1]);
	driver.findElement(By.xpath("((//div[@class='datepicker-days'])[3]//th)[2]")).click();
	driver.findElement(By.xpath("((//div[@class='datepicker-months'])[3]//th)[2]")).click();
	driver.findElement(By.xpath("(//span[contains(@class,'year') and text()="+year+"])[3]")).click();
	 driver.findElement(By.name("departDate")).click();
	driver.findElement(By.xpath("((//div[@class='datepicker-days'])[3]//th)[2]")).click();
//	driver.findElement(By.xpath("((//div[@class='datepicker-months'])[3]//th)[2]")).click();
	driver.findElement(By.xpath("(//span[contains(@class,'month') and text()='"+month+"'])[3]")).click();
	 driver.findElement(By.name("departDate")).click();
	 driver.findElement(By.xpath("(//td[@class='day ' and text()='"+select_day+"'])[3]")).click();
	
	
	 
	 
	 
	 
	 }
}
