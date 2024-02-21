package pl.mmazur.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pl.mmazur.tests.pages.HomePage;
import pl.mmazur.tests.pages.SearchResultPage;
import pl.mmazur.utils.PageUtils;
import pl.mmazur.utils.Properties;

import java.util.stream.Stream;

public class SearchTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
    }

    @Test
    void should_return_products_by_search_name_mug() {
        SearchResultPage searchResultPage = homePage.getTopMenuAndSearchSection().searchForProducts("mug");
        Assertions.assertThat(searchResultPage.getSearchResultSection().getProducts().size()).isEqualTo(5);
    }

    @Test
    void should_return_products_by_search_name_frame() {
        SearchResultPage searchResultPage = homePage.getTopMenuAndSearchSection().searchForProducts("frame");
        Assertions.assertThat(searchResultPage.getSearchResultSection().getProducts().size()).isEqualTo(4);
    }

    @Test
    void should_return_products_by_search_name_tshirt() {
        SearchResultPage searchResultPage = homePage.getTopMenuAndSearchSection().searchForProducts("t-shirt");
        Assertions.assertThat(searchResultPage.getSearchResultSection().getProducts().size()).isEqualTo(1);
    }
//paramtery podane jako value source
    @ParameterizedTest
    @ValueSource(strings = {"mug", "frame", "t-shirt"})
    void should_return_products_by_product_name(String productName) {
        SearchResultPage searchResultPage = homePage.getTopMenuAndSearchSection().searchForProducts(productName);
        Assertions.assertThat(searchResultPage.getSearchResultSection().getProducts().size()).isGreaterThan(0);
    }

//parametry podane z metody
    @DisplayName("Search for products")
    @ParameterizedTest(name="Search for {0} should return {1} products")
    @MethodSource("searchData")
    void should_return_products_by_product_name(String productName, int prodcutCounter) {
        SearchResultPage searchResultPage = homePage.getTopMenuAndSearchSection().searchForProducts(productName);
        Assertions.assertThat(searchResultPage.getSearchResultSection().getProducts().size()).isEqualTo(prodcutCounter);
    }

    private static Stream<Arguments> searchData(){
        return Stream.of(
                Arguments.of("mug", 5),
                Arguments.of("frame", 4),
                Arguments.of("t-shirt", 1)
        );
    }

}

