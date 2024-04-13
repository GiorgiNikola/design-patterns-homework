package ge.tbc.tbcitacademy.Tests;

import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.Listeners.CustomTestListener;
import ge.tbc.tbcitacademy.POM.Steps.SwoopSteps.HeaderSteps;
import ge.tbc.tbcitacademy.POM.Steps.SwoopSteps.OfferSteps;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

@Epic("Search Functionality")
public class DependsOnTest extends ConfigTests{
    HeaderSteps headerSteps = new HeaderSteps();
    OfferSteps offerSteps = new OfferSteps();
    @BeforeMethod
    public void setup(){
        open(Constants.swoopLink);
    }

    @Flaky
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Search Suggestions")
    @Story("Check suggestions")
    @Test(description = "Send text to search and validate suggestions")
    public void searchTest(){
        headerSteps
                .sendTextToSearchBox()
                .checkSuggestions();
    }

    @Severity(SeverityLevel.NORMAL)
    @Feature("Search Result Validation")
    @Story("Validate search result title")
    @Test(dependsOnMethods = "searchTest" ,
    description = "Once clicked on suggestion validate it's title")
    public void validateIndividualOfferNameFromSearch(){
        headerSteps
                .sendTextToSearchBox();
        String offerTitle = headerSteps
                .firstOptionTitle();
        headerSteps
                .clickFirstOption();
        offerSteps
                .validateOfferTitle(offerTitle);
    }

    @AfterMethod
    public void tear() {
        closeWindow();
    }
}
