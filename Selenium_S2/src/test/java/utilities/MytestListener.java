package utilities;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;




public class MytestListener implements ITestListener{
	private WebDriver driver;
    private ExtentReports extent;
    private ThreadLocal<ExtentTest> test = new ThreadLocal<>();

public void onTestStart(ITestResult result) {
		
		// if a @test method is started, it will record the log
		
		System.out.println("Test method has been started");
		extent = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/spark-report.html");

        extent.attachReporter(sparkReporter);
        extent.attachReporter(sparkReporter);
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("JAVA", System.getProperty("java.version"));

        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
		
	}

	public void onTestSuccess(ITestResult result) {
		// if testmethod is success
		
		System.out.println("Test method is success");
		test.get().log(com.aventstack.extentreports.Status.PASS, "Test Passed");
		
	}

	public void onTestFailure(ITestResult result) {
	// if testmethod is failure
		System.out.println("testmethod is failure");
		 test.get().log(com.aventstack.extentreports.Status.FAIL,
	                MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
		captureScreenshot(result.getMethod().getMethodName());
		test.get().fail(result.getThrowable());
	}

	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test method is sipped");
		 test.get().log(com.aventstack.extentreports.Status.SKIP, "Test Skipped");
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Test method is failure due to timeout");
	}

	public void onStart(ITestContext context) {
		// this method will record events in the very begining of testing
		
		System.out.println("Testing has started");
		
		
	}

	public void onFinish(ITestContext context) {
		// this method will record events at end of testing
		
		System.out.println("Testing has ended");
		extent.flush();
		
	}
	private void captureScreenshot(String methodName) {
		// TODO Auto-generated method stub
		if (driver instanceof TakesScreenshot) {
            File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("./ScreenShots/" + methodName + ".png");
            try {
                FileUtils.copyFile(srcfile, destination);
                System.out.println("Screenshot saved: " + destination.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	 public void setDriver(WebDriver driver) {
	        this.driver = driver;
	    }


}
