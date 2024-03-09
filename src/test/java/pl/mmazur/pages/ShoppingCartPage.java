package pl.mmazur.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.mmazur.pages.sections.shopingCartPage.SummarySection;
import pl.mmazur.utils.PageUtils;

@Getter
public class ShoppingCartPage extends BasePage {

    private SummarySection summarySection;

    public ShoppingCartPage(Page page) {
        super(page);
        PageUtils.waitForPageToLoad(page);
        this.summarySection = new SummarySection(page);
    }

    public OrderDetalisPage proceedToCheckoutOnShoppingCartPage() {
        return summarySection.proceedToCheckout();
    }


}
