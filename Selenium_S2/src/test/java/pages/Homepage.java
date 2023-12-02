package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class Homepage extends TestBase{
	WebDriver driver;
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public String getURL1(WebDriver driver) {
		this.driver = driver;
		String URL = driver.getCurrentUrl();
		return URL;
	}
}
