package pl.mmazur.fasades;

import pl.mmazur.pages.OrderConfirmationPage;
import pl.mmazur.pages.modals.AddToCartConfirmationModalPage;

public class OrderProductFacade {

    public OrderConfirmationPage orderProduct(AddToCartConfirmationModalPage confirmationPage){
        return confirmationPage
                .proceedToCheckoutOnModal()
                .proceedToCheckoutOnShoppingCartPage()
                .enterOrderDetails();
    }

}
