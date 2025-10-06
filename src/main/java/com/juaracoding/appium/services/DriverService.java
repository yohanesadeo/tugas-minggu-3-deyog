package com.juaracoding.appium.services;

import java.net.URL;
import java.time.Duration;
import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverService {
    private AndroidDriver driver;
    private UiAutomator2Options options;

    // public DriverService() throws MalformedURLException {
    // driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    // }

    public void setDriver() throws MalformedURLException {
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    public void setOptions() {
        options = new UiAutomator2Options();
        options.setCapability("appium:deviceName", "emulator-5554");
        options.setCapability("platformName", "Android");
        options.setCapability("appium:automationName", "UiAutomator2");
        options.setCapability("appium:appPackage", "com.swaglabsmobileapp");
        options.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");
    }

    public AndroidDriver getDriver() {
        return driver;
    }

    public static AndroidDriver buildDriver() throws MalformedURLException {
        DriverService ds = new DriverService();
        ds.setOptions();
        ds.setDriver();
        ds.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ds.getDriver().hideKeyboard();
        return ds.getDriver();
    }

}
