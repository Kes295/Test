package com.kes_akarui.webdriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Mandrake on 15.05.2015.
 */
public class Inbox {
    public boolean isAvatarPresent(){
        WebElement firstLetter = ConfigurationManager.getDriver().findElements(Locators.LETTER_LINK).get(0);
        firstLetter.click();
        WebElement avatar = ConfigurationManager.getDriver().findElement(Locators.AVATAR);
        return avatar.isDisplayed();
    }
}
