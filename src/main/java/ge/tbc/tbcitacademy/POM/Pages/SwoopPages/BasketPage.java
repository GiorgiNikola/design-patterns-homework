package ge.tbc.tbcitacademy.POM.Pages.SwoopPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BasketPage {
    public SelenideElement itemTitleInBasket = $(".item-title.desktop-version a");
}
