package pl.mmazur.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.mmazur.pages.sections.productDetailPage.AddToCartSection;
import pl.mmazur.pages.sections.productDetailPage.ProductCustomizationSection;
import pl.mmazur.utils.PageUtils;

@Getter
public class ProductsDetailsPage {

    private ProductCustomizationSection prodcutCustomizationSection;
    private AddToCartSection addToCartSection;

    public ProductsDetailsPage(Page page) {
        PageUtils.waitForPageToLoad(page);
        this.prodcutCustomizationSection = new ProductCustomizationSection(page);
        this.addToCartSection = new AddToCartSection(page);
    }


}
