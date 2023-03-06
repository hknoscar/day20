package com.test;

import com.pages.CatatanKeuangan;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestCatatanKeuangan {
    private static AndroidDriver<MobileElement> driver;

    public CatatanKeuangan catKe;

    @BeforeClass
    public void logUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Infinix X6812B");
        capabilities.setCapability("uuid", "emulator-555");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("appPackage", "com.chad.financialrecord");
        capabilities.setCapability("appActivity", "com.chad.financialrecord.Day20");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @BeforeMethod
    public void pageObject() {
        catKe = new CatatanKeuangan(driver);
    }

    @Test(priority = 1)
    public void addPemasukan() {
        catKe.savePemasukan();
        System.out.println("Jumlah Pemasukan anda : " + catKe.textResultPemasukan());
        Assert.assertEquals(catKe.textResultPemasukan(), "100.000");
        System.out.println();
    }

    @Test(priority = 2)
    public void addPengeluaran() {
        catKe.savePengeluaran();
        System.out.println("Jumlah Pengeluaran anda : " + catKe.textResultPengeluaran());
        Assert.assertEquals(catKe.textResultPengeluaran(), "2.000");
    }

    @Test(priority = 3)
    public void addSaldo() {
        catKe.textResultSaldo();
        System.out.println("Jumlah Saldo anda : " + catKe.textResultSaldo());
        Assert.assertEquals(catKe.textResultSaldo(), "98.000");
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}
