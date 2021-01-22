
package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {



	WebDriver driver=null;
	@BeforeTest
	public void setupTest() {

		String projectpath=System.getProperty("user.dir");

		System.setProperty("webdriver.gecko.driver", projectpath+"\\browserdrivers\\gecko\\geckodriver.exe");
		driver=new FirefoxDriver();

	}


	@Test(dataProvider="logintest1")	
	public void test1(String Username,String Password) throws Exception{
		System.out.println(Username+" | "+Password);

		driver.get("https://www.easemytrip.com/");


		driver.findElement(By.xpath("//*[@id=\"spnMyAcc\"]")).click();

		driver.findElement(By.xpath("/html/body/form/div[3]/div/div[2]/div[2]/div[4]/div[2]/div/div[2]/a[1]")).click();
		driver.findElement(By.id("txtusername")).sendKeys(Username);
		driver.findElement(By.id("Password1")).sendKeys(Password);
		driver.findElement(By.xpath("/html/body/form/div[10]/div[1]/div[2]/div/div[11]/input")).click();
		Thread.sleep(2000);

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


}
