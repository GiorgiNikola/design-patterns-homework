package ge.tbc.tbcitacademy.Tests;

import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.DataProvider.CustomDataProvider;
import ge.tbc.tbcitacademy.POM.Listeners.CustomTestListener;
import ge.tbc.tbcitacademy.POM.Steps.DemoqaSteps.PracticeFormSteps;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

@Epic("Student Registration")
public class AlternativeParametrizations extends ConfigTests {
    PracticeFormSteps practiceFormSteps = new PracticeFormSteps();

    @Severity(SeverityLevel.NORMAL)
    @Feature("Fill Student Registration Form")
    @Story("Submit form with valid data")
    @Test(dataProvider = "studentInfoDataProvider", dataProviderClass = CustomDataProvider.class,
    description = "fill form with data, select gender submit form and then validate firstName and LastName")
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
