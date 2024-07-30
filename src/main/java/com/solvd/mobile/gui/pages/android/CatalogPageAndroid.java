package com.solvd.mobile.gui.pages.android;

import com.solvd.enums.CatalogSortOrder;
import com.solvd.mobile.gui.pages.android.components.ProductCardAndroid;
import com.solvd.mobile.gui.pages.common.CatalogPageBase;
import com.solvd.mobile.gui.pages.common.components.MenuBase;
import com.solvd.model.Product;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CatalogPageBase.class)
public class CatalogPageAndroid extends CatalogPageBase implements IAndroidUtils {
    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='test-PRODUCTS']//android.view.ViewGroup[@content-desc='test-Item']")
    private List<ProductCardAndroid> productCards;

    @FindBy(xpath = "//android.view.ViewGroup[./android.widget.TextView/following-sibling::android.widget.ImageView]")
    private ExtendedWebElement footer;


    public CatalogPageAndroid(WebDriver driver) {
        super(driver);
        allowInvisibleElements(true);
    }


    @Override
    public MenuBase getMenu() {
        return null;
    }

    // FIXME: works only when app is scrolled to top
    @Override
    public List<Product> getProducts() {
        return Collections.unmodifiableList(collectProductsDownwards());
    }

    @Override
    public List<Product> getProductAvailableQuickly() {
        return getVisibleProducts();
    }

    protected List<Product> getVisibleProducts() {
        return productCards.stream()
                .map(ProductCardAndroid::getProductData)
                .toList();
    }

    protected List<Product> collectProductsDownwards() {
        ArrayList<Product> collectedProducts = new ArrayList<>(getVisibleProducts());
        List<Product> newProducts = Collections.emptyList();
        while (!footer.isVisible(1)) {
            swipeUp(2000);
            collectedProducts.addAll(newProducts);
            newProducts = getVisibleProducts().stream()
                    // FIXME: improve this algorithm
                    .filter(p -> !collectedProducts.contains(p))
                    .toList();
        }
        return collectedProducts;
    }

    @Override
    public boolean sortProducts(CatalogSortOrder sortOrder) {
        return false;
    }

    @Override
    public boolean areProductsSorted(CatalogSortOrder bySortOrder) {
        return false;
    }

    @Override
    public boolean isPageOpened(long timeoutSeconds) {
        // FIXME: find better candidate for checking if page was opened
        return !productCards.isEmpty();
    }
}
