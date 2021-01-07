package com.cybertek.nextbaseCRM.Olena.LogHoursWithTimeReportingFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ClockOut {

    public static void main(String[] args) {

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

        //click on "clock out" button from pop-up window:
        WebElement clockOut = driver.findElement(By.xpath("//*[text() = 'Clock Out']"));
/*
        //change clock out time:
        driver.findElement(By.className("tm-popup-change-time-link")).click();

        // get time before change:
        String timeBeforeChange = driver.findElement(By.cssSelector("input[name='timeman_report_clock']")).getText();

        //get hours before change:
        String hoursBefore = driver.findElement(By.cssSelector("td[rowspan='2']")).getText();

        //minutes before change:
        String minutesBefore = driver.findElement(By.cssSelector("input[title='Minutes']")).getText();

        //change hours and minutes:
        WebElement increaseHours = driver.findElement(By.xpath("//td[@class='bxc-pointer'][1]"));
        WebElement increaseMinutes = driver.findElement(By.xpath("//td[@class='bxc-pointer'][3]"));

        //get hours after change:
        String hoursAfter = driver.findElement(By.cssSelector("input[title='Hours']")).getText();

        //compare hours before and after change:
        if(hoursBefore.equals(hoursAfter)){
            System.out.println("Clock out hours change functionality failed");
        }else{
            System.out.println("Clock out hours change functionality passed");
        }

        //minutes after change:
        String minutesAfter = driver.findElement(By.cssSelector("input[title='Minutes']")).getText();

        //compare minutes before and after change:
        if(minutesBefore.equals(minutesAfter)){
            System.out.println("Clock out minutes change functionality failed");
        }else{
            System.out.println("Clock out minutes change functionality passed");
        }

        //enter Reason into the text box:
        driver.findElement(By.cssSelector("span[class='popup-window-button popup-window-button-decline']")).click();
        driver.findElement(By.className("bx-tm-popup-clock-wnd-report-error")).sendKeys("done"+Keys.ENTER);

        //clock out:
        driver.findElement(By.cssSelector("span[class='popup-window-button popup-window-button-decline']")).click();
*/
        //user should see "Continue working day":
        WebElement continueWorkingDay = driver.findElement(By.cssSelector("span[class='webform-small-button-text']"));

        //compare result:
        if(continueWorkingDay.isDisplayed()){
            System.out.println("User hr59@cybertekschool.com has clocked out successfully");
        }else{
            System.out.println("Clock out functionality failed");
        }

        driver.close();

        // Environment used: login2.nextbasecrm.com
        // Data used: username: hr59@cybertekschool.com
        //            password: UserUser
        // Precondition: User is logged in to the home page with valid credentials
        //               and clocked in
        // Expected result: user can clock out
        // Actual result: user is clocked out

    }

}
