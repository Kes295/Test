package com.kes_akarui.webdriver;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;

/**
 * Created by oskrynnik on 4/20/2015.
 */
public class MyFirstTest extends ConfigurationManager{
    LoginPage loginPage;

    public void testUntitled2() throws Exception {
        Data data = new Data();
        LoginPage loginPage = new LoginPage();

        loginPage.fillInLogiField(data.getLogin()).fillInPasswordField(data.getPassword()).clickAuth();
        assertEquals(loginPage.getPageTitle(), data.getPageTile());
    }
}


