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
public class orderPage extends BaseClass {
//Action action= new Action();
	
	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	private WebElement unitPrice;
	
	@FindBy(id="total_price")
	private WebElement totalPrice;
	
	@FindBy(xpath="//span[contains(text(),'Add to cart')]")
	private WebElement proceedTocheckOut;
	
	public orderPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public double getUnitPrice() {
		
		String unitPrice1=unitPrice.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
		String totalPrice1=totalPrice.getText();
		String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalTotalPrice=Double.parseDouble(tot);
		return finalTotalPrice/100;
	}
	
	public loginPage clickOnCheckOut() throws Throwable {
		Action.fluentWait(proceedTocheckOut, 10);
		Action.click(getDriver(), proceedTocheckOut);
		Action.fluentWait(proceedTocheckOut, 10);
		return new loginPage();
	}
	
}


