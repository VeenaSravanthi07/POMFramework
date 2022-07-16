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
import com.myStore.pageObjects.AddToCart;
import com.myStore.pageObjects.HomePage;
import com.myStore.pageObjects.SearchResultPage;
import com.myStore.pageObjects.indexPage;
import com.myStore.pageObjects.loginPage;
import com.myStore.pageObjects.orderPage;
import com.myStore.utility.log;


/**
 * @author shrav
 *
 */
public class OrderPageTest extends BaseClass {
	indexPage index;
	SearchResultPage searchPage;
	AddToCart addTocart;
	orderPage order;
	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}
	
	
	@Test(groups="Regression")
	public void VerifyTotalPrice() throws Throwable {
	
	index= new indexPage();
	searchPage=index.searchProduct("t-shirt");
	addTocart=searchPage.clickOnProduct();
	addTocart.enterQuantity("2");
	addTocart.selectSize("M");
	addTocart.clickOnAddtoCart();
	order=addTocart.ClickOnCheckout();
	Double unitPrice=order.getUnitPrice();
	Double totalPrice=order.getTotalPrice();
	Double totalExpectedPrice=(unitPrice*2)+2;//(Double.parseDouble(2.0)))+2;
	Assert.assertEquals(totalPrice, totalExpectedPrice);
}

}