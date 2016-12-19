package pages;

import java.io.IOException;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import libs.ConfigData;

public class RegistrationPage extends Page {
	

	WebDriver driver;
	
	By name = By.xpath(".//*[@id='olgs_fullname']");
	By phone = By.xpath(".//*[@id='olgs_phone_two_fields_2']");
	By email = By.xpath(".//*[@id='olgs_email']");
	By courseDD = By.xpath (".//*[@id='olgs_country3']");
	By buyButton = By.xpath(".//*[@id='olgs_submit']");
	By message = By.xpath("//*[@class='btn_big']");
	

	public RegistrationPage(WebDriver driver){
		super(driver);
		ourWait = new WebDriverWait(driver, 10);
		log = Logger.getLogger(getClass());
		//TODO Auto-generated constructor stub
	}
	
	public boolean openRegistrationPage(){
		try{
			open ("http://lp.opteck.com.local/s/1000/");
			log.info("Page is opened");
			return true;
		}
	catch(Exception e)
		{
		log.error("Error:"+e);
		return false;
		}
	}
	
	// random value from DD
	public boolean selectRandomCountry()
	{
		return selectRandomDD();
	}
	
	// clear field
	public boolean clearTextField()
	{
		return clearTextField (name);
	}
	
	//1st field
	public boolean inputName(String nameValue)
	{
		return inputTextToField(name, nameValue);
	}
	
	 //2nd field
	public boolean inputEmail(String emailValue)
	{
		return inputTextToField(email, generateEmail());
	}
	
	//3rd field 
	public boolean inputPhone(String phoneNumberValue)
	{
		return inputTextToField(phone, generatePhone());
	}
	
	//4th field
	public boolean selectValueFromDD(String valueFromDD)
	{
		return selectValueFromDropDownByInputtingText(courseDD, valueFromDD);	
			
	}
	
	//submit
	public boolean clickSubmitButton()
	{
		return clickButton(buyButton);
	}
	
	//is text present
	public boolean checkSuccessMessage()
	{
		return findElementWithNeededCreteria(message);
	}
	
	//close browser
	public boolean closeRegistrationPage() 
	{
		try{
			closeBrowser();
			return true;
		}
	catch(Exception e)
		{
		log.error("Error:"+e);
		return false;
		}
	}
		
	 public boolean checkMessageIsShown() { 

	return findElementWithNeededCreteria(message);

	}
	
	
}
