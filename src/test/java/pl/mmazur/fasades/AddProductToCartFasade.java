package pl.mmazur.fasades;

import pl.mmazur.pages.HomePage;
import pl.mmazur.pages.modals.AddToCartConfirmationModalPage;

public class AddProductToCartFasade {

    private HomePage homePage;

    public AddProductToCartFasade(HomePage homePage) {
        this.homePage = homePage;
    }

    public AddToCartConfirmationModalPage addProductWithCustomizationToCart(String productName) {
        return homePage
                .searchForProduct(productName)
                .viewProductDetails(productName)
                .customizeProduct(productName)
                .addToCart();
    }
    public AddToCartConfirmationModalPage addProductToCart(String productName) {
        return homePage
                .searchForProduct(productName)
                .viewProductDetails(productName)
                .addToCart();
    }

}
