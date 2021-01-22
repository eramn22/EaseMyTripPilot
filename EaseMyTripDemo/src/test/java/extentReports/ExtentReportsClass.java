package extentReports;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsClass {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver=null;
	@BeforeSuite
	public void setup() {
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);	

	}
	@BeforeTest
	public void setuptest() {
		String projectpath=System.getProperty("user.dir");

		System.setProperty("webdriver.gecko.driver", projectpath+"\\browserdrivers\\gecko\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	@Test
	public void test1() throws Exception {

		ExtentTest test = extent.createTest("LoginTest", "Login Functionality validated");	
		driver.get("https://www.easemytrip.com/");
		test.pass("Navigated to website");
		driver.findElement(By.xpath("//*[@id=\"spnMyAcc\"]")).click();
		test.pass("Click on My Account");
		WebElement ele = driver.findElement(By.xpath("/html/body/form/div[3]/div/div[2]/div[2]/div[4]/div[2]/div/div[2]/a[1]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		test.pass("Click on sign in");
		driver.close();
		test.pass("Browser closed");
		test.log(Status.INFO, "This step shows usage of log(status, details)");


		// info(details)
		test.info("This step shows usage of info(details)");

		// log with snapshot
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");



	}
	@AfterSuite
	public void teardown() {

		// calling flush writes everything to the log file
		extent.flush();
	}

}
