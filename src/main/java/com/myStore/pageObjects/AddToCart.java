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
public class AddToCart extends BaseClass{
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(name="group_1")
	WebElement size;
    
	
    @FindBy(xpath="//span[contains(text(),'Add to cart')]")
    WebElement AddToCartBtn;
    
    @FindBy(xpath="//i[@Class='icon-ok']")
    WebElement AddToCartMsg;
    
    @FindBy(xpath="//header/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]")
    WebElement ProceedToCheckOutBtn;
    public AddToCart() {
    	PageFactory.initElements(getDriver(), this);
    }
    
    public void enterQuantity(String Quantity)
    {
    	Action.type(quantity, Quantity);
    }
    
    public void selectSize(String Size) {
    	Action.selectByVisibleText(Size, size);
    }
    public void clickOnAddtoCart()
    {
    	Action.fluentWait(AddToCartBtn, 10);
    	Action.click(getDriver(), AddToCartBtn);
    }
    
    public boolean validateaddTocart()
    {
    	Action.fluentWait(AddToCartMsg,10);
    	return Action.isDisplayed(getDriver(), AddToCartMsg);
    }
    
    public orderPage ClickOnCheckout() {
    	Action.fluentWait(ProceedToCheckOutBtn,10);
    	Action.JSClick(getDriver(),ProceedToCheckOutBtn );
    	return new orderPage();
    	
    }
}
