package pl.mmazur.pages.sections.productDetailPage;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.mmazur.pages.modals.AddToCartConfirmationModalPage;

public class AddToCartSection {

    private Page page;
    private Locator addToCartButton;

    public AddToCartSection(Page page) {
        this.page=page;
        this.addToCartButton = page.locator(".add-to-cart");
    }

    public AddToCartConfirmationModalPage addProductToCart(){
        addToCartButton.click();

        return new AddToCartConfirmationModalPage(page);
    }
}
