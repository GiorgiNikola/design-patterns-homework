package ge.tbc.tbcitacademy.Tests;

import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.DataProvider.CustomDataProvider;
import ge.tbc.tbcitacademy.POM.Listeners.CustomTestListener;
import ge.tbc.tbcitacademy.POM.Pages.SwoopPages.BasketPage;
import ge.tbc.tbcitacademy.POM.Steps.SwoopSteps.HeaderSteps;
import ge.tbc.tbcitacademy.POM.Steps.SwoopSteps.OfferSteps;
import ge.tbc.tbcitacademy.POM.Steps.SwoopSteps.SportsSteps;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

@Epic("Sports Offers")
public class ParametrizedSwoopTests extends ConfigTests{
    HeaderSteps headerSteps = new HeaderSteps();
    SportsSteps sportsSteps = new SportsSteps();
    OfferSteps offerSteps = new OfferSteps();
    BasketPage basketPage = new BasketPage();
    @BeforeMethod
    public void before(){
        open(Constants.swoopLink);
    }

    @Severity(SeverityLevel.NORMAL)
    @Feature("Sale Price Validation")
    @Story("Verify sale price calculation")
    @Test(dataProvider = "offersDataProvider", dataProviderClass = CustomDataProvider.class,
    description = "Go to sport section and check offer price is correct")
    public void checkSaleValuesTest(String offerName, int originalPrice, int discount){
        headerSteps
                .goToSportSection();
        int actualPrice = sportsSteps
                .returnActualPrice(offerName);
        Assert.assertEquals(actualPrice, originalPrice - discount);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Feature("Shopping Cart Management")
    @Story("Add offer to cart and validate cart contents")
    @Test(dataProvider = "offerNamesDataProvider", dataProviderClass = CustomDataProvider.class,
    description = "Validate offer is added to cart correctly")
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
