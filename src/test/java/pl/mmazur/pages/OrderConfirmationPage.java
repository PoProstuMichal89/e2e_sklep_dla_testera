package pl.mmazur.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.mmazur.pages.sections.orderConfirmationPage.OrderConfirmationDetalisSection;
import pl.mmazur.pages.sections.orderDetalisPage.OrderAddressSection;
import pl.mmazur.pages.sections.orderDetalisPage.OrderPersonalInformationSection;

import static pl.mmazur.utils.PageUtils.waitForPageToLoad;

@Getter
public class OrderConfirmationPage extends BasePage {

 private OrderConfirmationDetalisSection orderConfirmationDetalisSection;

    public OrderConfirmationPage(Page page) {
        super(page);
        this.orderConfirmationDetalisSection = new OrderConfirmationDetalisSection(page);
    }

}
