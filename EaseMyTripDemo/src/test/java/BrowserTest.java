import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class BrowserTest {
	WebDriver driver=null;
	@BeforeTest
	public void setupTest() {
		
		String projectpath=System.getProperty("user.dir");
		
		System.setProperty("webdriver.gecko.driver", projectpath+"\\browserdrivers\\gecko\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.easemytrip.com/");
	
	

	}
}

