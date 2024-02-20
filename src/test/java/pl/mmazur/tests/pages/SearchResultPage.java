package pl.mmazur.tests.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.mmazur.tests.pages.sections.searchResultPage.SearchResultSection;

public class SearchResultPage {

    @Getter
    private SearchResultSection searchResultSection;

    public SearchResultPage(Page page) {
        this.searchResultSection = new SearchResultSection(page);
    }
}
