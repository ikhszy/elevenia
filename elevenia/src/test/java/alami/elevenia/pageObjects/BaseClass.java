package alami.elevenia.pageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import alami.elevenia.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig reader = new ReadConfig();
	
	public String baseUrl = reader.getBaseURL();
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", reader.getChromepath());
			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
		
		else if(br.equals("ff")) {
			System.setProperty("webdriver.gecko.driver", reader.getFirefoxPath());
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String sname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + sname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomString() {
		String rdmString = RandomStringUtils.randomAlphabetic(8);
		return rdmString;
	}
	
	public String randomNumber() {
		String rdmNum = RandomStringUtils.randomNumeric(3);
		return rdmNum;
	}

}