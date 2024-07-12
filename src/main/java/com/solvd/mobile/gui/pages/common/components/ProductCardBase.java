package com.solvd.mobile.gui.pages.common.components;

import com.solvd.model.Product;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ProductCardBase extends AbstractUIObject {

    protected ProductCardBase(WebDriver driver) {
        super(driver);
    }

    protected ProductCardBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    // TODO: change return type
    public abstract void goToProductDetailsPage();

    public abstract void review(short rating);

    public abstract Product getProductData();
}
