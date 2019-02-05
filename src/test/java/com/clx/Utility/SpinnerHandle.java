package com.clx.Utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SpinnerHandle {
	WebDriver driver;
	public SpinnerHandle(WebDriver driver)
	{
		this.driver=driver;
	}
	public void waitForSpinnerRemoved() throws Exception
	{
		String spinnerImageXpath = driver.findElement(By.xpath("lexvia-loader ng-isolate-scope"));
		// actualSpinnerImageXpath=spinnerImageXpath.split("__")[1];

		List<WebElement> spinnerImage = driver.findElements(By.xpath(spinnerImageXpath));
		while(spinnerImage.size()>0 && spinnerImage.get(0).isDisplayed()){
			//Log.info("Waiting for Enable in while");
			//waitThread(WAIT_TIME_VERYSHORT);
			spinnerImage = driver.findElements(By.xpath(spinnerImageXpath));
		}
	}
}
