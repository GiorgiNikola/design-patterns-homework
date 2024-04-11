package ge.tbc.tbcitacademy.POM.Steps.HerokuappSteps;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.Pages.HerokuappPages.CheckboxesPage;

import static com.codeborne.selenide.Condition.type;

public class CheckboxesSteps {
    CheckboxesPage checkboxesPage = new CheckboxesPage();
    public CheckboxesSteps setFirstCheckBoxSelected(){
        checkboxesPage.checkBoxes.get(0).click();
        return this;
    }

    public CheckboxesSteps validateCheckboxesType(){
        for (SelenideElement checkbox : checkboxesPage.checkBoxes){
            checkbox.shouldHave(type(Constants.checkBoxTxt));
        }
        return this;
    }
}
