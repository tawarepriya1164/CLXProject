package com.clx.Locators.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.clx.TestBase.TestBase;

public class LoginObjects extends TestBase{
	public LoginObjects(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "exampleInputEmail1") public WebElement getUserName;
	@FindBy(id = "exampleInputPassword1") public WebElement getPassWord;
	@FindBy(xpath = "//input[@type = 'submit']") public WebElement getLoginBtn;
	@FindBy(xpath = " //body/div[3]") public WebElement getErrorMessage;
}


