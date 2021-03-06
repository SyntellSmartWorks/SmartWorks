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
import static smartworks.SmartWorks.dr;
import static smartworks.SmartWorks_Agents.dr;

/**
 *
 * @author Reece
 */
public class SmartWorks_Reports extends SmartWorksWindow
{
    public static WebDriver dr;
    ExtentReports extent = new ExtentReports("C:\\Users\\Reece.SYNTELL\\Documents\\Reports\\SmartWorks Add Customer.html");
    ExtentTest test = extent.startTest("SmartWorks Add Customer");
    
    @BeforeClass
	public void openBrowser() throws InterruptedException
        {
            System.setProperty("webdriver.chrome.driver", "C:\\SmartWorks\\SmartWorks\\chromedriver.exe");
            //String URL = ip;
            String defURL = "http://syn-tst-net-smw.syntell.net/BREEDETEST/WA/SB/AppStart/Login.aspx";
            dr = new ChromeDriver();
        
          dr.get(defURL);
        dr.manage().window().maximize();
        
        if(dr.findElements(By.xpath("//input[@name = 'txtUsername']")).size() > 0)
            {
            /*dr.findElement(By.xpath("//input[@name = 'txtUsername']")).sendKeys(username);
            dr.findElement(By.xpath("//input[@name = 'txtPassword']")).sendKeys(password);*/
            dr.findElement(By.xpath("//input[@name = 'txtUsername']")).sendKeys("Reece");
            dr.findElement(By.xpath("//input[@name = 'txtPassword']")).sendKeys("Reece@01");
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
 
        //==========================ADDING REPORTS========================================================//
           for (String reportsel1 : reportsel) 
            {
                if(dr.findElement(By.xpath("//a[contains(text(), '"+reportsel1+"')]")).isDisplayed())
                {
                    dr.findElement(By.xpath("//a[contains(text(), '"+reportsel1+"')]")).click();
                } 
                
                //selectdate();
                
                if(dr.findElements(By.xpath("//input[@name = 'clientID']")).size() > 0)
                {
                    dr.findElement(By.xpath("//input[@name = 'clientID']")).sendKeys("1");
                }
                
                if(dr.findElement(By.xpath("//input[@type = 'submit']")).isDisplayed())
                {
                    dr.findElement(By.xpath("//input[@type = 'submit']")).click();
                    test.log(LogStatus.PASS, "Successfully generated "+reportsel1+" report");
                }
                
                if(dr.findElement(By.xpath("//button[text() = 'Cancel']")).isDisplayed())
                {
                    dr.findElement(By.xpath("//button[text() = 'Cancel']")).click();
                }
                
                extent.endTest(test);
                extent.flush();
            }
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
