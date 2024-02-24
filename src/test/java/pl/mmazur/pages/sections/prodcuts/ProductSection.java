package pl.mmazur.pages.sections.prodcuts;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.mmazur.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

import static pl.mmazur.utils.StringUtils.*;

public class ProductSection {

    private Page page;

    @Getter
    private List<Locator> products;

    public ProductSection(Page page) {
        this.page = page;
        this.products = page.locator(".js-product").all();
    }

    private List<String> getProductsPricesText() {
        return page.locator(".js-product .price").allInnerTexts();
    }

    public List<Double> getProdcutsPrices() {
        return getProductsPricesText()
                .stream()
                .map(price -> price.replaceAll(toUTF8("zł"), ""))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }
}
