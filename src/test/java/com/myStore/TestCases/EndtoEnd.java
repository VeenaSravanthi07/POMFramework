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
import com.myStore.pageObjects.Address;
import com.myStore.pageObjects.HomePage;
import com.myStore.pageObjects.OrderConfirmationPage;
import com.myStore.pageObjects.OrderSummary;
import com.myStore.pageObjects.PaymentPage;
import com.myStore.pageObjects.SearchResultPage;
import com.myStore.pageObjects.indexPage;
import com.myStore.pageObjects.loginPage;
import com.myStore.pageObjects.orderPage;
import com.myStore.pageObjects.shipping;
import com.myStore.utility.log;

/**
 * @author shrav
 *
 */
public class EndtoEnd extends BaseClass {
	private indexPage index;
	private loginPage LoginPage;
	private HomePage homePage;
	private orderPage order;
	private SearchResultPage searchPage;
	private AddToCart addToCartPage;
	private Address address;
	private shipping Shipping;
	private PaymentPage payment;
	private OrderSummary orderSummary;
	private OrderConfirmationPage orderConfirmationPage;
	
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
	public void endToendTest() throws Throwable
	{
		index= new indexPage();
		searchPage=index.searchProduct("t-shirt");
		addToCartPage=searchPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddtoCart();
		order=addToCartPage.ClickOnCheckout();
		LoginPage=order.clickOnCheckOut();
		LoginPage.login(prop.getProperty("username"), prop.getProperty("password"))	;
		Shipping=address.proceedToChkout();
		Shipping.terms();
		payment=Shipping.clickOnCheckOut();
		orderSummary=payment.clickOnPaymentMethod();
		orderConfirmationPage=orderSummary.ClickOnOrderConfirmation();
		String actualMessage=orderConfirmationPage.validateConfirmMessage();
		String expectedMsg="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMsg);
	}
	

}
