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
import com.myStore.pageObjects.AccountCreation;
import com.myStore.pageObjects.AddToCart;
import com.myStore.pageObjects.HomePage;
import com.myStore.pageObjects.SearchResultPage;
import com.myStore.pageObjects.indexPage;
import com.myStore.pageObjects.loginPage;
import com.myStore.utility.log;
/**
 * @author shrav
 *
 */
public class AddToCartPageTest extends BaseClass {
	private indexPage IndexPage;
	private SearchResultPage searchPage;
	private AddToCart addToCartPage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}
	@Test(groups={"Regression","Sanity"})
public void AddToCartTest() throws Throwable
{
IndexPage=new indexPage();
searchPage=IndexPage.searchProduct("t-shirt");
addToCartPage=searchPage.clickOnProduct();
addToCartPage.enterQuantity("2");
addToCartPage.selectSize("S");
addToCartPage.clickOnAddtoCart();
boolean result=addToCartPage.validateaddTocart();
Assert.assertTrue(result);

}
}