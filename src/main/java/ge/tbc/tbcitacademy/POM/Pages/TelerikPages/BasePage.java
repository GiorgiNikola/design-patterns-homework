package ge.tbc.tbcitacademy.POM.Pages.TelerikPages;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.POM.Data.Constants;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    public SelenideElement acceptCookies = $(withText(Constants.acceptCookies));
}
