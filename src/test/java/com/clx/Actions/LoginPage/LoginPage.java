package com.clx.Actions.LoginPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.clx.Locators.Login.LoginObjects;
import com.clx.TestBase.TestBase;
import com.clx.Utility.CommonActions;
import com.clx.Utility.SoftAsserts;
import com.clx.Utility.Enum.ErrorMessages;
import com.clx.Utility.Enum.ErrorMessages.ErrorMessage;

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
		driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		
	}
	public void verifyHomePage(String expectedTitle)
	{
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		String actualTitle = driver.getTitle();
		new SoftAsserts().performSoftAsserts(actualTitle, expectedTitle);
	}
	
	public void verifyErrorMessage(ErrorMessage ermsg)
	{
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		
		//String actualErrorMessage = 
				
				new SoftAsserts().performSoftAsserts(actualErrorMessage, ermsg.getText());
	}
	
}
