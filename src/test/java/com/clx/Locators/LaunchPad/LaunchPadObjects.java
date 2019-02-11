package com.clx.Locators.LaunchPad;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LaunchPadObjects {
	WebDriver driver;
	public LaunchPadObjects(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
