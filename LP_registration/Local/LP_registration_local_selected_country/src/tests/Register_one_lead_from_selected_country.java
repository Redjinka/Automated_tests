/* package tests;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.ZapisatsaPage;

public class Test1  {
	WebDriver driver = new FirefoxDriver();
	ZapisatsaPage zapisatsaPage = new ZapisatsaPage (driver)  ;
	
	@Test
	public void Test1()
	{
		Assert.assertTrue("", zapisatsaPage.openZapisatsa() & zapisatsaPage.selectValueFromDD(valueFromDD ("PL/SQL");
	zapisatsaPage.inputLastName("Eliseeva") & zapisatsaPage.inputName("Elena") & zapisatsaPage.inputPhone("911") 
	& zapisatsaPage.inputEmail("qwerty@ww.dd") & zapisatsaPage.inputSkype(redji) & zapisatsaPage.inputComments("gdgfdg" & zapisatsaPage.clickKupitButton()
			& zapisatsaPage.checkSuccessMessage(),"Message");
	}

	@After
	
	public void tearDown{
		zapisatsaPage.closeregistrationPage();
	}
}

*/

package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegistrationPage;


public class Register_one_lead_from_selected_country {


	@Test // // Register one lead from selected country using Russian LP on Local
	public void Test1(){
		
		// Telling the system where to find the Chrome driver
				System.setProperty( "webdriver.chrome.driver", "C:\\Users\\regina.rudovskaya\\workspace\\ChromeWD\\chromedriver.exe"); 
				WebDriver driver = new ChromeDriver(); 
				RegistrationPage registrationPage = new RegistrationPage(driver) ;
		
	Assert.assertTrue("Some step is failed",
				registrationPage.openRegistrationPage()& 
				registrationPage.selectValueFromDD("Австрия")&
				registrationPage.clearTextField()&
				registrationPage.inputName("Test_lead_lp") & 
				registrationPage.inputPhone("") & 
				registrationPage.inputEmail("") & 
				registrationPage.clickSubmitButton());
		
	Assert.assertTrue("Acceptance critirion is not met ",registrationPage.checkMessageIsShown());
	Assert.assertTrue("Can not close the browser",registrationPage.closeRegistrationPage());
	}	
}

