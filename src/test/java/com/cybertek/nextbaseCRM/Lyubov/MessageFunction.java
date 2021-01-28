package com.cybertek.nextbaseCRM.Lyubov;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MessageFunction {

        public static void main(String[] args) throws InterruptedException {
//Test1 working on my Own Branch; 01/28/2020

            //set up WebDriverManager
            WebDriverManager.chromedriver().setup();
            //open browser
            WebDriver driver = new ChromeDriver();
            //open web Browser
            driver.get("https://login2.nextbasecrm.com");
            driver.manage().window().maximize();

//login
            driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']")).sendKeys("hr59@cybertekschool.com");
//password
            driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']")).sendKeys("UserUser");

            Thread.sleep(2000);
//opened "Activity Stream" page
            driver.findElement(By.xpath("//input[@class = 'login-btn']")).click();

            Thread.sleep(2000);

//opened "Message body" where you can write the message
            driver.findElement(By.xpath("//span[@id = 'feed-add-post-form-tab-message']")).click();

            Thread.sleep(5000);

//open the link icon
            driver.findElement(By.xpath(("//span[@id = 'bx-b-link-blogPostForm']"))).click();

            Thread.sleep(12000);

// attach(save button) the text and link
            driver.findElement(By.xpath(("//input[@class = 'adm-btn-save']"))).click();

//send the message
            driver.findElement(By.xpath("//button[@id = 'blog-submit-button-save']")).click();

//cancel the message
//driver.findElement(By.xpath("//button[@class = 'ui-btn ui-btn-lg ui-btn-link']")).click();

            driver.close();
        }

    }