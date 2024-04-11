package ge.tbc.tbcitacademy.POM.Pages.TelerikPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.POM.Data.Constants;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class ContactInfoPage {
    public SelenideElement firstName = $("#biFirstName"),
    lastName = $("#biLastName"),
    email = $("#biEmail"),
    company = $("#biCompany"),
    phone = $("#biPhone"),
    address = $("#biAddress"),
    countrySelect = $(".k-select"),
    city = $("#biCity"),
    postalCode = $("#biZipCode"),
    backBtn = $(byText(Constants.backTxt)),
    country = $(".k-dropdown-wrap.k-state-default input.k-input"),
    continueBtn = $(byText(Constants.continueTxt));
    public ElementsCollection options = $$x("//ul[@role='listbox']//li").shouldBe();
}
