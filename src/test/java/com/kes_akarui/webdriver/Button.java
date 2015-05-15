package com.kes_akarui.webdriver;

import org.openqa.selenium.By;

/**
 * Created by Mandrake on 27.04.2015.
 */
public class Button extends Element {

    public Button(By by) {
        this.by = by;
    }

    public void click() {
        element().click();
    }
}
