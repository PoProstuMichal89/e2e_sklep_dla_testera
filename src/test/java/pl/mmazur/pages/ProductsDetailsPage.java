package pl.mmazur.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.mmazur.pages.modals.AddToCartConfirmationModalPage;
import pl.mmazur.pages.sections.productDetailPage.AddToCartSection;
import pl.mmazur.pages.sections.productDetailPage.ProductCustomizationSection;
import pl.mmazur.utils.PageUtils;

import static pl.mmazur.utils.PageUtils.*;

@Getter
public class ProductsDetailsPage extends BasePage {

    private ProductCustomizationSection prodcutCustomizationSection;
    private AddToCartSection addToCartSection;

    public ProductsDetailsPage(Page page) {
        super(page);
        waitForPageToLoad(page);
        this.prodcutCustomizationSection = new ProductCustomizationSection(page);
        this.addToCartSection = new AddToCartSection(page);
    }

    public ProductsDetailsPage customizeProduct(String customMessage) {
        prodcutCustomizationSection.customizerProduct(customMessage);
        return this;
    }

    public AddToCartConfirmationModalPage addToCart() {
        return addToCartSection.addProductToCart();
    }


}
