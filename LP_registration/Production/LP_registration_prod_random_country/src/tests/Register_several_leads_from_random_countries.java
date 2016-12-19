/* package tests;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.RegistrationPage;

*/

package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegistrationPage;

public class Register_several_leads_from_random_countries 
{

	@Test // Register several(count of leads=i) leads from random countries using English LP on Production
	public void Test1()
	{	
		// Telling the system where to find the Chrome driver
		System.setProperty( "webdriver.chrome.driver", "C:\\Users\\regina.rudovskaya\\workspace\\ChromeWD\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver(); 
		RegistrationPage registrationPage = new RegistrationPage(driver) ;
			int count = 0;
			for (int i = 1; i <= 2; i++) //i - number of leads
				{
				count=i;
				registrationPage.openRegistrationPage(); 
				registrationPage.selectRandomCountry();
				registrationPage.clearTextField();
				registrationPage.inputName("Test_lead_lp #"+i); 
				registrationPage.inputPhone(""); 
				registrationPage.inputEmail(""); 
				registrationPage.clickSubmitButton();
				registrationPage.checkSuccessMessage();
				}
			System.out.println(count+" leads were registered ");
			registrationPage.closeBrowser();
	}
}

