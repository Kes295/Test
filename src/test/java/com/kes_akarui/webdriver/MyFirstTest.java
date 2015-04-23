package com.kes_akarui.webdriver;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import static org.testng.AssertJUnit.assertTrue;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by oskrynnik on 4/20/2015.
 */
public class MyFirstTest {

    By login = By.id("mailbox__login");
    By domain = By.id("mailbox_login_domain");
    By password = By.id("mailbox__password");
    By authButton = By.id("mailbox__auth__button");
    By remind = By.linkText("????????? ??????");
    By domain2 = By.cssSelector("option[value=\"mail.ua\"]");
    By notExists = By.cssSelector("div.form__row__header__message.js-error");
    By formLogin = By.id("loginFormEmail");
    By loginExternal = By.xpath("//form[@id='LoginExternal']/div/div[3]");
    By submit = By.xpath("(//button[@type='submit'])[2]");
    String text = "???????? ??? ???????????? ??? ??????. ????????? ???????????? ????????? ??????.";
    String text2 = "????????? ??????";
    String text3 = "????????? ???? ?? ??????????";


        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @Before
        public void setUp() throws Exception {
            driver = new FirefoxDriver();
            baseUrl = "https://mail.ru/";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            Actions actions = new Actions(driver);
        }

        @Test
        public void MyFirstTest() throws Exception {
            driver.get(baseUrl + "/");
            try {
                assertTrue(isElementPresent(login));
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }

            driver.findElement(login).clear();
            driver.findElement(login).sendKeys("kes_akarui");

            try {
                assertTrue(isElementPresent(domain));
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }

            new Select(driver.findElement(domain)).selectByVisibleText("@mail.ua");

            driver.findElement(domain2).click();

            try {
                assertTrue(isElementPresent(password));
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }

            driver.findElement(password).clear();
            driver.findElement(password).sendKeys("cvbmn");

            try {
                assertTrue(isElementPresent(authButton));
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }

            driver.findElement(authButton).click();

            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try {
                    if (text.equals(driver.findElement(loginExternal).getText()))
                        break; } catch (Exception e) {}
                Thread.sleep(1000);
            }


            try {
                assertEquals(text2, driver.findElement(remind).getText());
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }

            driver.findElement(remind).click();

            try {
                assertTrue(isElementPresent(formLogin));
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            driver.findElement(formLogin).clear();
            driver.findElement(formLogin).sendKeys("kes_akarui");
            try {
                assertTrue(isElementPresent(domain));
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            new Select(driver.findElement(domain)).selectByVisibleText("@mail.ua");
            try {
                assertTrue(isElementPresent(submit));
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            driver.findElement(submit).click();
            assertEquals(text3, driver.findElement(notExists).getText());
        }

        @After
        public void tearDown() throws Exception {
            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }

        private boolean isElementPresent(By by) {
            try {
                driver.findElement(by);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }

        private boolean isAlertPresent() {
            try {
                driver.switchTo().alert();
                return true;
            } catch (NoAlertPresentException e) {
                return false;
            }
        }

        private String closeAlertAndGetItsText() {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                if (acceptNextAlert) {
                    alert.accept();
                } else {
                    alert.dismiss();
                }
                return alertText;
            } finally {
                acceptNextAlert = true;
            }
        }

 }


