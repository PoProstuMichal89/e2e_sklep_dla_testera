package pl.mmazur.pages.sections.productDetailPage;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.mmazur.pages.BasePage;
import pl.mmazur.pages.modals.AddToCartConfirmationModalPage;

public class AddToCartSection extends BasePage {
    private Locator addToCartButton;

    public AddToCartSection(Page page) {
        super(page);
        this.addToCartButton = page.locator(".add-to-cart");
    }

    public AddToCartConfirmationModalPage addProductToCart(){
        addToCartButton.click();

        return new AddToCartConfirmationModalPage(page);
    }
}
