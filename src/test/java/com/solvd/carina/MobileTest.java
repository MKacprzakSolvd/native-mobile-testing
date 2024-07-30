package com.solvd.carina;

import com.solvd.mobile.gui.pages.common.CatalogPageBase;
import com.solvd.mobile.gui.pages.common.LoginPageBase;
import com.solvd.model.User;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.Test;

public class MobileTest extends AbstractTest {
    /**
     * Steps:
     * 1. Start app
     * Result: Login page should appear
     * 2. Login with valid credentials
     * Result: Products list should appear
     */
    @Test(testName = "TC-01")
    public void verifyLoginProcessTest() {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        loginPageBase.assertPageOpened();

        // TODO: extract to some test files or provider
        User user = new User("standard_user", "secret_sauce");

        CatalogPageBase catalogPageBase = loginPageBase.logInWithValidCredentials(user);
        catalogPageBase.assertPageOpened();
    }


}
