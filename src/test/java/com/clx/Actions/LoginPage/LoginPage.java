package com.clx.Actions.LoginPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import com.clx.Locators.Login.LoginObjects;
import com.clx.TestBase.TestBase;
import com.clx.Utility.CommonActions;
import com.clx.Utility.SoftAsserts;

public class LoginPage extends TestBase{
	WebDriver driver;
	LoginObjects loginObject;
	CommonActions commonActions;
	public LoginPage(WebDriver driver)
	{
		commonActions = new CommonActions(driver);
		loginObject = new LoginObjects(driver);
		this.driver=driver;
	}

	public void loginToApplication(String userName, String passWord)
	{
		String un = userName;
		String pwd = passWord;
		if(userName.contains("null"))
			un="";
		if(passWord.contains("null"))
			pwd="";

		commonActions.enterTextByClearingExisting(loginObject.getUserName, un);
		commonActions.enterTextByClearingExisting(loginObject.getPassWord, pwd);
		commonActions.click(loginObject.getLoginBtn);
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
	}
	public void verifyHomePage(String expectedTitle)
	{
		String actualTitle = driver.getTitle();
		new SoftAsserts().performSoftAsserts(actualTitle, expectedTitle);
	}

	public void verifyErrorMessage(String ermsg)
	{
		if(ermsg.contains("Welcome"))
			verifyHomePage(ermsg);
		else
		{
			String actualErrorMessage = loginObject.getErrorMessage.getText();
			new SoftAsserts().performSoftAsserts(actualErrorMessage, ermsg);
		}	

	}


}
