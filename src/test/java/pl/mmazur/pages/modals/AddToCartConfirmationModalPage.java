package pl.mmazur.pages.modals;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pl.mmazur.pages.BasePage;
import pl.mmazur.pages.ShoppingCartPage;
import pl.mmazur.utils.PageUtils;

public class AddToCartConfirmationModalPage extends BasePage {

    private Locator confirmationLabel;

    private Locator proceedToCheckoutButton;

    public AddToCartConfirmationModalPage(Page page) {
        super(page);
        PageUtils.waitForPageToLoad(page);
        this.confirmationLabel = page.locator("#myModalLabel");
        this.proceedToCheckoutButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Proceed to checkout"));
    }

    public String getConfirmationLMessage(){
        return confirmationLabel.innerText();
    }

    public ShoppingCartPage proceedToCheckoutOnModal(){
        proceedToCheckoutButton.click();

        return new ShoppingCartPage(page);
    }

}
