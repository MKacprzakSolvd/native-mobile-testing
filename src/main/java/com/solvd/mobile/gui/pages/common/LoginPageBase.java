package com.solvd.mobile.gui.pages.common;

import com.solvd.model.User;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {
    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CatalogPageBase logInWithValidCredentials(User user);

    public abstract LoginPageBase logInWithInvalidCredentials(User user);
}
