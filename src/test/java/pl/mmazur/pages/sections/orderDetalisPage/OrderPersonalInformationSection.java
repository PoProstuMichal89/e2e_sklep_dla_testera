package pl.mmazur.pages.sections.orderDetalisPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.mmazur.pages.BasePage;

public class OrderPersonalInformationSection extends BasePage {

    private Locator socialTitleMr;
    private Locator socialTitleMrs;
    private Locator firstNameInput;
    private Locator lastNameInput;
    private Locator emailInput;
    private Locator passwordInput;
    private Locator dobInput;
    private Locator termsAndConditionsCheckbox;
    private Locator customerPrivacyCheckbox;

    private Locator continueButton;

    public OrderPersonalInformationSection(Page page) {
        super(page);
    }
}
