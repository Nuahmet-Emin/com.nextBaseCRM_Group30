package com.cybertek.nextbaseCRM.Olena.LogHoursWithTimeReportingFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class EditStartingEndingTime {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com");
        driver.findElement(By.name("USER_LOGIN")).sendKeys("hr59@cybertekschool.com" + Keys.ENTER);
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser");
        driver.findElement(By.className("login-btn")).click();

        driver.manage().window().maximize();

        //click on main "clock out button" from the top menu:
        driver.findElement(By.id("timeman-info")).click();

        //click on edit time pencil button:
        WebElement pencilMark = driver.findElement(By.className("tm-popup-notice-pencil"));
        pencilMark.click();
        Thread.sleep(4000);
        //check working time duration:
        //WebElement workingTimeDuration = driver.findElement(By.xpath("//span[@class='bx-tm-report-field']"));

        //increase hours and minutes:
        List<WebElement> increaseHoursAndMinutes = driver.findElements(By.xpath("//td[@title='Increase (Up)']"));
        for(WebElement each:increaseHoursAndMinutes){
            each.click();
        }
        //check am/pm buttons functionality:
        //WebElement startingTimeAmPm = driver.findElement(By.xpath("//span[@title='a.m.'][1]"));
        //startingTimeAmPm.click();
        //WebElement endingTimeAmPm = driver.findElement(By.xpath("//span[@title='a.m.'][2]"));
        //endingTimeAmPm.click();

        //enter reason:
        driver.findElement(By.xpath("//div[@class='bx-tm-popup-clock-wnd-report']/textarea")).sendKeys("reason"+ Keys.ENTER);

        //click "Save" button:
        driver.findElement(By.xpath("//span[@class='popup-window-button popup-window-button-create']")).click();

        WebElement workingDayDuration = driver.findElement(By.xpath("//div[@class='tm-popup-notice']"));

        if(workingDayDuration.isDisplayed()){
            System.out.println("Starting/Ending time edit functionality test passed");
        }else{
            System.out.println("Starting/Ending time edit functionality test failed");
        }
        driver.close();

        // Environment used: login2.nextbasecrm.com
        // Data used: username: hr59@cybertekschool.com
        //            password: UserUser
        // Precondition: User is logged in to the home page with valid credentials
        //               and clocked in
        // Expected result: user can edit starting and ending time
        // Actual result: user can edit starting and ending time
    }
}
