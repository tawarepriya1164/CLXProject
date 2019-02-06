package com.clx.Utility;

import org.testng.asserts.SoftAssert;

public class SoftAsserts {
	public void performSoftAsserts(boolean actual,boolean expected)
	{
		SoftAssert asserts = new SoftAssert();
		asserts.assertEquals(actual, expected);
		asserts.assertAll();

	}
	public void performSoftAsserts(String actual,String expected)
	{
		SoftAssert asserts = new SoftAssert();
		asserts.assertEquals(actual, expected);
		asserts.assertAll();

	}

}