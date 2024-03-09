package pl.mmazur.pages.sections.orderConfirmationPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.impl.LocatorUtils;
import pl.mmazur.pages.BasePage;

public class OrderConfirmationDetalisSection extends BasePage {

    private final String orderConfirmationDetalisSection = "#content-hook_order_confirmation ";
    private Locator title;

    public OrderConfirmationDetalisSection(Page page) {
        super(page);
        this.title = page.locator(orderConfirmationDetalisSection+ ".card-title");
    }

    public String getConfirmationTitle(){
        return title.innerText();
    }
}
