/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartworks;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Reece
 */
public class SmartWorks_Tariff 
{
    public static WebDriver dr;
    ExtentReports extent = new ExtentReports("C:\\Users\\Reece.SYNTELL\\Documents\\Reports\\Add Customer.html");
    ExtentTest test = extent.startTest("Add Customer");
    /**
     * @param args the command line arguments 01010101011
     */
    
    @BeforeClass
	public void openBrowser() throws InterruptedException 
        {
            System.setProperty("webdriver.chrome.driver", "C:\\SmartWorks\\SmartWorks\\chromedriver.exe");
            //String URL = ip;
            String defURL = "http://syn-tst-net-smw.syntell.net/STELLBTEST/WA/SB/AppStart/Login.aspx";
            dr = new ChromeDriver();
        
          dr.get(defURL);
        dr.manage().window().maximize();
        
        if(dr.findElements(By.xpath("//input[@name = 'txtUsername']")).size() > 0)
            {
            /*dr.findElement(By.xpath("//input[@name = 'txtUsername']")).sendKeys(username);
            dr.findElement(By.xpath("//input[@name = 'txtPassword']")).sendKeys(password);*/
            dr.findElement(By.xpath("//input[@name = 'txtUsername']")).sendKeys("Sihle");
            dr.findElement(By.xpath("//input[@name = 'txtPassword']")).sendKeys("Lisanda@02");
            dr.findElement(By.xpath("//input[@name = 'btnLoginSubmit']")).click();
            test.log(LogStatus.PASS, "Successfully signed into SmartWorks");
                if(dr.findElements(By.xpath("//span[@class = 'ErrorWrap']")).size() > 0)
                {
                    //Thread.sleep(500);
                    String text = dr.findElement(By.xpath("//span[@class = 'ErrorWrap']")).getText();
                    test.log(LogStatus.PASS, "Successfully navigated to Meters");
                }
                
                if(dr.findElements(By.xpath("//span[contains(text(), 'Vendor')]")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//*[@id='top-nav']/ul/li/a/span/i")).click();
                dr.findElement(By.xpath("//a[text() = ' Customer Support Role']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            }
        }
        @Test(dataProvider="empLogin")
    public void addcus(String Meter, String dbtam, String dbtcol) throws Exception
	
    {
      Assert.assertTrue(true);
        String result = "";
 
        //==========================ADD TARIFF========================================================//
            if(dr.findElements(By.xpath("//span[text() = 'Utility']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//span[text() = 'Utility']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Meters");
            }
            
            if(dr.findElements(By.xpath("//span[text() = 'Tariffs']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//span[text() = 'Tariffs']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Meters");
            }
            
            if(dr.findElements(By.xpath("//span[text() = 'Manage Tariffs']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//span[text() = 'Manage Tariffs']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Meters");
            }
            
            if(dr.findElements(By.xpath("//input[@value = 'Add']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@value = 'Add']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Meters");
            }
            
            if(dr.findElements(By.xpath("//input[@id= 'txtTrfName']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id= 'txtTrfName']")).sendKeys("TariffTest02");
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Meters");
            }
            
            if(dr.findElements(By.xpath("//*[@id='ddlRes_chosen']/a/div/b")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//*[@id='ddlRes_chosen']/a/div/b")).click();
                dr.findElement(By.xpath("//li[text() = 'Electricity']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Meters");
            }
            
            if(dr.findElements(By.xpath("//*[@id='ddlUtility_chosen']/a/div/b")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//*[@id='ddlUtility_chosen']/a/div/b")).click();
                dr.findElement(By.xpath("//li[text() = 'STELLENBOSCH MUNICIPALITY']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Meters");
            }
            
            if(dr.findElements(By.xpath("//input[@value = 'Add']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@value = 'Add']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Meters");
            }
            
            if(dr.findElements(By.xpath("//div[@class = 'dx-dropdowneditor-icon']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//div[@class = 'dx-dropdowneditor-icon']")).click();
                dr.findElement(By.xpath("//input[@max = '24']")).sendKeys(Keys.CONTROL, "a");
                dr.findElement(By.xpath("//input[@max = '24']")).sendKeys("12");
                dr.findElement(By.xpath("//input[@max = '60']")).sendKeys(Keys.CONTROL, "a");
                dr.findElement(By.xpath("//input[@max = '60']")).sendKeys("00");
               // dr.findElement(By.xpath("//*[@id='dx-d7c0d282-2fd5-c557-32f6-b4ca3838ca7e']//div[4]/div/div/div[1]/div/input")).sendKeys("AM");
                dr.findElement(By.xpath("//span[text() = 'Done']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Meters");
            }
            
            if(dr.findElements(By.xpath("//*[@id='ddlDoaConfigEngine_chosen']/a/div/b")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//*[@id='ddlDoaConfigEngine_chosen']/a/div/b")).click();
                dr.findElement(By.xpath("//li[text() = 'STELLB ELEC TARIFF ENGINE']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Meters");
            }
            
            if(dr.findElements(By.xpath("//label[text() = 'Block Rate']/..//input[@id = 'txtCharge']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//label[text() = 'Block Rate']/..//input[@id = 'txtCharge']")).sendKeys(Keys.CONTROL, "a");
                dr.findElement(By.xpath("//label[text() = 'Block Rate']/..//input[@id = 'txtCharge']")).sendKeys("1,5");
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Meters");
            }
            
            if(dr.findElements(By.xpath("//label[text() = 'Tax 1']/..//input[@id = 'txtCharge']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//label[text() = 'Tax 1']/..//input[@id = 'txtCharge']")).sendKeys(Keys.CONTROL, "a");
                dr.findElement(By.xpath("//label[text() = 'Tax 1']/..//input[@id = 'txtCharge']")).sendKeys("15");
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Meters");
            }
            
            if(dr.findElements(By.xpath("//input[@id= 'btnDoaConfigOK']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id= 'btnDoaConfigOK']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Meters");
            }
            
            if(dr.findElements(By.xpath("//input[@id= 'btnSave']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id= 'btnSave']")).sendKeys(Keys.PAGE_UP);
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id= 'btnSave']")).click();
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id= 'btnModalConfirmOK']")).click();
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id= 'btnModalSuccessOkWithPostback']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Meters");
            }
            
            Actions actions = new Actions(dr);
                actions.sendKeys(Keys.PAGE_UP);
                actions.build().perform();
                Thread.sleep(500);
    }

    @DataProvider(name="empLogin")
	public Object[][] loginData() throws BiffException {
		Object[][] arrayObject = getExcelData("C:\\SmartWorks\\SmartWorks\\TestPacks\\Auxiliaries_Setup.xls","Sheet1");
		return arrayObject;
	}

	/**
	 * @param File Name
	 * @param Sheet Name
	 * @return
	 */
	public String[][] getExcelData(String fileName, String sheetName) throws BiffException {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream("C:\\SmartWorks\\SmartWorks\\TestPacks\\Auxiliaries_Setup.xls");
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet("Sheet1");

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();
			
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i < totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		}
		return arrayExcelData;
	}
        
   /*     public boolean isAlertPresent() {
    try{
       WebDriverWait wait = new WebDriverWait(dr, 5);
       wait.until(ExpectedConditions.alertIsPresent());
       dr.switchTo().alert().accept();
       return true;
    }
    catch (NoAlertPresentException noAlert) {
      return false;
    }
    catch (TimeoutException timeOutEx){
      return false;
    }
}*/
}
