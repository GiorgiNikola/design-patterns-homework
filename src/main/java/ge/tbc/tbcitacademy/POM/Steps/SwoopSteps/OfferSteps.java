package ge.tbc.tbcitacademy.POM.Steps.SwoopSteps;

import com.codeborne.selenide.Condition;
import ge.tbc.tbcitacademy.POM.Pages.SwoopPages.OfferPage;

public class OfferSteps {
    OfferPage offerPage = new OfferPage();

    public OfferSteps addToCart(){
        offerPage.addToCart.click();
        return this;
    }

    public OfferSteps goToBasket(){
        offerPage.cartBtn.click();
        return this;
    }

    public OfferSteps validateOfferTitle(String title){
        offerPage.OfferTitle.shouldHave(Condition.text(title));
        return this;
    }
}
