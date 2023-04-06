package Object_Repository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Screen {

	WebDriver driver;
	public Login_Screen(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//ul[contains(@class,'nav navbar-nav navbar-right margin-right-logo')]//li[@class='dropdown loggedout']")
	public WebElement customerloginbtn;
	
	
	@FindBy(xpath="(//ul[@class='dropdown-menu user-login']//a[text()='User Login'])[2]")
	public WebElement userloginoption;
	
	@FindBy(id="sign_user_email")
	public WebElement inputenteremail;
	
	@FindBy(id="sign_user_password")
	public WebElement inputenterpwd;
	
	@FindBy(xpath="(//button[text()='Log in'])[1]")
	public WebElement loginbtn;
	
	@FindBy(xpath="(//a[contains(text(),'Welcome')])[1]")
	public WebElement welcometext;
	
	@FindBy(xpath="//li[contains(text(),'This value should be a valid email.')]")
	public WebElement emailvalidationtext;
	
	@FindBy(xpath="//*[text()='Incorrect email address and password combination. Please try again.']")
	public WebElement passwordinvalidmsg;
	
	@FindBy(xpath="(//li[contains(text(),'This value is required.')])[1]")
	public WebElement errorValidationusrname;
	
	@FindBy(xpath="(//li[contains(text(),'This value is required.')])[2]")
	public WebElement errorValidationpwd;
	
	@FindBy(xpath="(//button[@data-dismiss=\"modal\"])[2]")
	public WebElement closeerror;
	
	
	

	
}
