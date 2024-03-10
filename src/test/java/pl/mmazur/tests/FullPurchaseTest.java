package pl.mmazur.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.mmazur.pages.*;
import pl.mmazur.pages.modals.AddToCartConfirmationModalPage;
import pl.mmazur.pages.sections.orderDetalisPage.OrderAddressSection;
import pl.mmazur.pages.sections.orderDetalisPage.OrderPaymentSection;
import pl.mmazur.pages.sections.orderDetalisPage.OrderShippingSection;

import static org.assertj.core.api.Assertions.*;

public class FullPurchaseTest extends BaseTest {
    private HomePage homePage;

    private final String PRODUCT_NAME = "Customizable Mug";

    @BeforeEach
    void beofreEach() {
        homePage = new HomePage(page);
    }

    @Test
    void should_purchase_selected_product_v1_test() {
        SearchResultPage searchResultPage = homePage.getTopMenuAndSearchSection().searchForProducts(PRODUCT_NAME);
        ProductsDetailsPage productsDetailsPage = searchResultPage.getSearchResultSection().viewProductDetails(PRODUCT_NAME);
        productsDetailsPage.getProdcutCustomizationSection().customizerProduct(PRODUCT_NAME);
        AddToCartConfirmationModalPage confirmationModal = productsDetailsPage.getAddToCartSection().addProductToCart();
        assertThat(confirmationModal.getConfirmationLMessage()).contains("Product successfully added to your shopping cart");
        ShoppingCartPage shoppingCartPage = confirmationModal.proceedToCheckoutOnModal();
        OrderDetalisPage orderDetalisPage = shoppingCartPage.getSummarySection().proceedToCheckout();

        OrderAddressSection orderAddressSection = orderDetalisPage.getPersonalInformation().enterPersonalInformation();
        OrderShippingSection shippingSection = orderAddressSection.enterAddress();
        OrderPaymentSection paymentSection = shippingSection.selectDeliveryMethod();
        OrderConfirmationPage confirmationPage = paymentSection.placeOrder();
        assertThat(confirmationPage.getOrderConfirmationDetalisSection()
                .getConfirmationTitle()).containsIgnoringCase("Your order is confirmed");

        page.waitForTimeout(2000);


    }

    @Test
    void should_purchase_selected_product_v2_test() {
        AddToCartConfirmationModalPage confirmationModal =
                homePage
                        .searchForProduct(PRODUCT_NAME)
                        .viewProductDetails(PRODUCT_NAME)
                        .customizeProduct(PRODUCT_NAME)
                        .addToCart();
        assertThat(confirmationModal.getConfirmationLMessage()).contains("Product successfully added to your shopping cart");

        OrderConfirmationPage confirmationPage =
                confirmationModal
                        .proceedToCheckoutOnModal()
                        .proceedToCheckoutOnShoppingCartPage()
                        .enterOrderDetails();

        Assertions.assertThat(confirmationPage.getOrderConfirmationDetalisSection()
                .getConfirmationTitle()).containsIgnoringCase("Your order is confirmed");
        
    }

}
