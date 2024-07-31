package com.solvd.mobile.gui.pages.common;

import com.solvd.model.User;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public abstract class LoginPageBase extends AbstractPage {
    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CatalogPageBase logInWithValidCredentials(User user);

    public abstract LoginPageBase logInWithInvalidCredentials(User user);

    /**
     * @param timeoutSeconds in seconds
     */
    @Override
    public abstract boolean isPageOpened(long timeoutSeconds);

    /**
     * @param timeoutSeconds in seconds
     */
    @Override
    public void assertPageOpened(long timeoutSeconds) {
        assertTrue(isPageOpened(timeoutSeconds), "Page didn't open in specified time");
    }
}
