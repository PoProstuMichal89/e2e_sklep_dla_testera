package pl.mmazur.dto;

import com.microsoft.playwright.Locator;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {

    private Locator thumbNail;
    private String name;
    private double price;
}
