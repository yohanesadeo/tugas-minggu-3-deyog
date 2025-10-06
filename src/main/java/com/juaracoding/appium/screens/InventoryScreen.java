package com.juaracoding.appium.screens;

import java.time.Duration;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class InventoryScreen {
    private AndroidDriver driver;
    private By header = AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]");
    private By products = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"test-Item title\"]");
    private By buttonAddToCarts = AppiumBy
            .xpath("//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]/android.widget.TextView");
    private By buttonRemoveCarts = AppiumBy
            .xpath("//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]/android.widget.TextView");
    private By buttonCart = AppiumBy.xpath(
            "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView");

    public InventoryScreen(AndroidDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    public String getProductNameBy(int index) {
        return driver.findElements(products).get(index).getText();
    }

    public void addToCartBy(int index) {
        driver.findElements(buttonAddToCarts).get(index).click();
    }

    public String getButtonCartLabelBy(int index) {
        return driver.findElements(buttonRemoveCarts).get(index)
                .findElement(AppiumBy.className("android.widget.TextView")).getText();
    }

    public String getButtonRemoveBy(int index) {
        return driver.findElements(buttonRemoveCarts).get(index).getText();
    }

    public String getTotalCart() {
        return driver.findElement(buttonCart).getText();
    }

}
