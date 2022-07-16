/**
 * 
 */
package com.myStore.pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actiondriver.Action;
import com.myStore.BaseClass.BaseClass;

/**
 * @author shrav
 *
 */
public class OrderSummary extends BaseClass {
	@FindBy(xpath="//button/span[contains(text(),'I confirm my order')]")
	WebElement OrderConfirmation;
	
	public OrderSummary() {
	PageFactory.initElements(getDriver(), this);
	}
	
	public OrderConfirmationPage ClickOnOrderConfirmation() {
		Action.click(getDriver(), OrderConfirmation);
		return new OrderConfirmationPage();
	}
}

