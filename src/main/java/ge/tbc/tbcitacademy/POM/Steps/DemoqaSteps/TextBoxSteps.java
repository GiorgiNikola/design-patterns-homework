package ge.tbc.tbcitacademy.POM.Steps.DemoqaSteps;

import com.codeborne.selenide.CollectionCondition;
import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.Pages.DemoqaPages.TextBoxPage;
import io.qameta.allure.Step;

public class TextBoxSteps {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Step("Fill text box with data")
    public TextBoxSteps fillTextBoxWithData(){
        textBoxPage.fullName.sendKeys(Constants.fullName);
        textBoxPage.email.sendKeys(Constants.myEmail);
        textBoxPage.currentAddress.sendKeys(Constants.currentAddress);
        textBoxPage.permanentAddress.sendKeys(Constants.permanentAddress);
        return this;
    }

    @Step("Submit the data")
    public TextBoxSteps submitData(){
        textBoxPage.submitBtn.scrollIntoView(true);
        textBoxPage.submitBtn.click();
        return this;
    }

    @Step("Validate the result")
    public TextBoxSteps validateResult(){
        textBoxPage.result.shouldHave((CollectionCondition.textsInAnyOrder(
                Constants.nameTxt + Constants.fullName,
                Constants.emailTxt + Constants.myEmail,
                Constants.currentAddressTxt + Constants.currentAddress,
                Constants.permanentAddressTxt + Constants.permanentAddress
        )));
        return this;
    }
}
