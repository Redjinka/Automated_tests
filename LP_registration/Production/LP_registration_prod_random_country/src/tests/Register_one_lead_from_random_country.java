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

public class Register_one_lead_from_random_country 
{

	@Test // Register one lead from random country using English LP on Production
	public void Test1()
	{	
		// Telling the system where to find the Chrome driver
		System.setProperty( "webdriver.chrome.driver", "C:\\Users\\regina.rudovskaya\\workspace\\ChromeWD\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver(); 
		RegistrationPage registrationPage = new RegistrationPage(driver) ;

		Assert.assertTrue("Some step is failed",
		registrationPage.openRegistrationPage()& 
		registrationPage.selectRandomCountry()&
		registrationPage.clearTextField()&
		registrationPage.inputName("Test_lead_lp") & 
		registrationPage.inputPhone("") & 
		registrationPage.inputEmail("") & 
		registrationPage.clickSubmitButton());

Assert.assertTrue("Acceptance critirion is not met ",registrationPage.checkIfSuccessZapisatsaConfirmationMessageIsShown());
Assert.assertTrue("Can not close the browser",registrationPage.closeRegistrationPage());
}	
}