package com.solvd.mobile.gui.pages.android.components;

import com.solvd.mobile.gui.pages.common.ProductDetailsPageBase;
import com.solvd.mobile.gui.pages.common.components.ProductCardBase;
import com.solvd.model.Product;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;

public class ProductCardAndroid extends ProductCardBase {
    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title']")
    private ExtendedWebElement nameLabel;
    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Price']")
    private ExtendedWebElement priceLabel;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-ADD TO CART']")
    private ExtendedWebElement addToCartButton;


    public ProductCardAndroid(WebDriver driver) {
        super(driver);
    }

    public ProductCardAndroid(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public ProductDetailsPageBase goToProductDetailsPage() {
        return null;
    }

    @Override
    public void review(short rating) {

    }

    @Override
    public Product getProductData() {
        return Product.builder()
                .name(nameLabel.getText())
                .price(new BigDecimal(priceLabel.getText().substring(1)))
                .build();
    }
}
