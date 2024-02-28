package pl.mmazur.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.mmazur.pages.sections.orderDetalisPage.OrderPersonalInformationSection;
import pl.mmazur.utils.PageUtils;

@Getter
public class OrderDetalisPage extends BasePage {

    private OrderPersonalInformationSection personalInformation;

    public OrderDetalisPage(Page page) {
        super(page);
        PageUtils.waitForPageToLoad(page);
        this.personalInformation = new OrderPersonalInformationSection(page);
    }
}
