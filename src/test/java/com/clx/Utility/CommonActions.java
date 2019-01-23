package com.clx.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonActions {
	WebDriver driver;
	public CommonActions(WebDriver driver)
	{
		this.driver=driver;
	}
	public void enterText(WebElement ele,String value)
	{
		if (value != null)
			ele.sendKeys(value);
	}
	public void clearText(WebElement ele)
	{
		ele.clear();
	}
	public void click(WebElement ele)
	{
		ele.click();
	}
	public void getText(WebElement ele)
	{
		ele.getText();
	}

}
