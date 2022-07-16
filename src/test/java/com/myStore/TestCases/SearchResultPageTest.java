/**
 * 
 */
package com.myStore.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myStore.BaseClass.BaseClass;
import com.myStore.dataprovider.DataProviders;
import com.myStore.pageObjects.HomePage;
import com.myStore.pageObjects.SearchResultPage;
import com.myStore.pageObjects.indexPage;
import com.myStore.pageObjects.loginPage;
import com.myStore.utility.log;


/**
 * @author shrav
 *
 */
public class SearchResultPageTest extends BaseClass {
	indexPage index;
	SearchResultPage searchPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups="Smoke")
	
	public void ProductAvailability() throws Throwable
{
	index=new indexPage();
	searchPage=index.searchProduct("t-shirt");
	boolean result=searchPage.isProductAvailable();
	Assert.assertTrue(result);

}
}