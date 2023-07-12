package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\QA\\SeleniumWorkSpace\\CucumberPOM\\src\\main\\java\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {

		System.setProperty("webdriver.gecko.driver", "C:\\QA\\SeleniumJars\\geckodriver.exe");
		driver = new FirefoxDriver();
		// String browser = "Chrome"; //Chrome, Safari //Read browser value from data
		// file, excel or Properties
		// WebDriver driver;

//		if (browser.equals("Firefox")) {
//			driver = new FirefoxDriver();
//		} else  {
//			driver = new ChromeDriver();
//		} 
		
		
//		e_driver = new EventFiringWebDriver(driver);
//		// Now create object of EventListerHandler to register it with EventFiringWebDriver
//		eventListener = new WebEventListener();
//		e_driver.register(eventListener);
//		driver = e_driver;
//
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));

	}
	
}
