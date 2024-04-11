package ge.tbc.tbcitacademy.POM.Pages.TelerikPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.POM.Data.Constants;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class OrderPage {
    public SelenideElement dismissBtn = $(".far.fa-times.label.u-cp"),
    priceElement = $("span[class='e2e-price-per-license ng-star-inserted']"),
    dropDown = $("period-select[class='u-db td-cell--data border-left'] div[class='ng-star-inserted']"),
    quantityDropDown = $(".td-cell--data.border-left.ng-star-inserted"),
    subTotalPriceElement = $(".u-mt8.e2e-cart-item-subtotal.sm-no-spacing.td-cell.td-cell--data"),
    questionMark = $("i[class='far fa-question-circle tooltip-icon']"),
    licensesDiscount = $(".u-pr5.e2e-licenses-discounts"),
    maintenanceDiscount = $(".u-pr5.e2e-ms-discounts"),
    totalDiscountElement =  $(".u-fr.e2e-total-discounts-price"),
    continueAsGuest = $(byText(Constants.continueAsGuestTxt));
    public ElementsCollection options = $$x("//ul[@role='listbox']//li");
}
