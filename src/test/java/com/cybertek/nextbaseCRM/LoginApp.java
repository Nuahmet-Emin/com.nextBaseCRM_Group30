package com.nextBaseCRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginApp {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://login2.nextbasecrm.com");

        //enter username marketing60@cybertekschool.com
        driver.findElement(By.name("USER_LOGIN")).sendKeys("marketing60@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser");
        driver.findElement(By.id("USER_REMEMBER")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("login-btn")).click();
        Thread.sleep(3000);
       // driver.findElement(By.className("login-link-forgot-pass")).click();

       String expectedLogo="CRM";
        String actualLogo=driver.findElement(By.className("logo-text")).getText();
        if(actualLogo.contains(expectedLogo)) {
           System.out.println("Login verification is passed!");
        } else{
            System.out.println("login verification is failed!");
        }
        System.out.println("actualLogo = "+actualLogo);
        System.out.println("expectedLogo = "+ expectedLogo);

        // driver.close();

    }


}

