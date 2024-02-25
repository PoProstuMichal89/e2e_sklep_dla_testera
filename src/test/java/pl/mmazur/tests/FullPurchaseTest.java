package pl.mmazur.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.mmazur.pages.HomePage;
import pl.mmazur.pages.ProductsDetailsPage;
import pl.mmazur.pages.SearchResultPage;
import pl.mmazur.utils.Properties;

public class FullPurchaseTest extends BaseTest{
    private HomePage homePage;

    @BeforeEach
    void beofreEach() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
        homePage.getTopNavigationSection().setPageLanguageToEnglish();
    }

    @Test
    void should_purchase_selected_product_test() {
        SearchResultPage searchResultPage = homePage.getTopMenuAndSearchSection().searchForProducts("Customizable Mug");
        ProductsDetailsPage productsDetailsPage = searchResultPage.getSearchResultSection().viewProductDetails("Customizable Mug");
        productsDetailsPage.getProdcutCustomizationSection().customizerProduct("Customizable Mug");
        productsDetailsPage.getAddToCartSection().addProductToCart();

        page.waitForTimeout(5000);


    }

}
