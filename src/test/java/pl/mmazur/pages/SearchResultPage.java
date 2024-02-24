package pl.mmazur.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.mmazur.pages.sections.searchResultPage.SearchResultSection;

import static pl.mmazur.utils.PageUtils.waitForPageToLoad;

public class SearchResultPage {

    @Getter
    private SearchResultSection searchResultSection;

    public SearchResultPage(Page page) {
        waitForPageToLoad(page);
        this.searchResultSection = new SearchResultSection(page);
    }
}
