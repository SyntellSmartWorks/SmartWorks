/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static smartworks.SmartWorks.dr;

/**
 *
 * @author Reece
 */
public class SmartWorks_Logout
{
    public static WebDriver dr;
   public void logout() throws Exception
   {
            if(dr.findElements(By.xpath("//*[@id='top-nav']/ul/li/a/span/i")).size() > 0)
            {
                Thread.sleep(500);
                dr.findElement(By.xpath("//*[@id='top-nav']/ul/li/a/span/i")).click();
                dr.findElement(By.xpath("//li//a[text() = 'Log Out']")).click();
            }   
    }
}
