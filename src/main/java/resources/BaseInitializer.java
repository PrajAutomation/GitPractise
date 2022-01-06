package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseInitializer {
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		prop=new Properties();
		FileInputStream fio = new FileInputStream("D:\\my workspace\\appShoping\\src\\main\\java\\resources\\Data.properties");
		
		prop.load(fio);
		String browser=prop.getProperty("browser");
		if(browser.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "D:\\java installation\\chromedriver.exe");
			driver =new ChromeDriver();	
		}else if(browser.equals("firefox")) {
			System.out.println("Initialize firefox driver");
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public String getScreenshotPath(String TestCaseName,WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+TestCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
	
	

}
