package pl.mmazur.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.mmazur.pages.ArtPage;
import pl.mmazur.pages.HomePage;
import pl.mmazur.utils.Properties;

public class FilterByPriceTest extends BaseTest {
    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
        homePage.getTopNavigationSection().setPageLanguageToEnglish();
    }

    @Test
    void shoud_return_product_with_price_greater_than_40_url() {
        ArtPage artPage = homePage.getTopMenuAndSearchSection().clickArtLink();
        String newUrl = page.url() + "&q=Price-zł-40-44";
        page.navigate(newUrl);
        Assertions.assertThat(artPage.getProductSection().getProdcutsPrices().stream().allMatch(price -> price > 40)).isTrue();

//        System.out.println(artPage.getProductSection().getProdcutsPrices());
    }

    @Test
    void shoud_return_product_with_price_greater_than_40_by_mouse() {
        ArtPage artPage = homePage.getTopMenuAndSearchSection().clickArtLink();
        artPage.getFilterBySection().filterProductsByPriceWithMouse(40.00);
        Assertions.assertThat(artPage.getProductSection().getProdcutsPrices().stream().allMatch(price -> price > 40)).isTrue();

    }

    @Test
    void shoud_return_product_with_price_greater_than_40_by_keyboard() {
        ArtPage artPage = homePage.getTopMenuAndSearchSection().clickArtLink();
        artPage.getFilterBySection().filterProductsByPriceWithKeyboard(40.00);
        Assertions.assertThat(artPage.getProductSection().getProdcutsPrices().stream().allMatch(price -> price > 40)).isTrue();

    }
}
