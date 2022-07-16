/**
 * 
 */
package com.myStore.TestCases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myStore.BaseClass.BaseClass;
import com.myStore.dataprovider.DataProviders;
import com.myStore.pageObjects.AccountCreation;
import com.myStore.pageObjects.HomePage;
import com.myStore.pageObjects.indexPage;
import com.myStore.pageObjects.loginPage;
import com.myStore.utility.log;

/**
 * @author shrav
 *
 */
public class AccountCreationPageTest extends BaseClass {
	private indexPage IndexPage;
	private loginPage LoginPage;
	private AccountCreation accountCreationPage;
	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}
	@Test(groups="Sanity")
	public void verifyCreateAccountPageTest() throws Throwable {
		IndexPage= new indexPage();
		LoginPage=IndexPage.ClickOnSignin();
		accountCreationPage=LoginPage.createNewAccount("ghjbhvgvhbc@gmail.com");
		boolean result=accountCreationPage.validateAcountCreatePage();
		
		Assert.assertTrue(result);
		
	}
	}

