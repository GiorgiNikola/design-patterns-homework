package ge.tbc.tbcitacademy.POM.Steps.SwoopSteps;

import com.codeborne.selenide.Condition;
import ge.tbc.tbcitacademy.POM.Pages.SwoopPages.OfferPage;
import io.qameta.allure.Step;

public class OfferSteps {
    OfferPage offerPage = new OfferPage();

    @Step("Add offer to cart")
    public OfferSteps addToCart(){
        offerPage.addToCart.click();
        return this;
    }

    @Step("Go to the basket")
    public OfferSteps goToBasket(){
        offerPage.cartBtn.click();
        return this;
    }

    @Step("Validate offer title is '{0}'")
    public OfferSteps validateOfferTitle(String title){
        offerPage.OfferTitle.shouldHave(Condition.text(title));
        return this;
    }
}
