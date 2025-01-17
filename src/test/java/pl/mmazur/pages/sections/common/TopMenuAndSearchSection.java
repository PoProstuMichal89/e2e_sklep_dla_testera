package pl.mmazur.pages.sections.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;
import pl.mmazur.pages.ArtPage;
import pl.mmazur.pages.BasePage;
import pl.mmazur.pages.SearchResultPage;

@Getter
public class TopMenuAndSearchSection{

    private Page page;
    private Locator searchInput;

    private Locator artLink;

    public TopMenuAndSearchSection(Page page) {
        this.page = page;
        this.searchInput = page.locator("input[name='s']");
        this.artLink =page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Art").setExact(true));
    }

    public SearchResultPage searchForProducts(String productName) {
        searchInput.fill(productName);
        page.keyboard().press("Enter");

        return new SearchResultPage(page);
    }

    public ArtPage clickArtLink() {
        artLink.click();
        return new ArtPage(page);
    }
}
