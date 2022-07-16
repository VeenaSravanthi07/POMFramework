/**
 * 
 */
package com.myStore.pageObjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actiondriver.Action;
import com.myStore.BaseClass.BaseClass;


/**
 * @author shrav
 *
 */
public class Address extends BaseClass {
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")//"//span[contains(text(),'Proceed to checkout')]")
	WebElement ProceedToCheckoutbtn;
 public Address() {
	 PageFactory.initElements(getDriver(), this);
 }
 
 public shipping proceedToChkout() {
	 Action.fluentWait(ProceedToCheckoutbtn, 10);
	 Action.click(getDriver(), ProceedToCheckoutbtn);
	 return new shipping();
	 
 }
}
