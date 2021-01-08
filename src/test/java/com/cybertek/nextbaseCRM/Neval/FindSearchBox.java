package com.cybertek.nextbaseCRM.Neval;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindSearchBox {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();

        driver.get("https://login2.nextbasecrm.com/");

        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk5@cybertekschool.com");

        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser");

        driver.findElement(By.className("login-btn")).click();

        //QUESTION: to test different usernames and passwords, do I write a loop, separate codes,
        // or test individually in the existing code?
        //If loop, is there a way to test these credentials without opening the browser 6 times?

        WebElement searchBox= driver.findElement(By.id("search-textbox-input"));



        if (searchBox.isDisplayed()){
            System.out.println("Search box displayed. PASS!!");
        }else{
            System.out.println("Search box is NOT displayed. FAIL!!");
        }
        searchBox.sendKeys("abc");

        searchBox= driver.findElement(By.cssSelector("div[class='header-search']"));


    }
}