package com.myStore.pageObjects;


	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import com.myStore.actiondriver.Action;
	import com.myStore.BaseClass.BaseClass;

	public class indexPage extends BaseClass {
		
		Action action= new Action();
		
		@FindBy(xpath = "//a[@class='login']") 
		private WebElement signInBtn;
		
		@FindBy(xpath = "//img[@class='logo img-responsive']")
		private WebElement myStoreLogo;
		
		@FindBy(id="search_query_top")
		private WebElement searchProductBox;
		
		@FindBy(name="submit_search")
		private WebElement searchButton;
		
		
		//Initialization of webelements
		
		public indexPage()
		{
			PageFactory.initElements(getDriver(), this);
		}
    
	public   loginPage ClickOnSignin()
	{
		Action.click(getDriver(),signInBtn);
		return new loginPage();
	}
	public boolean validateLogo()
	{
	return Action.isDisplayed(getDriver(), myStoreLogo);
	
	}
	public String getMystoreTitle()
	{
		String myStoreTitle=getDriver().getTitle();
		return myStoreTitle;
	}
	public SearchResultPage searchProduct(String productName) {
		Action.type(searchProductBox, productName);
		Action.click(getDriver(), searchButton);
		return new SearchResultPage();
	}
	
	}
	
	
