package pages;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.lang.Math;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	WebDriverWait ourWait;
	WebDriver driver;
	
	//protected WebDriver driver; 
	Logger log;
	
	public Page(WebDriver driver)
	{ //constructor. Input-output exception
	this.driver = driver;  
	log = Logger.getLogger(Page.class); 
}
	// open url
	protected void open(String url)
	{
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize(); 
	driver.get(url); //
	}
	//click on Button
	protected boolean clickButton(By locatorButton) 
	{
		try { 
			driver.findElement(locatorButton).click();
			log.info("Click button"+ locatorButton);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return true;
		}
		catch(Exception e){ 
			log.error("Error: clickButton catch " + e);
			return false;
		}
	}
	
	// clear field
	protected boolean clearTextField(By locatorField)
	{
		try{
		driver.findElement(locatorField).clear();
		log.info("Text field is cleared");
			return true;
		}
		catch(Exception e)
		{
			log.error("Error: clearTextField catch" + e);
			return false;
		}
	}
	
	// input to field
	protected boolean inputTextToField(By locatorField, String textValue)
	{
		try{
		driver.findElement(locatorField).sendKeys(textValue);	
		log.info("Value " +textValue + " is set ");
		return true;
		}		
		catch(Exception e)
		{
		log.error("Error: inputTextToField catch " + e);
		return false;
		}
		
	}
	// is element present	
	protected boolean isElementPresent(By locatorElements) {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			List<WebElement> list = driver.findElements(locatorElements);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (list.size() == 0)
			{
			log.info("Element not found");
			return false;
			}
			else 
			{
				log.info("Element is found");
			}			
			return true;
	}
		catch (Exception e) {
			log.error("Error:"+e);
			return false;		
	}
	}
	// select country from dropdown
	public boolean selectValueFromDropDownByInputtingText(By variableLocatorDropdownFromUIMapping, String textValue)
	{
		try {
			WebElement dropDown = driver.findElement(variableLocatorDropdownFromUIMapping);
			dropDown.sendKeys(textValue, Keys.ENTER);
			log.info(textValue + " is inputed and selected from DropDovn list");
			return true;
		}
		catch (Exception e) {
			log.error("Error: value" + textValue + " is not inputed and selected from DropDown list");
			return false;
		}
	}

	public boolean findElementWithNeededCreteria(By variableLocatorFromUIMapping)
	{
	try {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'//forms.opteck.com/form/advanced/20?mediapath=//assets.opteck.com/en/css/&lng=en')]" )));
		Thread.sleep(7000);
		driver.findElement(variableLocatorFromUIMapping);
		log.info("Needed element is found " + variableLocatorFromUIMapping);
		log.info("Registration completed ");
		driver.switchTo().defaultContent();
		return true;
		} 
	catch (Exception e) {
		log.error("Error: Needed element is not found "+ variableLocatorFromUIMapping);
		log.error("Note! Lead was registered from invalid country");
		return false;
		}
	}
	// close browser
	public void closeBrowser () {
		driver.close();
		log.info("Browser is closed");
	}
	//generate random email
	public String generateEmail()
		{
	  	 String generatedEmail="random_" + UUID.randomUUID().toString() + "@test.qa";
	  	 log.info("Email is generated");
	return generatedEmail;		  
		}
	//generate random phone
	public String generatePhone()
		{
		 int n=(int) Math.ceil(Math.random() * 10000000);
	  	 String generatedPhone=String.valueOf(n);
	  	 log.info("Phone is generated");
	return generatedPhone;		  
		}
	//select random country 
	 public boolean selectRandomDD()
	 {
		 WebElement drpDwnList = driver.findElement(By.xpath(".//*[@id='olgs_country3']"));
		 Select objSel = new Select(drpDwnList);
		 List <WebElement> weblist = objSel.getOptions();
		 int iCnt = weblist.size();
		 Random num = new Random();
		 int iSelect = num.nextInt(iCnt);
		 objSel.selectByIndex(iSelect);
	 return true;
	 }
	
	
}
	
	 
	





