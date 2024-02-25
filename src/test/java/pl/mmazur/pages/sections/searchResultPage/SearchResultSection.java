package pl.mmazur.pages.sections.searchResultPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.mmazur.dto.ProductDTO;
import pl.mmazur.pages.ProductsDetailsPage;
import pl.mmazur.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;


public class SearchResultSection {

    private Page page;

    @Getter
    private List<Locator> products;

    public SearchResultSection(Page page) {

        this.page=page;
        products = page.locator(".js-product").all();
    }

    public ProductsDetailsPage viewProductDetails(String productName){
        ProductDTO productDTO = productsToDto().stream()
                .filter(p -> p.getName().equals(productName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Product not found " + productName));

        productDTO.getThumbNail().click();

        return new ProductsDetailsPage(page);
    }

    public List <ProductDTO> productsToDto(){
        return products.stream()
                .map(p->{
                    return ProductDTO.builder()
                            .thumbNail(p.locator(".thumbnail-top"))
                            .name(p.locator(".product-title").innerText())
                            .price(Double.parseDouble(p.locator(".price").innerText().replaceAll(StringUtils.toUTF8("zł"), "")))
                            .build();
                })
                .collect(Collectors.toList());
    }



}
