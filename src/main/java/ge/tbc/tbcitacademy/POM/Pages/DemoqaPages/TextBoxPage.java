package ge.tbc.tbcitacademy.POM.Pages.DemoqaPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    public SelenideElement fullName = $(byId("userName")),
    email = $(by("type", "email")),
    currentAddress = $(by("placeholder", "Current Address")),
    permanentAddress = $x("//textarea[@id='permanentAddress']"),
    submitBtn = $("#submit");
    public ElementsCollection result = $$("div.border.col-md-12 p");
}
