package ge.tbc.tbcitacademy.POM.Pages.SwoopPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class OfferPage {
    public SelenideElement addToCart = $(".addBasket.add-item-animation"),
    cartBtn = $("img[src='/Images/NewDesigneImg/ReHeader/basket.svg']"),
            OfferTitle = $(".merchantTitle");
}
