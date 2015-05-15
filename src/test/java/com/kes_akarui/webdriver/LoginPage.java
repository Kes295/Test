package com.kes_akarui.webdriver;

import sun.rmi.runtime.Log;

/**
 * Created by Mandrake on 27.04.2015.
 */
public class LoginPage {
    public TextInput loginField = new TextInput(Locators.LOGIN);
    public TextInput passwordField = new TextInput(Locators.PASSWORD);
    public Button authButton = new Button(Locators.AUTH_BUTTON);

    public LoginPage fillInLoginField(String login){
        loginField.sendKeys(login);
        return this;
    }

    public LoginPage fillInPasswordField(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public Inbox clickAuth(){
        authButton.click();
        return new Inbox();
    }

    public Inbox fillInLoginForm(String login, String password){
        return fillInLoginField(login).
                fillInPasswordField(password).
                clickAuth();
    }

    public String getPageTitle(){
        return ConfigurationManager.getDriver().getTitle();
    }
}
