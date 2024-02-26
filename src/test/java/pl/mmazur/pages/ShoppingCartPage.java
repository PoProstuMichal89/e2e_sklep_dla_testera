package pl.mmazur.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.mmazur.pages.sections.shopingCartPage.SummarySection;
import pl.mmazur.utils.PageUtils;

@Getter
public class ShoppingCartPage {

    private SummarySection summarySection;

    public ShoppingCartPage(Page page) {
        PageUtils.waitForPageToLoad(page);
        this.summarySection = new SummarySection(page);
    }


}
