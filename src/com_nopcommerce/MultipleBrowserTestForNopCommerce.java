package com_nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Check on multiple browser
 */

public class MultipleBrowserTestForNopCommerce {
    static String browser = "Chrome"; // you can change any as per requirement
    static String baseUrl = "https://demo.nopcommerce.com/";
    static WebDriver driver;

    // Declare main method
    public static void main(String[] args) {
        // Drivers created for chrome setup
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver(); // launch chrome
            // Drivers created for firefox
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
            // Drivers created for Edge
        }else if (browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        }else {
            System.out.println("Wrong Browser name");
        }
        // Open the Url into Browser
        driver.get(baseUrl);
        // Maximise the browser
        driver.manage().window().maximize();
        // Give implicit wait to the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Print the tile of the page
        System.out.println("The title of the page : " + driver.getTitle());
        // Print the current Url
        System.out.println("The current Url : " + driver.getCurrentUrl());
        // Print the page source
        System.out.println("The page source : " + driver.getPageSource() );
        // Navigate to login Url
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        // Print the current Url
        System.out.println("The current Url : " + driver.getCurrentUrl());
        // Navigate back to the login page
        driver.navigate().back();
        // Navigate to the login page
        driver.navigate().forward();
        // Print the current Url
        System.out.println("The current Url :" + driver.getCurrentUrl());
        // Refresh the page
        driver.navigate().refresh();
        // Enter the email to the email field
        driver.findElement(By.id("Email")).sendKeys("prime123@gmail.com");
        // Enter the password to the password field
        driver.findElement(By.id("Password")).sendKeys("Prime123");
        // Click on Login Button
        driver.findElement(By.cssSelector(".login-button")).click();
        // Close the browser
        driver.quit();
    }
}

