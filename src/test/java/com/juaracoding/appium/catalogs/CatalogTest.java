package com.juaracoding.appium.catalogs;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.juaracoding.appium.screens.InventoryScreen;
import com.juaracoding.appium.screens.LoginScreen;
import com.juaracoding.appium.services.DriverService;

import io.appium.java_client.android.AndroidDriver;

public class CatalogTest {

    @Test
    public void addProductToCartTest() throws MalformedURLException {
        AndroidDriver driver = DriverService.buildDriver();

        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.login();

        InventoryScreen inventoryScreen = new InventoryScreen(driver);
        Assert.assertEquals(inventoryScreen.getProductNameBy(0), "Sauce Labs Backpack");

        inventoryScreen.addToCartBy(0);
        Assert.assertEquals(inventoryScreen.getButtonCartLabelBy(0), "REMOVE");
        Assert.assertEquals(inventoryScreen.getTotalCart(), "1");
        
        driver.quit();
    }

}
