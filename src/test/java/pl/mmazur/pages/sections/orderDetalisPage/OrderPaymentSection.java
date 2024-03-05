package pl.mmazur.pages.sections.orderDetalisPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.mmazur.pages.BasePage;

public class OrderPaymentSection extends BasePage {

    private final String paymentSection = "#checkout-payment-step ";

    private Locator payByCashOnDelivery;
    private Locator termsAndConditions;
    private Locator placeOrderButton;

    public OrderPaymentSection(Page page) {
        super(page);
        this.payByCashOnDelivery = page.locator(paymentSection+ "#payment-option-2");
        this.termsAndConditions = page.locator(paymentSection+ "input[name='conditions_to_approve[terms-and-conditions]']");
        this.placeOrderButton = page.locator(paymentSection+ "#payment-confirmation button");
    }

    public void placeOrder(){
        payByCashOnDelivery.check();
        termsAndConditions.check();
        placeOrderButton.click();
    }
}
