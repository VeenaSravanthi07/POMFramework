package com.myStore.TestCases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myStore.BaseClass.*;
import com.myStore.dataprovider.DataProviders;
import com.myStore.pageObjects.HomePage;
import com.myStore.pageObjects.indexPage;
import com.myStore.pageObjects.loginPage;


public class LoginPageTest extends BaseClass {
	private indexPage IndexPage;
	private loginPage LoginPage;
	private HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class,groups= {"Smoke","Sanity"})
	public void loginTest(String uname, String pswd) throws Throwable {
		//Log.startTestCase("loginTest");
		IndexPage= new indexPage();
		//Log.info("user is going to click on SignIn");
		LoginPage=IndexPage.ClickOnSignin();
		//Log.info("Enter Username and Password");
	    //homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage=LoginPage.login(uname,pswd);
	    String actualURL=homePage.getCurrURL();
	    String expectedURL="http://automationpractice.com/index.php?controller=my-account";
	    //Log.info("Verifying if user is able to login");
	    Assert.assertEquals(actualURL, expectedURL);
	    //Log.info("Login is Sucess");
	    //Log.endTestCase("loginTest");
	}

}

