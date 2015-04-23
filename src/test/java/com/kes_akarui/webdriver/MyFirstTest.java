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
    By remind = By.linkText("Напомнить пароль");
    By login2 = By.name("Login");
    By name2 = By.name("Domain");
    By notExists = By.cssSelector("div.form__row__header__message.js-error");


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
                assertTrue(isElementPresent(By.id("mailbox__login")));
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

            new Select(driver.findElement(By.id("mailbox__login__domain"))).selectByVisibleText("@mail.ua");

            driver.findElement(By.cssSelector("option[value=\"mail.ua\"]")).click();

            try {
                assertTrue(isElementPresent(By.id("mailbox__password")));
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }

            driver.findElement(By.id("mailbox__password")).clear();
            driver.findElement(By.id("mailbox__password")).sendKeys("cvbmn");

            try {
                assertTrue(isElementPresent(By.id("mailbox__auth__button")));
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }

            driver.findElement(By.id("mailbox__auth__button")).click();

            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try { if ("Неверное имя пользователя или пароль. Проверьте правильность введенных данных.".equals(driver.findElement(By.xpath("//form[@id='LoginExternal']/div/div[3]")).getText())) break; } catch (Exception e) {}
                Thread.sleep(1000);
            }


            try {
                assertEquals("Напомнить пароль", driver.findElement(By.linkText("Напомнить пароль")).getText());
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }

            driver.findElement(By.linkText("Напомнить пароль")).click();

            try {
                assertTrue(isElementPresent(By.id("loginFormEmail")));
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            driver.findElement(By.id("loginFormEmail")).clear();
            driver.findElement(By.id("loginFormEmail")).sendKeys("kes_akarui");
            try {
                assertTrue(isElementPresent(By.name("Domain")));
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            new Select(driver.findElement(By.name("Domain"))).selectByVisibleText("@mail.ua");
            try {
                assertTrue(isElementPresent(By.xpath("(//button[@type='submit'])[2]")));
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
            assertEquals("Указанный ящик не существует", driver.findElement(By.cssSelector("div.form__row__header__message.js-error")).getText());
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


