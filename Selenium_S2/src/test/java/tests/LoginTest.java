package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.TestBase;
import utilities.MytestListener;
import utilities.XLSXDataProvider;
import pages.Homepage;
import pages.LoginPage;

@Listeners(value=MytestListener.class)
public class LoginTest extends TestBase {
	LoginPage lp;
	Homepage hp;
	@BeforeTest
	public void start_browser() {
		OpenBrowser("Chrome");
		lp = new LoginPage(driver);
        hp = new Homepage(driver);
	}
	@Test(priority='1',dataProvider = "excelData", dataProviderClass =XLSXDataProvider.class)
	public void test_login(String u,String p)
	{
		lp.user_login(u,p);
		
	}
	
	  @Test(priority='2') public void test_getTitle() { 
		  String expected="https://demowebshop.tricentis.com/login"; 
		  String actual=hp.getURL1(driver); 
		  Assert.assertEquals(actual, expected);
	  
	  }
	 
		/*
		 * @AfterTest public void close() { closeBrowser(); }
		 */
}
