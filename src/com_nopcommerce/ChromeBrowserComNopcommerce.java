package com_nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * 1. Setup Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Navigate to Url.“https://demo.nopcommerce.com/login?returnUrl=%2F”
 * 7. Print the current url.
 * 8. Navigate back to the home page.
 * 9. Navigate to the login page.
 * 10. Print the current url.
 * 11. Refresh the page.
 * 12. Enter the email to email field.
 * 13. Enter the password to password field.
 * 14. Click on Login Button
 * Created by Sandip Patel
 */

public class ChromeBrowserComNopcommerce {
    public static void main(String[] args) {
        // Write a String baseUrl and "" because String
        String baseUrl = "https://demo.nopcommerce.com/";
        // 1. Setup Chrome browser
        // WebDriver is interface
        WebDriver driver = new ChromeDriver();

        // 2. Open the URL into browser
        driver.get(baseUrl); // open browser and (baseUrl) as a string

        // Maximise the browser
        driver.manage().window().maximize();

        // We give implicit wait to the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Up to here 4 steps always need


        //3. Print the title of the page
        //need to print title of the page so sout and "The title of the page" + method
        // this is method =public abstract String getTitle(); call direct
        // Others way to write example below
        // String title = driver.getTitle(); //can do this way as well
        // System.out.println(title);

        System.out.println("The title of the page :" + driver.getTitle());

        // 4. Print the current url
        // need to print current url sout and "The current Url" + method
        // this is method =public abstract String getCurrentUrl(); call direct
        System.out.println("The current Url : " + driver.getCurrentUrl());

        // 5 Print the page source/ get page source
        System.out.println("The page source : " + driver.getPageSource());

        // 6 Navigate to Url / Navigate to loginUrl
        // Can do it as step 12 as well but just for understanding do all step
        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        driver.navigate().to(loginUrl); // call above string into method

        // 7 Print the current Url
        System.out.println("The current Url : " + driver.getCurrentUrl());

        // 8 Navigate back to home page
        driver.navigate().back();

        // 9 Navigate to login page
        driver.navigate().forward();
        //driver.navigate().to(loginUrl); // can also do like this

        // 10 Print the current Url
        System.out.println("The current Url : " + driver.getCurrentUrl());

        // 11 Refresh the page
        driver.navigate().refresh();


        // 1 need to find login link already done in number 9 Navigate to login page but this is better
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        // 12 Enter the email to email field
        WebElement emailField = driver.findElement(By.id("Email")); // can also by using name as well
        emailField.sendKeys("prime123@gmail.com");

        // 13 Enter the password to password field
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Prime123");
        // can also do this way
        //driver.findElement(By.id("Password")).sendKeys("Prime123");


        // 14 Click on Login Button
        // / by using cssSelector tag.class so tag is optional .class
        WebElement loginButton = driver.findElement(By.cssSelector(".login-button"));
        loginButton.click();


        // 15 close the browser
        // always need to close browser sam like closing scanner after
        driver.quit();

    }
}
