package ge.tbc.tbcitacademy.POM.Steps.DemoqaSteps;

import com.codeborne.selenide.CollectionCondition;
import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.Pages.DemoqaPages.TextBoxPage;

public class TextBoxSteps {
    TextBoxPage textBoxPage = new TextBoxPage();

    public TextBoxSteps fillTextBoxWithData(){
        textBoxPage.fullName.sendKeys(Constants.fullName);
        textBoxPage.email.sendKeys(Constants.myEmail);
        textBoxPage.currentAddress.sendKeys(Constants.currentAddress);
        textBoxPage.permanentAddress.sendKeys(Constants.permanentAddress);
        return this;
    }

    public TextBoxSteps submitData(){
        textBoxPage.submitBtn.scrollIntoView(true);
        textBoxPage.submitBtn.click();
        return this;
    }

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
