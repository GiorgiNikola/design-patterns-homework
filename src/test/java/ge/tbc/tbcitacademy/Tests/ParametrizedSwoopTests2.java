package ge.tbc.tbcitacademy.Tests;

import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.Listeners.CustomTestListener;
import ge.tbc.tbcitacademy.POM.Steps.SwoopSteps.HeaderSteps;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

@Epic("Swoop Website Navigation")
public class ParametrizedSwoopTests2 extends ConfigTests{
    private String sectionName;
    HeaderSteps headerSteps = new HeaderSteps();

    public ParametrizedSwoopTests2(String sectionName) {
        this.sectionName = sectionName;
    }

    @BeforeMethod
    public void setup(){
        open(Constants.swoopLink);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Feature("Section Navigation")
    @Story("Verify 'გაანაწილე 4 თვეზე' button")
    @Test(description = "Validate that 'გაანაწილე 4 თვეზე' button is present on current section")
    public void checkDividePriceBtnTest(){
        headerSteps
                .goToSection(sectionName)
                .checkDivideIntoFourMonthsBtn();
    }

    @AfterMethod
    public void tear(){
        closeWindow();
    }
}
