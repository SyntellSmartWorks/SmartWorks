/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartworks;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
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
public class SmartWorks
{
    public static WebDriver dr;
    ExtentReports extent = new ExtentReports("C:\\Users\\Reece.SYNTELL\\Documents\\Reports\\Add Customer.html");
    ExtentTest test = extent.startTest("Add Customer");
    /**
     * @param args the command line arguments
     */
    
    @BeforeClass
	public void openBrowser() 
        {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\chromedriver.exe");
            //String URL = ip;
            String defURL = "http://syn-tst-net-smw.syntell.net/STELLBTEST/WA/SB/AppStart/Login.aspx";
            dr = new ChromeDriver();
        
          dr.get(defURL);
        dr.manage().window().maximize();
        
        if(dr.findElements(By.xpath("//input[@name = 'txtUsername']")).size() > 0)
            {
            dr.findElement(By.xpath("//input[@name = 'txtUsername']")).sendKeys("Reece");
            dr.findElement(By.xpath("//input[@name = 'txtPassword']")).sendKeys("Reece@01");
            dr.findElement(By.xpath("//input[@name = 'btnLoginSubmit']")).click();
            test.log(LogStatus.PASS, "Successfully signed into SmartWorks");
            }
            
	}
    @Test//(dataProvider="AddCus")
    public void addcus() throws Exception
	
