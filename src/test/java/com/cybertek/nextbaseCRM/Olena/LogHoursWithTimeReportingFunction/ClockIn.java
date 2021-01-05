package com.cybertek.nextbaseCRM.Olena.LogHoursWithTimeReportingFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ClockIn {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://login2.nextbasecrm.com");
        driver.findElement(By.name("USER_LOGIN")).sendKeys("hr59@cybertekschool.com" + Keys.ENTER);
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser");
        driver.findElement(By.className("login-btn")).click();

        driver.manage().window().maximize();
        // click on Clock in, pop-up window will open:
        driver.findElement(By.id("timeman-status")).click();

        //check work duration time, if it is 0:00:00, then you are able to clock in,
        // otherwise previous working day hasn't ended up yet and you cannot clock in:
        String timeBeforeClockIn = driver.findElement(By.className("tm-popup-notice-time")).getText();

        if (timeBeforeClockIn.equals("00000")) {
            driver.findElement(By.cssSelector("span[class='webform-small-button-text']")).click();
        } else {
            System.out.println("Previous working day has not ended up yet, you cannot clock in more than once within same working day");
        }

        //verify that working time began counting:
        String timeAfterClockIn = driver.findElement(By.className("tm-popup-notice-time")).getText();

        if (timeAfterClockIn.equals("00000")) {
            System.out.println("Clock in functionality test failed");
        } else {
            System.out.println("User hr59@cybertekschool.com has clocked in successfully");
        }

        driver.close();


        // Environment used: login2.nextbasecrm.com
        // Data used: username: hr59@cybertekschool.com
        //            password: UserUser
        // Precondition: User is logged in to the home page using valid credentials
        // Expected result: user can clock in
        // Actual result: user clocked in

    }
}