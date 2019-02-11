package com.clx.Utility;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class SoftAsserts {
	WebDriver driver;
	public SoftAsserts(WebDriver driver)
	{
		this.driver =driver;
	}
  
	public void performSoftAssert(String actual, String expected)
	{
		SoftAssert asserts = new SoftAssert();
		asserts.assertEquals(actual, expected);
		asserts.assertAll();
	}
	public void performSoftAssert(boolean actual, boolean expected)
	{
		SoftAssert asserts = new SoftAssert();
		asserts.assertEquals(actual, expected);
		asserts.assertAll();
	}
}
