package com.solvd.mobile.gui.pages.common.components;

import com.solvd.mobile.gui.pages.common.CatalogPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class MenuBase extends AbstractUIObject {
    public MenuBase(WebDriver driver) {
        super(driver);
    }

    public MenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract CatalogPageBase goToCatalog();

    // TODO change return type
    public abstract void goToCart();

    // TODO change return type
    public abstract void goToWebView();

    // TODO change return type
    public abstract void goToQRCodeScanner();

    // TODO change return type
    public abstract void goToGeoLocation();

    // TODO change return type
    public abstract void goToDrawing();

    // TODO change return type
    public abstract void goToLogIn();
}
