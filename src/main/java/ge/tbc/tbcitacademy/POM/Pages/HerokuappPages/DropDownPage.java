package ge.tbc.tbcitacademy.POM.Pages.HerokuappPages;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.POM.Data.Constants;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class DropDownPage {
    public SelenideElement dropDown = $(byId(Constants.dropDownTxt));
}
