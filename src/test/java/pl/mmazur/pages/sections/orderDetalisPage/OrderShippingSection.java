package pl.mmazur.pages.sections.orderDetalisPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.mmazur.pages.BasePage;

public class OrderShippingSection extends BasePage {

    private final String shippingSection = "#checkout-delivery-step ";

    private Locator deliveryMyCarrier;
    private Locator continueButton;
    public OrderShippingSection(Page page) {
        super(page);
        this.deliveryMyCarrier = page.locator(shippingSection+ "#delivery_option_2");
        this.continueButton = page.locator(shippingSection+ "button[name=confirmDeliveryOption]");
    }

    public OrderPaymentSection selectDeliveryMethod(){
        deliveryMyCarrier.check();
        continueButton.click();

        return new OrderPaymentSection(page);
    }

}
