package pl.mmazur.pages.sections.orderDetalisPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.mmazur.pages.BasePage;
import pl.mmazur.utils.EmailUtils;

public class OrderPersonalInformationSection extends BasePage {

    private final String personalInformationSection = "#checkout-personal-information-step ";
    private final String customerForm =personalInformationSection + "#customer-form ";

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
        this.socialTitleMr = page.locator(customerForm + "#field-id_gender-1");
        this.socialTitleMrs = page.locator(customerForm + "#field-id_gender-2");
        this.firstNameInput = page.locator(customerForm + "#field-firstname");
        this.lastNameInput = page.locator(customerForm + "#field-lastname");
        this.emailInput = page.locator(customerForm + "#field-email");
        this.passwordInput = page.locator(customerForm + "#field-password");
        this.dobInput = page.locator(customerForm + "#field-birthday");
        this.termsAndConditionsCheckbox = page.locator(customerForm + "input[name=psgdpr]");
        this.customerPrivacyCheckbox = page.locator(customerForm + "input[name=customer_privacy]");
        this.continueButton = page.locator(customerForm + "button[name=continue]");
    }

    public OrderAddressSection enterPersonalInformation(){
        selectSocialTitleMr()
                .enterFirstName("John")
                .enterLastName("Doe")
                .enterEmail(EmailUtils.generateEmail())
                .enterPassword("fEc5wpgMWngnTj4A")
                .enterDateOfBirth("01/01/1990")
                .acceptTermsAndConditions()
                .acceptCustomerPrivacy()
                .clickContinueButton();

        return new OrderAddressSection(page);
    }

    private OrderPersonalInformationSection selectSocialTitleMr() {
        socialTitleMr.check();
        return this;
    }

private OrderPersonalInformationSection selectSocialTitleMrs() {
        socialTitleMrs.check();
        return this;
    }

    private OrderPersonalInformationSection enterFirstName(String firstName) {
        firstNameInput.fill(firstName);
        return this;
    }

    private OrderPersonalInformationSection enterLastName(String lastName) {
        lastNameInput.fill(lastName);
        return this;
    }

    private OrderPersonalInformationSection enterEmail(String email) {
        emailInput.fill(email);
        return this;
    }


    private OrderPersonalInformationSection enterPassword(String password) {
        passwordInput.fill(password);
        return this;
    }

    private OrderPersonalInformationSection enterDateOfBirth(String dob) {
        dobInput.fill(dob);
        return this;
    }

    private OrderPersonalInformationSection acceptTermsAndConditions() {
        termsAndConditionsCheckbox.check();
        return this;
    }

    private OrderPersonalInformationSection acceptCustomerPrivacy() {
        customerPrivacyCheckbox.check();
        return this;
    }

    private void clickContinueButton() {
        continueButton.click();
    }





}
