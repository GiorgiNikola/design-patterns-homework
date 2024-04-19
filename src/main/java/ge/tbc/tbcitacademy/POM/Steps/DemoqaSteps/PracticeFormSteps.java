package ge.tbc.tbcitacademy.POM.Steps.DemoqaSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.POM.Pages.DemoqaPages.PracticeFormPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PracticeFormSteps {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Step("Fill form with data: First Name, Last Name, Mobile Number")
    public PracticeFormSteps fillFormWithData(String firstName, String lastName, String mobileNumber){
        practiceFormPage.firstNameBox.sendKeys(firstName);
        practiceFormPage.lastNameBox.sendKeys(lastName);
        practiceFormPage.mobileNumberBox.sendKeys(mobileNumber);
        return this;
    }

    @Step("Select gender: {0}")
    public PracticeFormSteps selectGender(String gender){
        if (gender.equalsIgnoreCase("male")){
            practiceFormPage.maleBtn.scrollTo().click();
        }else if (gender.equalsIgnoreCase("female")){
            practiceFormPage.femaleBtn.scrollTo().click();
        }else{
            practiceFormPage.otherBtn.scrollTo().click();
        }
        return this;
    }

    @Step("Submit the form")
    public PracticeFormSteps submitForm(){
        practiceFormPage.submitBtn.scrollTo().click();
        return this;
    }

    @Step("Validate student name is: {0} {1}")
    public PracticeFormSteps validateStudentName(String firstName, String lastName){
        practiceFormPage.studentName
                .sibling(0)
                .shouldHave(Condition.text(firstName + " " + lastName));
        return this;
    }
}
