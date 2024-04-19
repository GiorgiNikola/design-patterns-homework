package ge.tbc.tbcitacademy.POM.Steps.HerokuappSteps;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.Pages.HerokuappPages.CheckboxesPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.type;

public class CheckboxesSteps {
    CheckboxesPage checkboxesPage = new CheckboxesPage();
    @Step("Select the first checkbox")
    public CheckboxesSteps setFirstCheckBoxSelected(){
        checkboxesPage.checkBoxes.get(0).click();
        return this;
    }

    @Step("Validate the checkboxes type")
    public CheckboxesSteps validateCheckboxesType(){
        for (SelenideElement checkbox : checkboxesPage.checkBoxes){
            checkbox.shouldHave(type(Constants.checkBoxTxt));
        }
        return this;
    }
}
