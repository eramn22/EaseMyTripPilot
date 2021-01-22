package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.Excelutils;

public class LoginSearch {
	WebDriver driver=null;
	
	@BeforeSuite
	public void setupTest() {
		
		String projectpath=System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectpath+"\\browserdrivers\\gecko\\geckodriver.exe");
		driver=new FirefoxDriver();

	}

	@Test(dataProvider="logintest1")	
	public void test1(String Username,String Password) throws Exception{
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
	


	Thread.sleep(3000);
	//Validate
	String actualUrl="https://www.easemytrip.com/";
	String expectedUrl= driver.getCurrentUrl();
	Assert.assertEquals(actualUrl, expectedUrl);
	
	}
	
	@Test(dataProvider="booktest1")	
	public void booktest1(String From,String To,String Depart,String Return, String Adult, String Children,String Infant, String Economy) throws Exception{
		System.out.println(From+" | "+To+" | "+Depart+" | "+Return+" | "+Adult+" | "+Children+" | "+Infant+" | "+Economy);
		
		driver.get("https://www.easemytrip.com/");
		// Click on roundtrip radio button
		driver.findElement(By.xpath("/html/body/form/div[14]/div[2]/div[1]/ul/li[2]")).click();
		// Insert data into Flying from text box
		driver.findElement(By.id("FromSector_show")).sendKeys(From);
		
		//To data
		driver.findElement(By.xpath("//*[@id=\"Editbox13_show\"]")).sendKeys(To);
		driver.findElement(By.xpath("/html/body/form/div[14]/div[2]/div[3]/div[1]/div[7]/input")).click();
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"BtnBookNow\"]")).click();
		Thread.sleep(3000);
     
	}
	
	@Test	
	public void logouttest() throws Exception{
		
		driver.findElement(By.xpath("/html/body/form/div[6]/div/div[3]/div[2]/div[3]/div[2]")).click();
		
		WebElement ele1 = driver.findElement(By.xpath("/html/body/form/div[3]/div/div[2]/div[2]/div[4]/div[2]/div/div[3]/span/a[2]"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", ele1);
		try{
		} catch (Exception e) {
		if(e.toString().contains("org.openqa.selenium.UnhandledAlertException"))
		 {
		    Alert alert = driver.switchTo().alert();
		    alert.accept();
		 }
		}
	}

	@DataProvider(name="booktest1")
	public Object[][] BookingData() {
		String ep="C:\\Users\\eramn\\eclipse-workspace\\EaseMyTripDemo\\Excel\\bookingtest.xlsx";
		Object data[][]=testbookData(ep,"Sheet2");
		return data;
	}
	
	public Object[][] testbookData(String ep, String sn) {
		Excelutils excel=new Excelutils(ep,sn);

		int rowCount=excel.getRowcount();
		int colCount=excel.getColcount();
		Object data[][]=new Object[rowCount-1][colCount];

		for(int i=1;i<rowCount;i++) {

			for(int j=0;j<colCount;j++) {
				String celldata=excel.getCelldataString(i, j);	

				//System.out.print(celldata+" | ");
				data[i-1][j]=celldata;
			}
			//System.out.println();
		}
		return data;
	}
	
	
	
	
	
	


	@DataProvider(name="logintest1")
	public Object[][] getLoginData() {
		String ep="C:\\Users\\eramn\\eclipse-workspace\\EaseMyTripDemo\\Excel\\test_input.xlsx";
		Object data[][]=testData(ep,"Sheet1");
		return data;
	}


	public Object[][] testData(String ep, String sn) {
		Excelutils excel=new Excelutils(ep,sn);

		int rowCount=excel.getRowcount();
		int colCount=excel.getColcount();
		Object data[][]=new Object[rowCount-1][colCount];

		for(int i=1;i<rowCount;i++) {

			for(int j=0;j<colCount;j++) {
				String celldata=excel.getCelldataString(i, j);	

				//System.out.print(celldata+" | ");
				data[i-1][j]=celldata;
			}
			//System.out.println();
		}
		return data;
	
	}
	





// Closing the browser session after completing each test case



 @AfterSuite


 public void tearDown() throws Exception {

driver.quit();

}
}
