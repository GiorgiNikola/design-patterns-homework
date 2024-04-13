package ge.tbc.tbcitacademy.POM.Steps.TelerikSteps;

import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.Pages.TelerikPages.IndividualProductsPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class IndividualProductsSteps {
    IndividualProductsPage individualProductsPage = new IndividualProductsPage();

    public IndividualProductsSteps clickPage(){
        individualProductsPage.individualProductsBtn.click();
        return this;
    }

    public IndividualProductsSteps imagesAppearOnceHover(){
        individualProductsPage.offer1.scrollTo();
        individualProductsPage.offer1.hover();
        individualProductsPage.offer1Ninja.shouldBe(visible);
        individualProductsPage.offer2.hover();
        individualProductsPage.offer2Ninja.shouldBe(visible);
        return this;
    }

    public IndividualProductsSteps validatePrioritySupport(){
        individualProductsPage.dropDown1.shouldHave(text(Constants.prioritySupportTxt));
        individualProductsPage.dropDown2.shouldHave(text(Constants.prioritySupportTxt));
        return this;
    }

    public IndividualProductsSteps validateKendoReactPrice(){
        individualProductsPage.kendoReactPrice.shouldHave(text(Constants.kendoReactPrice));
        return this;
    }

    public IndividualProductsSteps validateKendoUiPrice(){
        individualProductsPage.kendoUiPrice.shouldHave(text(Constants.kendoUiPrice));
        return this;
    }
}
