package ge.tbc.tbcitacademy.Tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.Steps.SwoopSteps.HeaderSteps;
import ge.tbc.tbcitacademy.POM.Steps.SwoopSteps.OfferSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class DependsOnTest extends ConfigTests{
    HeaderSteps headerSteps = new HeaderSteps();
    OfferSteps offerSteps = new OfferSteps();
    @BeforeMethod
    public void setup(){
        open(Constants.swoopLink);
    }

    @Test
    public void searchTest(){
        headerSteps
                .sendTextToSearchBox()
                .checkSuggestions();
    }

    @Test(dependsOnMethods = "searchTest")
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
    public void tear(){
        closeWindow();
    }
}
