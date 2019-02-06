package com.clx.Test.LoginTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.clx.Actions.LoginPage.LoginPage;
import com.clx.TestBase.TestBase;
import com.clx.Utility.CommonActions;
import com.clx.Utility.ExcelReader;
import com.clx.Utility.SoftAsserts;
import com.clx.Utility.Enum.ErrorMessages.ErrorMessage;

public class LoginTest extends TestBase {

	@Test(priority = 1, dataProvider = "Login" ,description = " Login with valid username and blank password" )
	public void TC_01(String userName, String passWord)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApplication(userName, passWord);
		loginPage.verifyErrorMessage(ErrorMessage.VALIDUN_BLANKPWD);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS); 
	}
	@Test(priority = 2, dataProvider = "Login" ,description = " Login with valid username and wrong password" )
	public void TC_02(String userName, String passWord)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApplication(userName, passWord);
		loginPage.verifyErrorMessage(ErrorMessage.VALIDUN_WRONGPWD);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);	
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS);
	}
	@Test(priority = 3, dataProvider = "Login" ,description = " Login with Wrong username and Valid password" )
	public void TC_03(String userName, String passWord)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApplication(userName, passWord);	
		loginPage.verifyErrorMessage(ErrorMessage.WRONGUN_VALIDPWD);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);	
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS);
	}
	@Test(priority = 4, dataProvider = "Login" ,description = " Login with Wrong username and wrong password" )
	public void TC_04(String userName, String passWord)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApplication(userName, passWord);
		loginPage.verifyErrorMessage(ErrorMessage.WRONGUN_WRONGPWD);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);	
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS);
	}
	@Test(priority = 5, dataProvider = "Login" ,description = " Login with valid username and valid password" )
	public void TC_05(String userName, String passWord)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApplication(userName, passWord);
		loginPage.verifyHomePage("Welcome to CloudLex | CloudLex");
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS);	
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS);
	}
	@DataProvider(name="Login")
	public Object[][] LoginData() throws IOException
	{
		Object data[][] =ExcelReader.getExcelData(System.getProperty("user.dir")+"\\src\\test\\java\\com\\clx\\testData\\"+"Login"+".xlsx", "sheetName");
		return data;


	}

}
