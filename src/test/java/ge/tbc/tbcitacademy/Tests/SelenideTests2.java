package ge.tbc.tbcitacademy.Tests;

import com.codeborne.selenide.ElementsCollection;
import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.Listeners.CustomTestListener;
import ge.tbc.tbcitacademy.POM.Steps.DemoqaSteps.BooksSteps;
import ge.tbc.tbcitacademy.POM.Steps.TelerikSteps.*;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@Epic("Web Application Testing")
public class SelenideTests2 extends ConfigTests{
    DemosSteps demosSteps = new DemosSteps();
    NavigationSteps navigationSteps = new NavigationSteps();
    ProductBundlesSteps productBundlesSteps = new ProductBundlesSteps();
    OrderSteps orderSteps = new OrderSteps();
    ContactInfoSteps contactInfoSteps = new ContactInfoSteps();
    BooksSteps booksSteps = new BooksSteps();
    SoftAssert sfa = new SoftAssert();
    @Severity(SeverityLevel.NORMAL)
    @Feature("Telerik Demos")
    @Story("Validate Demos Design and Functionality")
    @Test(description = "Validate different design aspects of Demos")
    public void validateDemosDesign(){
        open(Constants.telerikURL);
        demosSteps
                .acceptCookies();
        demosSteps
                .validatePurpleOverlay()
                .validateUiForVueDemos();
        boolean validateAvailableOnStores = demosSteps
                .validateTelerikUiAvailableOnStores();
        sfa.assertTrue(validateAvailableOnStores);
        demosSteps
                .validateSectionsRemainSticky()
                .validateSectionLinks();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Feature("Telerik Order Process")
    @Story("Validate Order Mechanics")
    @Test(description = "Validate that different parts of order mechanics work correctly")
    public void validateOrderMechanics(){
        open(Constants.telerikURL);
        navigationSteps
                .goToPricingPage()
                .acceptCookies();
        productBundlesSteps
                .clickBuyButton()
                .acceptCookies();
        boolean validatePrice = orderSteps
                .validateUnitPrice();
        sfa.assertTrue(validatePrice);
        orderSteps
                .increaseTheTerm()
                .validateTermIncreasedPrice()
                .increaseQuantity()
                .validateQuantityIncreasedPrice()
                .validateTotalDiscounts()
                .validateTotalValue()
                .continueAsGuest();
        contactInfoSteps
                .fillTheForm()
                .clickContinueButton()
                .clickGoBackButton()
                .validateInfoIsStillPresent();
    }

    @Severity(SeverityLevel.MINOR)
    @Feature("Book Store")
    @Story("Filter and Validate Books")
    @Test(description = "Filter books and validate books images")
    public void chainedLocatorsTest(){
        open(Constants.demoQaBooksLink);
        booksSteps
                .filterBooks()
                .validateBookImages();
    }

    @Severity(SeverityLevel.MINOR)
    @Flaky
    @Feature("Book Store")
    @Story("Validate Book Details")
    @Test(description = "This is flaky test, it should fail")
    public void softAssertTest(){
        open(Constants.demoQaBooksLink);
        ElementsCollection books = booksSteps
                .findSpecificBooks();
        sfa.assertEquals(books.size(), 10);
        sfa.assertEquals(books.get(0), Constants.firstBookName);
    }

    @AfterMethod
    public void afterMethod(){
        closeWebDriver();
    }

    @AfterTest
    public void tearDown(){
        sfa.assertAll();
    }
}
