package test2;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Logouttest {
	WebDriver driver=null;

	@BeforeSuite
	public void setupTest() {

		String projectpath=System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectpath+"\\browserdrivers\\gecko\\geckodriver.exe");
		driver=new FirefoxDriver();

	}
	@Test		
	public void logouttest(String Username,String Password) throws Exception{
		driver.get("https://www.easemytrip.com/");
		driver.findElement(By.xpath("//*[@id=\"spnMyAcc\"]")).click();
		WebElement ele = driver.findElement(By.xpath("/html/body/form/div[3]/div/div[2]/div[2]/div[4]/div[2]/div/div[2]/a[1]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);

		//driver.findElement(By.xpath("/html/body/form/div[3]/div/div[2]/div[2]/div[4]/div[2]/div/div[2]/a[1]")).click();
		driver.findElement(By.id("txtusername")).sendKeys(Username);
		driver.findElement(By.id("Password1")).sendKeys(Password);
		Thread.sleep(10000);
		driver.findElement(By.xpath("/html/body/form/div[10]/div[1]/div[2]/div/div[11]/input")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("/html/body/form/div[3]/div/div[2]/div[2]/div[4]/div[2]")).click();



		Thread.sleep(10000);

		//driver.findElement(By.xpath("/html/body/form/div[6]/div/div[3]/div[2]/div[3]/div[2]")).click();
		//Thread.sleep(10000);
		//WebElement ele1 = driver.findElement(By.xpath("/html/body/form/div[3]/div/div[2]/div[2]/div[4]/div[2]/div/div[3]/span/a[2]"));
		//JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		//executor1.executeScript("arguments[0].click();", ele1);


	}

	@AfterSuite


	public void tearDown() throws Exception {

		driver.quit();

	}
}
