package pl.mmazur.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.mmazur.pages.sections.TopMenuAndSearchSection;
import pl.mmazur.pages.sections.TopNavigationSection;

@Getter
public class HomePage extends BasePage {

    private TopMenuAndSearchSection topMenuAndSearchSection;
    private TopNavigationSection topNavigationSection;



    public HomePage(Page page) {
        super(page);
        this.topMenuAndSearchSection = new TopMenuAndSearchSection(page);
        this.topNavigationSection = new TopNavigationSection(page);
        topNavigationSection.setPageLanguageToEnglish();
    }
}
