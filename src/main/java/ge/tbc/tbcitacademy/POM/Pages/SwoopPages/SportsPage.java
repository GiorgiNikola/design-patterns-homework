package ge.tbc.tbcitacademy.POM.Pages.SwoopPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SportsPage {
    public ElementsCollection offers = $$(".special-offer");
    public SelenideElement acceptCookieBtn = $(".acceptCookie");
}
