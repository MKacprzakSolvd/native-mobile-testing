package com.solvd.mobile.gui.pages.common;

import com.solvd.enums.CatalogSortOrder;
import com.solvd.mobile.gui.pages.common.components.MenuBase;
import com.solvd.mobile.gui.pages.common.components.ProductCardBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class CatalogPageBase extends AbstractPage {
    protected CatalogPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract MenuBase getMenu();

    /**
     * Returns product cards in the order they appear
     */
    public abstract List<ProductCardBase> getProductCards();

    /**
     * Sorts products in catalog by given sort order.
     * Returns true if sorting is successful (same what areProductsSorted returns)
     */
    public abstract boolean sortProducts(CatalogSortOrder sortOrder);

    public abstract boolean areProductsSorted(CatalogSortOrder bySortOrder);
}
