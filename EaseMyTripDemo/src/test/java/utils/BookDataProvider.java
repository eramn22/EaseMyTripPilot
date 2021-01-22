package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookDataProvider {
	WebDriver driver=null;
	@BeforeTest
	public void setupBookTest() {

		String projectpath=System.getProperty("user.dir");

		System.setProperty("webdriver.gecko.driver", projectpath+"\\browserdrivers\\gecko\\geckodriver.exe");
		driver=new FirefoxDriver();

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
}



/*public void waitForPageLoaded() {
	        int maxWait = 30;
	        long tStart = System.currentTimeMillis();
	        long elapsedSeconds = 0;
	        for (; elapsedSeconds < maxWait;) {
	            try {


	                if (driver.getCurrentUrl().contains("ErrorCode=1052")) {
	                    // Error page, exit immediately instead of keep on waiting.
	                    System.out.println("\nErrorCode=1052");
	                    return;
	                }
	                driver.findElement(By.cssSelector("p.ng-binding"));
	                System.out.println("\nNew page successfully loaded");
	                return;
	            } catch (WebDriverException ex) {
	                // Intentionally left blank.
	            }
	            elapsedSeconds = (System.currentTimeMillis() - tStart) / 1000;
	        }
	        System.out.println("\n waitForPageLoaded(): elapsedSeconds= " + elapsedSeconds);
	    }
 */


