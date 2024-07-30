package com.solvd.mobile.gui.pages.android;

import com.solvd.mobile.gui.pages.common.CatalogPageBase;
import com.solvd.mobile.gui.pages.common.LoginPageBase;
import com.solvd.model.User;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPageAndroid extends LoginPageBase {
    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Username']")
    public ExtendedWebElement usernameField;
    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
    public ExtendedWebElement passwordField;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGIN']")
    public ExtendedWebElement loginButton;


    public LoginPageAndroid(WebDriver driver) {
        super(driver);
    }

    @Override
    public CatalogPageBase logInWithValidCredentials(User user) {
        usernameField.type(user.getUsername());
        passwordField.type(user.getPassword());
        loginButton.click();
        return null;
    }

    @Override
    public LoginPageBase logInWithInvalidCredentials(User user) {
        return null;
    }
}
