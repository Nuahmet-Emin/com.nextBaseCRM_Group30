package com.cybertek.nextbaseCRM.Cem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PostHomePage {
    public static void main(String[] args) {

        System.out.println("Still Processing...");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://login2.nextbasecrm.com");
        driver.manage().window().maximize();

    }
}
