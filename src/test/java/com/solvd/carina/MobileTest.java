package com.solvd.carina;

import com.solvd.mobile.gui.pages.common.CatalogPageBase;
import com.solvd.mobile.gui.pages.common.LoginPageBase;
import com.solvd.mobile.gui.pages.common.ProductDetailsPageBase;
import com.solvd.mobile.gui.pages.common.components.ProductCardBase;
import com.solvd.model.Product;
import com.solvd.model.User;
import com.solvd.utils.RandomPicker;
import com.zebrunner.carina.core.AbstractTest;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class MobileTest extends AbstractTest {
    /**
     * Steps:
     * 1. Login with valid credentials
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

    /**
     * Steps:
     * 1. Login with valid credentials
     * Result: Products list should appear
     * 2. Click on random products
     * Result: Page with details of selected product opens
     * 3. Select random color and click add to cart
     * Result: On cart icon, badge with number one appears
     * 4. Navigate to cart
     * Result: Cart opens, with selected product in it (with the name, price and color same as selected)
     * 5. Click proceed to checkout
     * Result: Login page appears
     * 6. Input valid username and password
     * Result: Checkout page appears (with shipping address form)
     * 7. Input valid shipping data and proceed to payment
     * Result: Checkout page with payment method selection appears
     * 8. Input valid payment details and proceed
     * Result: Order review page appears
     * 9. Validate that order info matched provided data and place order
     * Result: Checkout complete page appears
     * 10. Click continue shopping
     * Result: Catalog page opens
     */
    @Test(testName = "TC-02")
    public void verifyCheckoutProcessTest() {
        log.info("Starting step 1");
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        loginPageBase.assertPageOpened();

        // TODO: extract to some test files or provider
        User user = new User("standard_user", "secret_sauce");

        CatalogPageBase catalogPage = loginPageBase.logInWithValidCredentials(user);
        catalogPage.assertPageOpened();

        log.info("Starting step 2");
        Product selectedProduct = RandomPicker.getRandomElement(catalogPage.getProductAvailableQuickly());
        ProductDetailsPageBase productDetailsPage = catalogPage
                .actOnProductCardWithResult(
                        selectedProduct,
                        ProductCardBase::goToProductDetailsPage
                );

        log.info("Starting step 3");
    }


}
