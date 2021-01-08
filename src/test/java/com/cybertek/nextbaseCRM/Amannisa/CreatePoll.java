package com.cybertek.nextbaseCRM.Amannisa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatePoll {
    public static void main(String[] args) {

        //set up WebDriverManager
        WebDriverManager.chromedriver().setup();
        //open browser
        WebDriver driver = new ChromeDriver();
        //open web Browser
        //Thread.sleep(3000);
        driver.get("https://login2.nextbasecrm.com");
        driver.manage().window().maximize();




    }
}
