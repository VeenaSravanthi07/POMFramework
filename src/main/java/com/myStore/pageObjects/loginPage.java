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
public class loginPage extends BaseClass {
	
		
		Action action= new Action();
		
		@FindBy(id="email")
		private WebElement userName;
		
		@FindBy(id="passwd")
		private WebElement password;

		@FindBy(id="SubmitLogin")
		private WebElement signInBtn;
		
		@FindBy(name="email_create")
		private WebElement emailForNewAccount;
		
		@FindBy(name="SubmitCreate")
		private WebElement createNewAccountBtn;
		
		public loginPage() {
			PageFactory.initElements(getDriver(), this);
		}
		
		public HomePage login(String uname, String pswd) throws Throwable {
		
			Action.type(userName, uname);
			Action.type(password, pswd);
			Action.click(getDriver(), signInBtn);
			Thread.sleep(2000);
			
			return new HomePage();
		}
		
		public Address login1(String uname, String pswd) throws Throwable {
			
			Action.type(userName, uname);
			Action.type(password, pswd);
			Action.click(getDriver(), signInBtn);
			Thread.sleep(2000);
			
			return new Address();
		}

		
		public AccountCreation createNewAccount(String newEmail) throws Throwable {
			Action.type(emailForNewAccount, newEmail);
			Action.click(getDriver(), createNewAccountBtn);
			return new AccountCreation();
		}
		
	}

