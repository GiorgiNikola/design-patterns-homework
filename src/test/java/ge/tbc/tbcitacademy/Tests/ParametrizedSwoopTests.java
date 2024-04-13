package ge.tbc.tbcitacademy.Tests;

import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.DataProvider.CustomDataProvider;
import ge.tbc.tbcitacademy.POM.Pages.SwoopPages.BasketPage;
import ge.tbc.tbcitacademy.POM.Steps.SwoopSteps.HeaderSteps;
import ge.tbc.tbcitacademy.POM.Steps.SwoopSteps.OfferSteps;
import ge.tbc.tbcitacademy.POM.Steps.SwoopSteps.SportsSteps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public class ParametrizedSwoopTests extends ConfigTests{
    HeaderSteps headerSteps = new HeaderSteps();
    SportsSteps sportsSteps = new SportsSteps();
    OfferSteps offerSteps = new OfferSteps();
    BasketPage basketPage = new BasketPage();
    @BeforeMethod
    public void before(){
        open(Constants.swoopLink);
    }

    @Test(dataProvider = "offersDataProvider", dataProviderClass = CustomDataProvider.class)
    public void checkSaleValuesTest(String offerName, int originalPrice, int discount){
        headerSteps
                .goToSportSection();
        int actualPrice = sportsSteps
                .returnActualPrice(offerName);
        Assert.assertEquals(actualPrice, originalPrice - discount);
    }

    @Test(dataProvider = "offerNamesDataProvider", dataProviderClass = CustomDataProvider.class)
    public void validateCartBehavior(String offerName){
        headerSteps
                .goToSportSection();
        sportsSteps
                .acceptCookie()
                .clickOffer(offerName);
        offerSteps
                .addToCart()
                .goToBasket();
        Assert.assertEquals(basketPage.itemTitleInBasket.getText(), offerName);
    }

    @AfterMethod
    public void tear(){
        closeWindow();
    }
}
