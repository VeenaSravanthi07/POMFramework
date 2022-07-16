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
public class shipping extends BaseClass {
	@FindBy(id="cgv")
	WebElement terms;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout']")
	WebElement checkouttoProceed;
	
	public shipping()
	{
		PageFactory.initElements(getDriver(), this);
		
	}
public void terms()
{
	Action.click(getDriver(), terms);
}

public PaymentPage clickOnCheckOut() {
	Action.click(getDriver(), checkouttoProceed);
	return new PaymentPage();
}
}

