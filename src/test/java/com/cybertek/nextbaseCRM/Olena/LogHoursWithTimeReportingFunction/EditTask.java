package com.cybertek.nextbaseCRM.Olena.LogHoursWithTimeReportingFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class EditTask {

    public static void main(String[] args) throws InterruptedException {

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

        //check if daily plan is selected:
        WebElement dailyPlan = driver.findElement(By.cssSelector("span[class='tm-tab tm-tab-selected']"));
        WebElement dailySummary = driver.findElement(By.cssSelector("span[class='tm-tab']"));

        if (dailySummary.isSelected()) {
            dailyPlan.click();
        }

        //click on text box saying: "enter a new task" and type some text:
        String text = "some text";
        driver.findElement(By.cssSelector("input[class='tm-popup-task-form-textbox']")).sendKeys(text + Keys.ENTER);

        //click on "select from list":
        driver.findElement(By.cssSelector("span[class='tm-popup-section-right-link']")).click();

        //check if the newly created task can be seen at "select from list":
        if (driver.findElement(By.cssSelector("div[class='finder-box-item-text']")).getText().contains(text)) {
            System.out.println("New task has been added to the daily plan");
        } else {
            System.out.println("Task has not been added to the daily plan ");
        }

        //close pop-up window:
        driver.findElement(By.cssSelector("span[class='popup-window-button popup-window-button-link popup-window-button-link-cancel']")).click();

        //take one of the created tasks and check if it can be edited:
        driver.findElement(By.className("tm-task-name")).click();
        Thread.sleep(3000);

        //click "Edit" button:
        WebElement editButton = driver.findElement(By.xpath("//a[@data-slider-ignore-autobinding='true']"));
        editButton.click();
    }
}
