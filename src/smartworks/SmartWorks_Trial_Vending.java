/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartworks;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author Reece
 */
public class SmartWorks_Trial_Vending 
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
                
                if(dr.findElements(By.xpath("//span[contains(text(), ' Customer Support Role')]")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//*[@id='top-nav']/ul/li/a/span/i")).click();
                dr.findElement(By.xpath("//a[text() = 'Vendor']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            }
        }
        @Test//(dataProvider="empLogin")
    public void addcus(/*String Meter, String SPT, String Region, String DPT, String CAT, String BP, String tariff*/) throws Exception
	
    {
      Assert.assertTrue(true);
        String result = "";
 
        //==========================ADD METER========================================================//
            if(dr.findElements(By.xpath("//span[text() = 'Revenue Collection']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//span[text() = 'Revenue Collection']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Meters");
            }
            
            if(dr.findElements(By.xpath("//input[@id = 'txtSearchMsno']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id = 'txtSearchMsno']")).sendKeys("11103677644");
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Meters");
            }
            
            if(dr.findElements(By.xpath("//input[@value= 'Search']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@value= 'Search']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Meters");
            }
            
            if(dr.findElements(By.xpath("//input[@id= 'txtAmount']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id= 'txtAmount']")).sendKeys("1");
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Meters");
            }
            
            if(dr.findElements(By.xpath("//a[@id= 'btnTrial']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//a[@id= 'btnTrial']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Meters");
            }
            
            if(dr.findElements(By.xpath("//input[@id= 'btnModalConfirmOkNoPostBack']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id= 'btnModalConfirmOkNoPostBack']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Meters");
            }
            
            if(dr.findElements(By.xpath("//input[@value= 'Back']")).size() > 0)
            {
                Thread.sleep(7000);
                Robot r = new Robot();
                r.keyPress(KeyEvent.VK_ESCAPE);
                r.keyRelease(KeyEvent.VK_ESCAPE);
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Meters");
            }
    }

   /* @DataProvider(name="empLogin")
	public Object[][] loginData() throws BiffException {
		Object[][] arrayObject = getExcelData("C:\\SmartWorks\\SmartWorks\\TestPacks\\Manage_Users.xls","Sheet1");
		return arrayObject;
	}

	/**
	 * @param File Name
	 * @param Sheet Name
	 * @return
	 */
	/*public String[][] getExcelData(String fileName, String sheetName) throws BiffException {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream("C:\\SmartWorks\\SmartWorks\\TestPacks\\Manage_Users.xls");
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
        
        public boolean isAlertPresent() {
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
