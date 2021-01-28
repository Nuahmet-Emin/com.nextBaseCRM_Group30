package com.cybertek.nextbaseCRM.Cem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class PostHomePage {

    public static void main(String[] args) throws InterruptedException {

        //  Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://login2.nextbasecrm.com/");

        // Verify title equals:
        // Expected: Authorization
        String expectedTitle = "Authorization";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Landing page title verification PASSED!");
        } else {
            System.err.println("Landing page title verification FAILED!");
            System.out.println("Expected title = " + expectedTitle);
            System.out.println("Actual title = " + actualTitle);
        }

        // TC #2. Enter positive user name and negative user name.
        // TC #3. Enter positive user password and negative user password.

        /*
        Usernames:
    helpdesk59@cybertekschool.com
    helpdesk60@cybertekschool.com
    marketing59@cybertekschool.com
    marketing60@cybertekschool.com
    hr59@cybertekschool.com
    hr60@cybertekschool.com
    Password:
    UserUser
         */
        ArrayList<String> usernamesPositive = new ArrayList<String>(Arrays.asList("helpdesk59@cybertekschool.com",
                "helpdesk60@cybertekschool.com",
                "marketing59@cybertekschool.com",
                "marketing60@cybertekschool.com",
                "hr59@cybertekschool.com",
                "hr60@cybertekschool.com"));

        String password = "UserUser";


        for (String each : usernamesPositive) {
            // type User name
            driver.findElement(By.name("USER_LOGIN")).sendKeys(each);
            // type Password
            driver.findElement(By.name("USER_PASSWORD")).sendKeys(password);

            //====================================================================================

            // TC #4 Click login button
            driver.findElement(By.className("login-btn")).click();


            WebElement like = driver.findElement(By.xpath("//a[.='Like']"));

            if (like.isDisplayed()) {
                System.out.println("Users can see like button");
            } else {
                System.out.println("Users can not see like button");
            }

            Thread.sleep(3000);

            WebElement follow = driver.findElement(By.xpath("//a[.='Follow']"));
            System.out.println(follow.getText());
            follow.click();
            Thread.sleep(3000);

            if (follow.isDisplayed()) {
                System.out.println("Users can see " + follow.getText() + "button");
            } else {
                System.out.println("Users can not see " + follow.getText() + "button");
            }
            WebElement eyeButton = driver.findElement(By.xpath("//span[@class='feed-content-view-cnt-wrap']"));


            eyeButton.click();
            Thread.sleep(3000);

            if (eyeButton.isDisplayed()) {
                System.out.println("Users can see the list of people");
            } else {
                System.out.println("Users can not see the list of people");
            }

            Thread.sleep(2000);
            driver.findElement(By.id("user-name")).click();//getting to the logout link
            Thread.sleep(2000);
            driver.findElement(By.linkText("Log out")).click();//the actual log out link
            driver.findElement(By.name("USER_LOGIN")).clear(); //username
        }
        driver.close();
    }
}
// test


