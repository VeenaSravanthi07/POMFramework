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
import com.myStore.pageObjects.HomePage;
import com.myStore.pageObjects.indexPage;
import com.myStore.pageObjects.loginPage;
import com.myStore.utility.log;

/**
 * @author shrav
 *
 */
public class HomePageTest extends BaseClass {
	private indexPage IndexPage;
	private loginPage LoginPage;
	private HomePage homePage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class,groups= {"Smoke"})
	public void wishListTest() throws Throwable {
		
		IndexPage= new indexPage();
		LoginPage=IndexPage.ClickOnSignin();
		homePage=LoginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		boolean result=homePage.validateMyWishList();
		Assert.assertTrue(result);
		
	}
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class,groups="Smoke")
	public void orderHistoryandDetailsTest(String uname, String pswd) throws Throwable {
	
		IndexPage= new indexPage();
		LoginPage=IndexPage.ClickOnSignin();
		homePage=LoginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		boolean result=homePage.validateOrderHistory();
		Assert.assertTrue(result);
		
	}
	
}




