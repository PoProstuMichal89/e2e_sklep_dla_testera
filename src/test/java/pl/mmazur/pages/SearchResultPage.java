package pl.mmazur.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.mmazur.pages.sections.searchResultPage.SearchResultSection;

import static pl.mmazur.utils.PageUtils.waitForPageToLoad;

public class SearchResultPage extends BasePage {

    @Getter
    private SearchResultSection searchResultSection;

    public SearchResultPage(Page page) {
        super(page);
        waitForPageToLoad(page);
        this.searchResultSection = new SearchResultSection(page);
    }

    public ProductsDetailsPage viewProductDetails(String productName) {
        return getSearchResultSection().viewProductDetails(productName);
    }
}
