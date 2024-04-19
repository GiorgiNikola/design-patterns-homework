package ge.tbc.tbcitacademy.POM.Steps.HerokuappSteps;

import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.Pages.HerokuappPages.DropDownPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;

public class DropDownSteps {
    DropDownPage dropDownPage = new DropDownPage();
    @Step("Validate 'Please select an option' is selected")
    public DropDownSteps validatePleaseSelectOption(){
        dropDownPage.dropDown.getSelectedOption().shouldHave(text(Constants.selectOptionTxt));
        return this;
    }

    @Step("Select 'Option 2' from the dropdown")
    public DropDownSteps selectOption2(){
        dropDownPage.dropDown.selectOption(Constants.option2Txt);
        return this;
    }

    @Step("Validate 'Option 2' is selected")
    public DropDownSteps validateOption2Selected(){
        dropDownPage.dropDown.getSelectedOption().shouldHave(text(Constants.option2Txt));
        return this;
    }
}
