package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	    protected WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	    	String chromeDriverPath = System.getenv("CHROME_DRIVER_PATH");
	        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	    }

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	
}
