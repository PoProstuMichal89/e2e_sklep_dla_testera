package pl.mmazur.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.mmazur.pages.sections.TopMenuAndSearchSection;
import pl.mmazur.pages.sections.TopNavigationSection;

public class BasePage {

    protected Page page;

    @Getter
    protected TopMenuAndSearchSection topMenuAndSearchSection;

    @Getter
    protected TopNavigationSection topNavigationSection;


    public BasePage(Page page) {
        this.page = page;
        this.topMenuAndSearchSection = new TopMenuAndSearchSection(page);
        this.topNavigationSection = new TopNavigationSection(page);
    }

    public SearchResultPage searchForProduct(String productName) {
        return topMenuAndSearchSection.searchForProduct(productName);
    }

    public void setPageLanguageToEnglish() {
        topNavigationSection.setPageLanguageToEnglish();
    }

    public ArtPage clickArtLink() {
        return topMenuAndSearchSection.clickArtLink();
    }
}
