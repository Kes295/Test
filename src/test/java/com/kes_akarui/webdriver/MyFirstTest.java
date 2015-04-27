package com.kes_akarui.webdriver;

import org.junit.Test;

import static org.testng.Assert.assertEquals;


public class MyFirstTest extends ConfigurationManager{

    @Test
    public void testUntitled() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(Locators.LOGIN).clear();
        driver.findElement(Locators.LOGIN).sendKeys("kes_akarui295");
        driver.findElement(Locators.PASSWORD).clear();
        driver.findElement(Locators.PASSWORD).sendKeys("Apotheosis295");
        driver.findElement(Locators.AUTH_BUTTON).click();
        assertEquals(driver.getTitle(), "dfgg");
    }

    public void testUntitled2() throws Exception {
        driver.get("/");
        driver.findElement(Locators.LOGIN).clear();
        driver.findElement(Locators.LOGIN).sendKeys("dfgsdfg");
        driver.findElement(Locators.PASSWORD).clear();
        driver.findElement(Locators.PASSWORD).sendKeys("sdfgsdfg");
        driver.findElement(Locators.AUTH_BUTTON).click();
    }
}


