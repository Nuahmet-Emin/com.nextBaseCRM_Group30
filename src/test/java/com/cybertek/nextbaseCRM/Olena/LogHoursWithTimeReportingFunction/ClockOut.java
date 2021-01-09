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
