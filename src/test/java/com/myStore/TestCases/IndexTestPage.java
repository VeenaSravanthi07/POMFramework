
package com.myStore.TestCases;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myStore.actiondriver.Action;
import com.myStore.pageObjects.indexPage;
import com.myStore.BaseClass.BaseClass;



/**
 * @author shrav
 *
 */
public class IndexTestPage extends BaseClass {
	private indexPage IndexPage;
	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Smoke")
	public void verifyLogo() throws Throwable {
	
		IndexPage= new indexPage();
		boolean result=IndexPage.validateLogo();
		Assert.assertTrue(result);
		
	}
	
	@Test(groups="Smoke")
	public void verifyTitle() {
	
		String actTitle=IndexPage.getMystoreTitle();
		Assert.assertEquals(actTitle, "My Store");
		
	}

	
}

