package com.clx.Test.LoginTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.clx.Actions.LoginPage.LoginPage;
import com.clx.TestBase.TestBase;
import com.clx.Utility.ExcelReader;

public class LoginTest extends TestBase {

	@Test(dataProvider = "Login" ,description = " Login with valid username and valid password" )
	public void TC_01(String userName, String passWord)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApplication(userName, passWord);
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