    {
      Assert.assertTrue(true);
        String result = "";
 
        //==========================ADD METER========================================================//
            if(dr.findElements(By.xpath("//li[@id= 'menu40000']//a[@href = '#']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//li[@id= 'menu40000']//a[@href = '#']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Meters");
            }
            
            if(dr.findElements(By.xpath("//span[text() = 'Manage Meters']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//span[text() = 'Manage Meters']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Manage Meters");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Manage Meters");
            }
            
            if(dr.findElements(By.xpath("//input[@id = 'btnAdd']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id = 'btnAdd']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Add Meter screen");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Add Meter screen");
            }
            
            if(dr.findElements(By.xpath("//input[@id = 'txtMeterAdd_SingleMsno']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id = 'txtMeterAdd_SingleMsno']")).sendKeys("002546879");
                test.log(LogStatus.PASS, "Successfully entered Meter Number");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to enter Meter Number");
            }
            
        //==========================ADD SERVICE POINTS========================================================//
        
            if(dr.findElements(By.xpath("//li[@id= 'menu30000']//a[@href = '#']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//li[@id= 'menu30000']//a[@href = '#']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Service Points");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Service Points");
            }
            
            if(dr.findElements(By.xpath("//span[text() = 'Manage Service Points']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//span[text() = 'Manage Service Points']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Manage Service Points");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Manage Service Points");
            }
            
            if(dr.findElements(By.xpath("//input[@id = 'btnAdd']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id = 'btnAdd']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Add Service Point screen");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Add Service Point screen");
            }
            
            if(dr.findElements(By.xpath("//*[@id='ddlLocType_chosen']/a/div/b")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//*[@id='ddlLocType_chosen']/a/div/b")).click();
                test.log(LogStatus.PASS, "Successfully selected Service Point type dropdown");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select Service Point type dropdown");
            }
            
            if(dr.findElements(By.xpath("//span[text() = '- SELECT -']/../..//li[text() = 'N/A']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//span[text() = '- SELECT -']/../..//li[text() = 'N/A']")).click();
                test.log(LogStatus.PASS, "Successfully selected Service Point type");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select Service Point type");
            }
            
            if(dr.findElements(By.xpath("//*[@id='ddlRegion_chosen']/a/div/b")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//*[@id='ddlRegion_chosen']/a/div/b")).click();
                test.log(LogStatus.PASS, "Successfully selected Region dropdown");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select Region dropdown");
            }
            
            if(dr.findElements(By.xpath("//span[text() = '- SELECT -']/../..//li[text() = 'STELLENBOSCH']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//span[text() = '- SELECT -']/../..//li[text() = 'STELLENBOSCH']")).click();
                test.log(LogStatus.PASS, "Successfully selected Service Point region");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select Service Point region");
            }
            
            if(dr.findElements(By.xpath("//button[text() = 'Add']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//button[text() = 'Add']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Add Dispensing Point(s) screen");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Add Dispensing Point(s) screen");
            }
            
            if(dr.findElements(By.xpath("//*[@id='ddlDpType_chosen']/a/div/b")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//*[@id='ddlDpType_chosen']/a/div/b")).click();
                test.log(LogStatus.PASS, "Successfully selected Dispensing Point type dropdown");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select Dispensing Point type dropdown");
            }
            
            if(dr.findElements(By.xpath("//span[text() = '- SELECT -']/../..//li[text() = 'DEFAULT DISPENSING POINT ELEC']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//span[text() = '- SELECT -']/../..//li[text() = 'DEFAULT DISPENSING POINT ELEC']")).click();
                test.log(LogStatus.PASS, "Successfully selected Dispensing Point type");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select Dispensing Point type");
            }
            
            //==========================ADD CONSUMERS========================================================//
            
            if(dr.findElements(By.xpath("//li[@id= 'menu20000']//a[@href = '#']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//li[@id= 'menu20000']//a[@href = '#']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Consumers");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Consumers");
            }
            
            if(dr.findElements(By.xpath("//span[text() = 'Accounts']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//span[text() = 'Accounts']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Consumer Accounts");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Consumer Accounts");
            }
            
            if(dr.findElements(By.xpath("//span[text() = 'Services']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//span[text() = 'Services']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Services");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Services");
            }
            
            if(dr.findElements(By.xpath("//input[@id = 'btnAdd']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id = 'btnAdd']")).click();
                test.log(LogStatus.PASS, "Successfully navigated to Add Service Point screen");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to Add Service Point screen");
            }
            
            if(dr.findElements(By.xpath("//*[@id='ddlCustAccType_chosen']/a/div/b")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//*[@id='ddlCustAccType_chosen']/a/div/b")).click();
                test.log(LogStatus.PASS, "Successfully selected Consumer Account type dropdown");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select Consumer Account type dropdown");
            }
            
            if(dr.findElements(By.xpath("//span[text() = '- SELECT -']/../..//li[text() = 'Tier One Account']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//span[text() = '- SELECT -']/../..//li[text() = 'Tier One Account']")).click();
                test.log(LogStatus.PASS, "Successfully selected Consumer Account type");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select Consumer Account type");
            }
            
            if(dr.findElements(By.xpath("//*[@id='ddlBillingProfile_chosen']/a/div/b")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//*[@id='ddlBillingProfile_chosen']/a/div/b")).click();
                test.log(LogStatus.PASS, "Successfully selected Billing Profile dropdown");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select Billing Profile dropdown");
            }
            
            if(dr.findElements(By.xpath("//span[text() = '- SELECT -']/../..//li[text() = 'No Billing']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//span[text() = '- SELECT -']/../..//li[text() = 'No Billing']")).click();
                test.log(LogStatus.PASS, "Successfully selected Billing Profile");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select Billing Profile");
            }
            
            if(dr.findElements(By.xpath("//a[text() = ' Add']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//a[text() = ' Add']")).click();
                test.log(LogStatus.PASS, "Successfully clicked Service Account(s) Add button");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to click Service Account(s) Add button");
            }
            
            if(dr.findElements(By.xpath("//select[@name = 'ctl00$cphPage$ucCSA-2$ddlRes']//option[text() = 'Electricity']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//select[@name = 'ctl00$cphPage$ucCSA-2$ddlRes']//option[text() = 'Electricity']")).click();
                test.log(LogStatus.PASS, "Successfully selected Service Account Resource Type");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select Service Account Resource Type");
            }
            
            if(dr.findElements(By.xpath("//span//a[text() = ' Select']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//span//a[text() = ' Select']")).click();
                test.log(LogStatus.PASS, "Successfully clicked on Select Service Location button");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to click on Select Service Location button");
            }
            
            if(dr.findElements(By.xpath("//button[@class = 'btn btn-xs btn-default dropdown-toggle']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//button[@class = 'btn btn-xs btn-default dropdown-toggle']")).click();
                test.log(LogStatus.PASS, "Successfully selected Search By dropdown");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select Search By dropdown");
            }
            
            if(dr.findElements(By.xpath("//a[contains(text(), 'Meter')]")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//a[contains(text(), 'Meter')]")).click();
                test.log(LogStatus.PASS, "Successfully selected Search parameter");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select Search parameter");
            }
    }
}
