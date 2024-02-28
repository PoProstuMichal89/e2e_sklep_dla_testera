package pl.mmazur.pages.sections.shopingCartPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pl.mmazur.pages.BasePage;
import pl.mmazur.pages.OrderDetalisPage;

public class SummarySection extends BasePage {

    private Locator proceedToCheckoutButton;

    public SummarySection(Page page) {
        super(page);
        this.proceedToCheckoutButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Proceed to checkout"));
    }

    public OrderDetalisPage proceedToCheckout(){
        proceedToCheckoutButton.click();
        return new OrderDetalisPage(page);
    }
}
