package pl.mmazur.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.mmazur.pages.sections.prodcuts.FilterBySection;
import pl.mmazur.pages.sections.prodcuts.ProductSection;
import pl.mmazur.utils.PageUtils;

@Getter
public class ArtPage extends BasePage{

    private ProductSection productSection;

    private FilterBySection filterBySection;

    public ArtPage(Page page) {
        super(page);
        PageUtils.waitForPageToLoad(page);
        this.productSection = new ProductSection(page);
        this.filterBySection = new FilterBySection(page);

    }
}
