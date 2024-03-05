package pl.mmazur.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.mmazur.pages.*;
import pl.mmazur.pages.modals.AddToCartConfirmationModalPage;
import pl.mmazur.pages.sections.orderDetalisPage.OrderAddressSection;
import pl.mmazur.utils.Properties;

public class FullPurchaseTest extends BaseTest {
    private HomePage homePage;

    @BeforeEach
    void beofreEach() {
        homePage = new HomePage(page);
    }

    @Test
    void should_purchase_selected_product_test() {
        SearchResultPage searchResultPage = homePage.getTopMenuAndSearchSection().searchForProducts("Customizable Mug");
        ProductsDetailsPage productsDetailsPage = searchResultPage.getSearchResultSection().viewProductDetails("Customizable Mug");
        productsDetailsPage.getProdcutCustomizationSection().customizerProduct("Customizable Mug");
        AddToCartConfirmationModalPage confirmationModal = productsDetailsPage.getAddToCartSection().addProductToCart();
        Assertions.assertThat(confirmationModal.getConfirmationLMessage()).contains("Product successfully added to your shopping cart");
        ShoppingCartPage shoppingCartPage = confirmationModal.clickProceedToCheckoutButton();
        OrderDetalisPage orderDetalisPage = shoppingCartPage.getSummarySection().proceedToCheckout();

        OrderAddressSection orderAddressSection = orderDetalisPage.getPersonalInformation().enterPersonalInformation();
        orderAddressSection.enterAddress();

        page.waitForTimeout(2000);


    }

}
