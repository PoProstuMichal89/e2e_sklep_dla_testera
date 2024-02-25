package pl.mmazur.pages.sections.productDetailPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductCustomizationSection {
    private Page page;
    private Locator customMessageInput;
    private Locator saveCustomizationButton;

    private Locator customizationLabel;

    public ProductCustomizationSection(Page page) {
        this.page = page;
        this.customMessageInput = page.locator("#field-textField1");
        this.saveCustomizationButton = page.locator("button[name=submitCustomizedData]");
        this.customizationLabel= page.locator(".customization-message");
    }

    public void customizerProduct(String message) {
        customMessageInput.fill(message);
        saveCustomizationButton.click();
        page.waitForCondition(()-> customizationLabel.isVisible());

    }
}
