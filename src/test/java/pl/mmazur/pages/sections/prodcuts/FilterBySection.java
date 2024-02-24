package pl.mmazur.pages.sections.prodcuts;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.mmazur.utils.StringUtils;

import java.util.Arrays;

import static pl.mmazur.utils.StringUtils.*;

public class FilterBySection {
    private Locator leftSlider;

    private Page page;

    private Locator priceLabel;

    public FilterBySection(Page page) {
        this.page = page;
        leftSlider = page.locator(".ui-slider-handle").first();
        priceLabel = page.locator("#search_filters li p");
    }

    public void showLeftSlider() { //metoda pomoncicza do wyświetlania kooridynatów elementu
        System.out.println(leftSlider.boundingBox().x); //wyświetlanie kooridynatów elementu (x, y, wysokość i szerokość)
        System.out.println(leftSlider.boundingBox().y);

        System.out.println(leftSlider.boundingBox().height);
        System.out.println(leftSlider.boundingBox().width);
    }

    public void filterProductsByPriceWithMouse(double fromPrice) {

        while (fromPrice != getFromPrice()) {
            double x = leftSlider.boundingBox().x;
            double y = leftSlider.boundingBox().y;

            double middleX = x + leftSlider.boundingBox().width / 2;
            double middleY = y + leftSlider.boundingBox().height / 2;

            leftSlider.scrollIntoViewIfNeeded();
            page.mouse().move(middleX, middleY);
            page.mouse().down(); //przytrzymać przycisk myszy
            page.mouse().move(x + 7.00, y);
            page.mouse().up(); //puścić przycisk myszy
//            page.waitForCondition(() -> page.locator(".overlay__inner").isHidden());
            page.waitForCondition(() -> page.locator(".overlay__inner").isHidden());
        }
    }

    public void filterProductsByPriceWithKeyboard(double fromPrice) {
        while (fromPrice != getFromPrice()) {
            leftSlider.press("ArrowRight");
            page.waitForCondition(() -> page.locator(".overlay__inner").isHidden());
        }
    }

    public double getFromPrice() {
        return Arrays.asList(page.locator("#search_filters li p").innerText().split(" "))
                .stream()
                .map(p -> p.replaceAll(toUTF8("zł"), ""))
                .map(Double::parseDouble)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Invalid price format"));
    }

}
