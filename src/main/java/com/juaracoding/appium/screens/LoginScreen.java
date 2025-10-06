package com.juaracoding.appium.screens;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class LoginScreen {
    private AndroidDriver driver;
    private By username = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]");
    private By password = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]");
    private By button = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]");
    private By errorMessage = AppiumBy
            .xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView");

    public LoginScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public String fillUsername(String username) {
        WebElement element = driver.findElement(this.username);
        element.sendKeys(username);
        return element.getText();
    }

    public String fillPassword(String password) {
        WebElement element = driver.findElement(this.password);
        element.sendKeys(password);
        return element.getText();
    }

    public boolean usernameIsVisible() {
        WebElement element = driver.findElement(this.username);
        return element.isDisplayed();
    }

    public boolean passwordIsVisible() {
        WebElement element = driver.findElement(this.password);
        return element.isDisplayed();
    }

    public void click() {
        driver.findElement(button).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public Map<String, String> login(String username, String password) {
        String valueUsername = fillUsername(username);
        String valuePassword = fillPassword(password);
        Map<String, String> credentials = new HashMap<>();
        credentials.put("username", valueUsername);
        credentials.put("password", valuePassword);
        System.out.println(credentials);
        click();

        return credentials;
    }

    public void login() {
        login("standard_user", "secret_sauce");
    }
}
