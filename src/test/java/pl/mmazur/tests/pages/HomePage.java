package pl.mmazur.tests.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.mmazur.tests.pages.sections.TopMenuAndSearchSection;
import pl.mmazur.tests.pages.sections.TopNavigationSection;

public class HomePage {

    @Getter
    private TopMenuAndSearchSection topMenuAndSearchSection;

    @Getter
    private TopNavigationSection topNavigationSection;


    public HomePage(Page page) {
        this.topMenuAndSearchSection = new TopMenuAndSearchSection(page);
        this.topNavigationSection = new TopNavigationSection(page);
    }
}
