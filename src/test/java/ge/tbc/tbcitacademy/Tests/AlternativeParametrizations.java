package ge.tbc.tbcitacademy.Tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.DataProvider.CustomDataProvider;
import ge.tbc.tbcitacademy.POM.Steps.DemoqaSteps.PracticeFormSteps;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.closeWindow;

public class AlternativeParametrizations extends ConfigTests{
    PracticeFormSteps practiceFormSteps = new PracticeFormSteps();

    @Test(dataProvider = "studentInfoDataProvider", dataProviderClass = CustomDataProvider.class)
    public void fillFormWithParameters(String firstName, String lastName, String gender, String mobileNumber) {
        open(Constants.formLink);
        practiceFormSteps
                .fillFormWithData(firstName, lastName, mobileNumber)
                .selectGender(gender)
                .submitForm()
                .validateStudentName(firstName, lastName);
    }

    @AfterMethod
    public void tear(){
        closeWindow();
    }
}
