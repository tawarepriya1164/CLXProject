package com.clx.Actions.LoginPage;

import org.openqa.selenium.WebDriver;

import com.clx.Locators.Login.LoginObjects;
import com.clx.TestBase.TestBase;
import com.clx.Utility.CommonActions;

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
		commonActions.enterText(loginObject.getUserName, userName);
		commonActions.enterText(loginObject.getPassWord, passWord);
		commonActions.click(loginObject.getLoginBtn);
		
	}
	
}
