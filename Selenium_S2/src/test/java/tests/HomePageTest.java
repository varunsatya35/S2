package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.TestBase;

public class HomePageTest extends TestBase{
	Homepage hp;
	@BeforeTest
	public void start_browser() {
		OpenBrowser("Chrome");
		hp=new Homepage(driver);
	}
	@Test(priority='1')
	public void test_getTitle_page() throws InterruptedException {
		String expected="https://demowebshop.tricentis.com/";
		String actual=hp.getURL1(driver);
		assertEquals(actual, expected);
		Thread.sleep(2000);
	}
	@AfterTest
	public void close() {
		closeBrowser();
	}

}
