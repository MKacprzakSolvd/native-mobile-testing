package com.solvd.mobile.gui.pages.common;

import com.solvd.enums.CatalogSortOrder;
import com.solvd.mobile.gui.pages.common.components.MenuBase;
import com.solvd.model.Product;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.testng.Assert.assertTrue;

public abstract class CatalogPageBase extends AbstractPage {
    public CatalogPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract MenuBase getMenu();

    /**
     * Returns product cards in the order they appear
     */
    public abstract List<Product> getProducts();

    /**
     * Returns product data that can be accessed quickly, results of this method
     * might vary between platforms.
     */
    public abstract List<Product> getProductAvailableQuickly();

    /**
     * Sorts products in catalog by given sort order.
     * Returns true if sorting is successful (same what areProductsSorted returns)
     */
    public abstract boolean sortProducts(CatalogSortOrder sortOrder);

    public abstract boolean areProductsSorted(CatalogSortOrder bySortOrder);

    // TODO: extract isPageOpened and assert... to some common superclass

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
