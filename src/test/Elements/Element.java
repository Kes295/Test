package com.kes_akarui.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Mandrake on 27.04.2015.
 */
public abstract class Element {
    protected By by;

    public WebElement element() {
        return ConfigurationManager.getDriver().findElement(by);
    }
}
