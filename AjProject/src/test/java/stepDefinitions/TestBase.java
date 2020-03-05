package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.j2objc.annotations.Property;

public class TestBase {
	
	public static WebDriver driver;
	public static String propertyfile="src/main/java/TestData.properties";
	public File src;
	public FileInputStream fis;
	public static Properties prop;
	
	public TestBase() throws IOException
	{
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\utility\\TestData.properties");
		 prop=new Properties();
		 
		 
		 prop.load(fis);
		 
		 	 
	}
	
	public static void getDriver()
	{
		if(prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else
			if(prop.getProperty("browser").equals("ff"))
			{
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\main\\java\\driver\\geckodriver.exe");
				//System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver.exe");
				driver = new FirefoxDriver();
			}
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		
	}
	
	public static String getPropertyValue(String key)
	{
		return prop.getProperty(key);
	}

}
