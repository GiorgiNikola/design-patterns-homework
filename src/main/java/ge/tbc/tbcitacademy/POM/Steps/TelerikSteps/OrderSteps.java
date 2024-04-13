package ge.tbc.tbcitacademy.POM.Steps.TelerikSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.Pages.TelerikPages.OrderPage;
import ge.tbc.tbcitacademy.POM.Util.HelperFunctions;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class OrderSteps {
    OrderPage orderPage = new OrderPage();

    @Step("dismiss login popup")
    public OrderSteps dismissLogin(){
        orderPage.dismissBtn.click();
        return this;
    }

    @Step("validate unit price")
    public boolean validateUnitPrice(){
        return orderPage.priceElement.getText().equals(HelperFunctions.formatCurrency(Constants.unitPrice));
    }

    @Step("increase term property")
    public OrderSteps increaseTheTerm(){
        orderPage.dropDown.click();
        orderPage.options.filter(Condition.innerText(Constants.oneYearTxt)).get(0).click();
        return this;
    }

    @Step("validate price after increasing term")
    public OrderSteps validateTermIncreasedPrice(){
        double subTotalPrice =
                Constants.unitPrice + HelperFunctions.calculatePercentage(Constants.maintenancePrice, Constants.unitPricePercent);
        orderPage.subTotalPriceElement.shouldHave(text(HelperFunctions.formatCurrency(subTotalPrice)));
        return this;
    }

    @Step("increase quantity")
    public OrderSteps increaseQuantity(){
        orderPage.quantityDropDown.click();
        return this;
    }

    @Step("validate price after increasing quantity")
    public OrderSteps validateQuantityIncreasedPrice(){
        orderPage.options.filter(Condition.innerText("2")).get(0).click();
        double subTotalPrice = HelperFunctions.calculatePercentage(Constants.unitPrice * 2, Constants.unitPricePercent)
                + HelperFunctions.calculatePercentage(Constants.maintenancePrice * 2, Constants.maintenancePricePercent);
        orderPage.subTotalPriceElement.shouldHave(text(HelperFunctions.formatCurrency(subTotalPrice)));
        return this;
    }

    @Step("validate discounts is correct")
    public OrderSteps validateTotalDiscounts(){
        orderPage.questionMark.hover();
        double licenceDiscountPrice = HelperFunctions
                .calculatePercentage(Constants.unitPrice * 2, Constants.unitDiscountPercent);
        orderPage.licensesDiscount.shouldHave(text(HelperFunctions.formatCurrency(licenceDiscountPrice)));
        double maintenanceDiscountPrice = HelperFunctions
                .calculatePercentage(Constants.maintenancePrice * 2, Constants.maintenanceDiscountPercent);
        orderPage.maintenanceDiscount.shouldHave(text(HelperFunctions.formatCurrency(maintenanceDiscountPrice)));
        double totalDiscount = HelperFunctions
                .textToDouble(orderPage.licensesDiscount.getText()) + HelperFunctions.textToDouble(orderPage.maintenanceDiscount.getText());
        orderPage.totalDiscountElement.shouldHave(partialText(HelperFunctions.formatCurrency(totalDiscount)));
        return this;
    }

    @Step("validate total value")
    public OrderSteps validateTotalValue(){
        double totalValue = Constants.unitPrice * 2
                + Constants.maintenancePrice * 2
                - HelperFunctions.textToDouble(orderPage.totalDiscountElement.getText());
        orderPage.subTotalPriceElement.shouldHave(text(HelperFunctions.formatCurrency(totalValue)));
        return this;
    }

    @Step("continue as guest")
    public OrderSteps continueAsGuest(){
        orderPage.continueAsGuest.click();
        return this;
    }
}
