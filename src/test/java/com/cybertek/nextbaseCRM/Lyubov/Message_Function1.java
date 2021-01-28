package com.cybertek.nextbaseCRM.Lyubov;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Message_Function1 {

    WebDriver driver;
    @BeforeMethod
    public void setup() {

    //set up WebDriverManager
     WebDriverManager.chromedriver().

    setup();

    //open browser
    WebDriver driver = new ChromeDriver();
    //open web Browser
            driver.get("https://login2.nextbasecrm.com");
            driver.manage(). window(). maximize();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

//login
driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']")).sendKeys("hr59@cybertekschool.com");

//password
  driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']")).sendKeys("UserUser");

}
    @Test
    public void Test() {

//open "Activity Stream" page
       // driver.findElement(By.xpath("//input[@class = 'login-btn']")).click();
        //sleep(2);

//open "Message body" where you can write the message
        driver.findElement(By.xpath("//span[@id = 'feed-add-post-form-tab-message']")).click();

//open the link icon
        driver.findElement(By.xpath(("//span[@id = 'bx-b-link-blogPostForm']"))).click();
        sleep(2);

//write a message in a text window
        driver.findElement(By.id("linkidPostFormLHE_blogPostForm-text")).sendKeys("Open Amazon");
        sleep(2);

//write "www.amazon.com" in a Link window
        driver.findElement(By.id("linkidPostFormLHE_blogPostForm-href")).sendKeys("www.amazon.com");
        sleep(2);
// click 'save'
        driver.findElement(By.xpath(("//input[@class = 'adm-btn-save']"))).click();
        sleep(2);

//click 'SEND'
        driver.findElement(By.xpath("//button[@id = 'blog-submit-button-save']")).click();
        sleep(2);
        //click 'CANCEL'
        //driver.findElement(By.xpath("//button[@class = 'ui-btn ui-btn-lg ui-btn-link']")).click();
    }

    @AfterMethod
    public void teardown() {
        sleep(5);
        driver.close();
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
//write a message in the body

//WebElement iframe = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
//iframe.sendKeys("Good afternoon! How are you?");
//driver.switchTo().frame(iframe);
// sleep(3);

        /* WebElement iframe = driver.findElement(By.xpath("//iframe[@class = 'bx-editor-iframe']"));
        driver.switchTo().frame(iframe);
        iframe.sendKeys("Good afternoon! How are you?");
        sleep(2);*/