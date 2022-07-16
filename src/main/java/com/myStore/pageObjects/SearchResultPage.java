
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
public class SearchResultPage extends BaseClass {
Action action= new Action();
	
	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	private WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable() throws Throwable {
		return Action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCart clickOnProduct() throws Throwable {
		Action.click(getDriver(), productResult);
		return new AddToCart();
	}
	
}


