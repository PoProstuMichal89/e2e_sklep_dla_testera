package pl.mmazur.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.mmazur.tests.pages.HomePage;
import pl.mmazur.tests.pages.SearchResultPage;

public class SearchTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate("https://skleptestera.pl/index.php");
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

}

