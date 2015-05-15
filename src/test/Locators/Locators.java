package com.kes_akarui.webdriver;
import  org.openqa.selenium.By;
/**
 * Created by Mandrake on 26.04.2015.
 */
public interface Locators {
    By LOGIN = By.id("mailbox__login");
    By PASSWORD = By.id("mailbox__password");
    By AUTH_BUTTON = By.id("mailbox__auth__button");
    By LETTER_LINK = By.cssSelector(".js-href.b-datalist__item__link");
    By AVATAR = By.cssSelector(".b-letter__head__avatar.js-contact-informer");
}
