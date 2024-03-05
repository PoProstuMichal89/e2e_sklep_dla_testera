package pl.mmazur.pages.sections.orderDetalisPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.mmazur.pages.BasePage;

import java.time.LocalDateTime;

public class OrderAddressSection extends BasePage {

    private final String addressSection = "#checkout-addresses-step ";

    private Locator addressInput;
    private Locator city;
    private Locator zipCode;
    private Locator continueButton;

    public OrderAddressSection(Page page) {
        super(page);
        this.addressInput = page.locator(addressSection+ "#field-address1");
        this.zipCode = page.locator(addressSection+ "#field-postcode");
        this.city = page.locator(addressSection+ "#field-city");
        this.continueButton = page.locator(addressSection+ "button[name=confirm-addresses]");
    }

    public OrderShippingSection enterAddress(){
        addressInput.fill("ul. Sezamkowa 1/2");
        zipCode.fill("40-748");
        city.fill("Katowcie");
        continueButton.click();

        return new OrderShippingSection(page);
    }


}
