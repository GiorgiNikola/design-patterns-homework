package ge.tbc.tbcitacademy.POM.Steps.HerokuappSteps;

import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.Pages.HerokuappPages.DropDownPage;

import static com.codeborne.selenide.Condition.text;

public class DropDownSteps {
    DropDownPage dropDownPage = new DropDownPage();
    public DropDownSteps validatePleaseSelectOption(){
        dropDownPage.dropDown.getSelectedOption().shouldHave(text(Constants.selectOptionTxt));
        return this;
    }

    public DropDownSteps selectOption2(){
        dropDownPage.dropDown.selectOption(Constants.option2Txt);
        return this;
    }

    public DropDownSteps validateOption2Selected(){
        dropDownPage.dropDown.getSelectedOption().shouldHave(text(Constants.option2Txt));
        return this;
    }
}
