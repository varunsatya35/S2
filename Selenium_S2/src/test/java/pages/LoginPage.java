package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(linkText="Log in")
	WebElement loginbutton;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement emailid;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement pwd;
	
	@FindBy(xpath="//input[@class='button-1 login-button']")
	WebElement submit;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void user_login(String u,String p) {
		loginbutton.click();
		
		emailid.sendKeys(u);
		pwd.sendKeys(p);
		submit.click();
	}
}
