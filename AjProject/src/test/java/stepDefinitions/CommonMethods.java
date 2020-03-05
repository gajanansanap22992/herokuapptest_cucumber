package stepDefinitions;

import java.util.UUID;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonMethods {

	
	/*
	 * 
	 * Below method used to generate different string every time when it gets called
	 * that is used to provide differnt name to title,Sku and Description 
	 * 
	 */
	public WebDriver driver;
	
	public static String uniqueElement()
	{
		UUID uuid=UUID.randomUUID();
		String randomUUIDString =uuid.toString();
		String element=randomUUIDString.substring(randomUUIDString.length()-5,randomUUIDString.length());
				
		return "TEST"+element;
		
	}
	
	
}
