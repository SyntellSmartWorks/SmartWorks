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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Reece
 */
public class SmartWorks extends SmartWorksWindow
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
            System.setProperty("webdriver.chrome.driver", "C:\\SmartWorks\\SmartWorks\\chromedriver.exe");
            //String URL = ip;
            String defURL = "http://syn-tst-net-smw.syntell.net/STELLBTEST/WA/SB/AppStart/Login.aspx";
            dr = new ChromeDriver();
        
          dr.get(defURL);
        dr.manage().window().maximize();
        
        if(dr.findElements(By.xpath("//input[@name = 'txtUsername']")).size() > 0)
            {
            dr.findElement(By.xpath("//input[@name = 'txtUsername']")).sendKeys(username);
            dr.findElement(By.xpath("//input[@name = 'txtPassword']")).sendKeys(password);
            /*dr.findElement(By.xpath("//input[@name = 'txtUsername']")).sendKeys("Reece");
            dr.findElement(By.xpath("//input[@name = 'txtPassword']")).sendKeys("Reece@01");*/
            dr.findElement(By.xpath("//input[@name = 'btnLoginSubmit']")).click();
            test.log(LogStatus.PASS, "Successfully signed into SmartWorks");
            if(dr.findElements(By.xpath("//span[@class = 'ErrorWrap']")).size() > 0)
            {
                //Thread.sleep(500);
                String text = dr.findElement(By.xpath("//span[@class = 'ErrorWrap']")).getText();
                test.log(LogStatus.PASS, "Successfully navigated to Meters");
            }
            }
            
	}
    @Test(dataProvider="empLogin")
    public void addcus(String Meter, String SPT, String Region, String DPT, String CAT, String BP) throws Exception
	
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
                dr.findElement(By.xpath("//input[@id = 'txtMeterAdd_SingleMsno']")).sendKeys(Meter);
                test.log(LogStatus.PASS, "Successfully entered Meter Number");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to enter Meter Number");
            }
            
            if(dr.findElements(By.xpath("//input[@value = 'Add']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@value = 'Add']")).click();
                test.log(LogStatus.PASS, "Successfully clicked Add meter button to loaded meters list");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to click Add meter button to loaded meters list");
            }
            
            //==================================SETTING UP ADDED METER=======================================//
            if(dr.findElements(By.xpath("//*[@id='ddlEditMtrPrpsPopup_MtrStatus_chosen']/a/div/b")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//*[@id='ddlEditMtrPrpsPopup_MtrStatus_chosen']/a/div/b")).click();
                test.log(LogStatus.PASS, "Successfully clicked Meter Status dropdown button");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to click Meter Status dropdown button");
            }
            
            if(dr.findElements(By.xpath("//li[text() = 'Active']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//li[text() = 'Active']")).click();
                test.log(LogStatus.PASS, "Successfully selected option from Meter Status dropdown");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select option from Meter Status dropdown");
            }
            
            if(dr.findElements(By.xpath("//*[@id='ddlMeterResource_chosen']/a/div/b")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//*[@id='ddlMeterResource_chosen']/a/div/b")).click();
                test.log(LogStatus.PASS, "Successfully clicked Resource dropdown button");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to click Resource dropdown button");
            }
            
            if(dr.findElements(By.xpath("//li[text() = 'Electricity']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//li[text() = 'Electricity']")).click();
                test.log(LogStatus.PASS, "Successfully selected option from Resource dropdown");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select option from Resource dropdown");
            }
            
            if(dr.findElements(By.xpath("//*[@id='ddlEditMtrPrpsPopup_MtrType_chosen']/a/div/b")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//*[@id='ddlEditMtrPrpsPopup_MtrType_chosen']/a/div/b")).click();
                test.log(LogStatus.PASS, "Successfully clicked Meter Type dropdown button");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to click Meter Type dropdown button");
            }
            
            if(dr.findElements(By.xpath("//li[text() = 'LANDIS AND GEYR STS']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//li[text() = 'LANDIS AND GEYR STS']")).click();
                test.log(LogStatus.PASS, "Successfully selected option from Meter Type dropdown");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select option from Meter Type dropdown");
            }
            
            if(dr.findElements(By.xpath("//*[@id='ddlEditMtrPrpsPopup_VendingGateway_chosen']/a/div/b")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//*[@id='ddlEditMtrPrpsPopup_VendingGateway_chosen']/a/div/b")).click();
                test.log(LogStatus.PASS, "Successfully clicked Vending Gateway dropdown button");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to click Vending Gateway dropdown button");
            }
            
            if(dr.findElements(By.xpath("//li[text() = 'SGC:000266 KRN:1 TI:1']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//li[text() = 'SGC:000266 KRN:1 TI:1']")).click();
                test.log(LogStatus.PASS, "Successfully selected option from Vending Gateway dropdown");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select option from Vending Gateway dropdown");
            }
            
            if(dr.findElements(By.xpath("//*[@id='ddlEditMtrPrpsPopup_Profile_chosen']/a/div/b")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//*[@id='ddlEditMtrPrpsPopup_Profile_chosen']/a/div/b")).click();
                test.log(LogStatus.PASS, "Successfully clicked Meter Profile dropdown button");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to click Meter Profile dropdown button");
            }
            
            if(dr.findElements(By.xpath("//li[text() = '30 AMP METER PROFILE']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//li[text() = '30 AMP METER PROFILE']")).click();
                test.log(LogStatus.PASS, "Successfully selected option from Meter Profile dropdown");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select option from Meter Profile dropdown");
            }
            
            if(dr.findElements(By.xpath("//input[@id= 'btnEditMtrPrpsPopup_OK']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id= 'btnEditMtrPrpsPopup_OK']")).click();
                test.log(LogStatus.PASS, "Successfully clicked OK button on meter setup");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to click OK button on meter setup");
            }
            
            //=========================================METER DIVISION============================================//
            
            if(dr.findElements(By.xpath("//*[@id='ddlMeterAddStore_chosen']/a/div/b")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//*[@id='ddlMeterAddStore_chosen']/a/div/b")).click();
                test.log(LogStatus.PASS, "Successfully clicked Store Location dropdown button");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to click Meter Type dropdown button");
            }
            
            if(dr.findElements(By.xpath("//li[text() = 'ZOLISA NCGENE - STELLENBOSCH']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//li[text() = 'ZOLISA NCGENE - STELLENBOSCH']")).click();
                test.log(LogStatus.PASS, "Successfully selected option from Store Location dropdown");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select option from Store Location dropdown");
            }
            
            if(dr.findElements(By.xpath("//div[@class = 'dx-dropdowneditor-icon']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//div[@class = 'dx-dropdowneditor-icon']")).click();
                test.log(LogStatus.PASS, "Successfully clicked on Date icon");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to click on Date icon");
            }
            
            if(dr.findElements(By.xpath("//span[text() = 'Done']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//span[text() = 'Done']")).click();
                test.log(LogStatus.PASS, "Successfully selected Date");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select Date");
            }
            
            if(dr.findElements(By.xpath("//input[@value = 'Save']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@value = 'Save']")).click();
                test.log(LogStatus.PASS, "Successfully Saved Division details");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to Save Division details");
            }
            
            if(dr.findElements(By.xpath("//input[@id= 'btnModalConfirmOK']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id= 'btnModalConfirmOK']")).click();
                test.log(LogStatus.PASS, "Successfully confirmed the Saved Division details");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to confirm Save Division details");
            }
        //==========================ADD SERVICE POINTS========================================================//
        
            dr.findElement(By.xpath("//li[@id= 'menu40000']//a[@href = '#']")).sendKeys(Keys.PAGE_UP);
                    
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
            
            if(dr.findElements(By.xpath("//span[text() = '- SELECT -']/../..//li[text() = '"+SPT+"']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//span[text() = '- SELECT -']/../..//li[text() = '"+SPT+"']")).click();
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
            
            if(dr.findElements(By.xpath("//span[text() = '- SELECT -']/../..//li[text() = '"+Region+"']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//span[text() = '- SELECT -']/../..//li[text() = '"+Region+"']")).click();
                test.log(LogStatus.PASS, "Successfully selected Service Point region");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select Service Point region");
            }
            
            if(dr.findElements(By.xpath("//button[text() = 'Add']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//button[text() = 'Add']")).sendKeys(Keys.PAGE_UP);
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
            
            if(dr.findElements(By.xpath("//span[text() = '- SELECT -']/../..//li[text() = '"+DPT+"']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//span[text() = '- SELECT -']/../..//li[text() = '"+DPT+"']")).click();
                test.log(LogStatus.PASS, "Successfully selected Dispensing Point type");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select Dispensing Point type");
            }
            
            if(dr.findElements(By.xpath("//input[@id = 'btnDpDetailsOK']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id = 'btnDpDetailsOK']")).click();
                test.log(LogStatus.PASS, "Successfully added Dispensing Point details");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to add Dispensing Point details");
            }
            
            if(dr.findElements(By.xpath("//button[@id = 'btnActions']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//button[@id = 'btnActions']")).click();
                test.log(LogStatus.PASS, "Successfully clicked on Dispensing Point(s) Actions dropdown");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to click on Dispensing Point(s) Actions dropdown");
            }
            
            if(dr.findElements(By.xpath("//a[text() = ' Install a Meter']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//a[text() = ' Install a Meter']")).click();
                test.log(LogStatus.PASS, "Successfully selected Install a Meter on Dispensing Point(s) Actions dropdown");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select Install a Meter on Dispensing Point(s) Actions dropdown");
            }
            if(isAlertPresent())
            
            
            //=======================================ADDING METER TO DISPENSING POINTS====================================//
            
                Thread.sleep(1000);
            if(dr.findElements(By.xpath("//input[@id = 'txtMeterSearchPopupMsno']")).size() > 0)
            {
                Thread.sleep(1000);
                dr.findElement(By.xpath("//input[@id = 'txtMeterSearchPopupMsno']")).sendKeys(Meter);
                test.log(LogStatus.PASS, "Successfully entered Meter number");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to enter Meter number");
            }
            
            if(dr.findElements(By.xpath("//input[@value = 'Search']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@value = 'Search']")).click();
                test.log(LogStatus.PASS, "Successfully clicked search button");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to click search button");
            }
            
            if(dr.findElements(By.xpath("//a[@id = 'lnkMeterSearchPopupSelect']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//a[@id = 'lnkMeterSearchPopupSelect']")).click();
                test.log(LogStatus.PASS, "Successfully found and selected meter");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to find and selected meter");
            }
            
            if(dr.findElements(By.xpath("//div[@class = 'dx-dropdowneditor-icon']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//label[text() = 'Installation Date']")).click();
                Actions actions = new Actions(dr);
                actions.sendKeys(Keys.ARROW_DOWN);
                actions.build().perform();
                actions.sendKeys(Keys.ARROW_DOWN);
                actions.build().perform();
                Thread.sleep(500);
                dr.findElement(By.xpath("//div[@class = 'dx-dropdowneditor-icon']")).click();
                test.log(LogStatus.PASS, "Successfully clicked on Installation Date icon");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to click on Installation Date icon");
            }
            
            if(dr.findElements(By.xpath("//span[text() = 'Done']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//div/div[2]/div/div/div/div/div[2]/div/div/div[3]/div/div/div/div[2]/div/div[1]/div")).click();
                dr.findElement(By.xpath("//span[text() = 'Done']")).click();
                test.log(LogStatus.PASS, "Successfully selected Installation Date");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select Installation Date");
            }
            
            if(dr.findElements(By.xpath("//input[@id= 'btnMeterSearchPopupOK']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id= 'btnMeterSearchPopupOK']")).click();
                test.log(LogStatus.PASS, "Successfully completed Service Points/Install a Meter");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to complete Service Points/Install a Meter");
            }
            
            if(dr.findElements(By.xpath("//input[@id= 'btnModalConfirmOK']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id= 'btnModalConfirmOK']")).click();
                test.log(LogStatus.PASS, "Successfully confirmed the completion of Service Points/Install a Meter");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to confirm the completion of Service Points/Install a Meter");
            }
            
            if(dr.findElements(By.xpath("//button[text() = 'Add']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//button[text() = 'Add']")).sendKeys(Keys.PAGE_DOWN);
                dr.findElement(By.xpath("//input[@value = 'Save']")).click();
                test.log(LogStatus.PASS, "Successfully clicked on Service Points Save button");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to click on Service Points Save button");
            }
            
            if(dr.findElements(By.xpath("//input[@id= 'btnModalConfirmOK']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id= 'btnModalConfirmOK']")).click();
                test.log(LogStatus.PASS, "Successfully confirmed the completion of Service Point");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to confirm the completion of Service Point");
            }
            
            if(dr.findElements(By.xpath("//input[@name= 'ctl00$btnModalSuccessOkWithPostback']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@name= 'ctl00$btnModalSuccessOkWithPostback']")).click();
            }
            
            String reference = dr.findElement(By.xpath("//span[@id= 'lblDpRef']")).getText();
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
            
            if(dr.findElements(By.xpath("//span[text() = '- SELECT -']/../..//li[text() = '"+CAT+"']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//span[text() = '- SELECT -']/../..//li[text() = '"+CAT+"']")).click();
                test.log(LogStatus.PASS, "Successfully selected Consumer Account type");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select Consumer Account type");
            }
            
            if(dr.findElements(By.xpath("//input[@id= 'txtCustAccRef']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id= 'txtCustAccRef']")).sendKeys(Meter);
                test.log(LogStatus.PASS, "Successfully entered Consumer Account reference");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to enter Consumer Account reference");
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
            
            if(dr.findElements(By.xpath("//span[text() = '- SELECT -']/../..//li[text() = '"+BP+"']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//span[text() = '- SELECT -']/../..//li[text() = '"+BP+"']")).click();
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
            //===========================ADD CONSUMER METER============================================//
            if(dr.findElements(By.xpath("//input[@id = 'txtSearchMsno']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id = 'txtSearchMsno']")).sendKeys(Meter);
                test.log(LogStatus.PASS, "Successfully entered Consumer Account meter");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to enter Consumer Account meter");
            }
            
            if(dr.findElements(By.xpath("//input[@id= 'btnFind']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id= 'btnFind']")).click();
                test.log(LogStatus.PASS, "Successfully clicked on Consumer Account meter Search button");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to click on Consumer Account meter Search button");
            }
            
            if(dr.findElements(By.xpath("//input[@id= 'chkDp']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id= 'chkDp']")).click();
                test.log(LogStatus.PASS, "Successfully associated Consumer Account meter");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to associate Consumer Account meter");
            }
            
            if(dr.findElements(By.xpath("//input[@id= 'btnDpSelectPopupOK']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id= 'btnDpSelectPopupOK']")).click();
                test.log(LogStatus.PASS, "Successfully confirmed association of Consumer Account meter");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to confirm association of Consumer Account meter");
            }
            //======================================BACK TO SERVICE ACCOUNTS DETAILS========================================//
            if(dr.findElements(By.xpath("//select[@id = 'ctl00_cphPage_ucCSA-1_ddlRes']//option[text() = 'Electricity']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//select[@id = 'ctl00_cphPage_ucCSA-1_ddlRes']//option[text() = 'Electricity']")).click();
                Thread.sleep(500);
              //  dr.findElement(By.xpath("//*[@id='divServStartDateBox']/div[1]/div/div[2]/div/div/div")).click();
                test.log(LogStatus.PASS, "Successfully selected Service Account Resource type");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select Service Account Resource type");
            }
            
            if(dr.findElements(By.xpath("//a[@id = 'lnkTrfSchedule']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//a[@id = 'lnkTrfSchedule']")).click();
                Thread.sleep(500);
                test.log(LogStatus.PASS, "Successfully navigated to tariff profile");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to navigate to tariff profile");
            }
            
            if(dr.findElements(By.xpath("//select[@id = 'ddlTrfSearchPopup_TrfProfile']//option[text() = 'Domestic Low 01 (Dom 2)']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//select[@id = 'ddlTrfSearchPopup_TrfProfile']//option[text() = 'Domestic Low 01 (Dom 2)']")).click();
                Thread.sleep(500);
                test.log(LogStatus.PASS, "Successfully selected tariff profile");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select tariff profile");
            }
            
            if(dr.findElements(By.xpath("//select[@id = 'ddlTrfSearchPopup_ReqMtrReading']//option[text() = 'Yes']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//select[@id = 'ddlTrfSearchPopup_ReqMtrReading']//option[text() = 'Yes']")).click();
                Thread.sleep(500);
                test.log(LogStatus.PASS, "Successfully selected Request Meter Reading option");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to select Request Meter Reading option");
            }
            
            if(dr.findElements(By.xpath("//input[@id = 'btnTrfSearchPopupOK']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id = 'btnTrfSearchPopupOK']")).click();
                Thread.sleep(500);
                test.log(LogStatus.PASS, "Successfully confirmed Tariff Profile");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to confirm Tariff Profile");
            }
            
            if(dr.findElements(By.xpath("//input[@value= 'Save']")).size() > 0)
            {
                Thread.sleep(500);
               // dr.findElement(By.xpath("//span[text() = 'Done']")).click();
                Actions actions = new Actions(dr);
                actions.sendKeys(Keys.PAGE_DOWN);
                actions.build().perform();
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@value= 'Save']")).click();
                test.log(LogStatus.PASS, "Successfully saved Consumer Service details");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to save Consumer Service details");
            }
            
            if(dr.findElements(By.xpath("//input[@id= 'btnModalConfirmOK']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@id= 'btnModalConfirmOK']")).click();
                test.log(LogStatus.PASS, "Successfully confirmed creation of Consumer Account");
            }
            else
            {
                test.log(LogStatus.FAIL, "Failed to confirm  creation of Consumer Account");
            }
            
            if(dr.findElements(By.xpath("//input[@name= 'ctl00$btnModalSuccessOkWithPostback']")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//input[@name= 'ctl00$btnModalSuccessOkWithPostback']")).click();
            }
    }
    
    @DataProvider(name="empLogin")
	public Object[][] loginData() throws BiffException {
		Object[][] arrayObject = getExcelData("C:\\SmartWorks\\SmartWorks\\TestPacks\\Manage_Users.xls","Sheet1");
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
}
}
