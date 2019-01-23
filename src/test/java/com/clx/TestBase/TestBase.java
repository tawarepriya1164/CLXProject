package com.clx.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.clx.Utility.ExcelReader;

public class TestBase {
	public WebDriver driver;
	public static Properties prop = new Properties();
	public ExcelReader excelReader;
	
	@BeforeClass
	@Parameters("browser")
	public void initialization(String browser)throws IOException
	{
		loadPropertiesFile();
		browserSelection(browser);
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS);
	}
	public void browserSelection(String browser)
	{
		if(browser.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\java\\com\\clx\\Resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browser.contains("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\java\\com\\clx\\Resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		
	}
	public void loadPropertiesFile() throws IOException
	{
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\clx\\TestData\\config.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		
	}
	public Object[][] getData(String sheetName, String excelName) throws IOException 
	{
		String excelLocation=System.getProperty("user.dir")+"\\src\\test\\java\\com\\clx\\testData\\"+excelName+".xlsx";
		excelReader=new ExcelReader();
		return ExcelReader.getExcelData(excelLocation, sheetName);
		}
	
	
	/*@AfterClass
	public void tearDown()
	{
		driver.close();
	}
*/
}
