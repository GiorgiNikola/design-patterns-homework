package ge.tbc.tbcitacademy.Tests;

import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.Steps.DemoqaSteps.TextBoxSteps;
import ge.tbc.tbcitacademy.POM.Steps.HerokuappSteps.CheckboxesSteps;
import ge.tbc.tbcitacademy.POM.Steps.HerokuappSteps.DropDownSteps;
import ge.tbc.tbcitacademy.POM.Steps.TelerikSteps.IndividualProductsSteps;
import ge.tbc.tbcitacademy.POM.Steps.TelerikSteps.NavigationSteps;
import ge.tbc.tbcitacademy.POM.Steps.TelerikSteps.ProductBundlesSteps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTests extends ConfigTests{
    NavigationSteps navigationSteps = new NavigationSteps();
    ProductBundlesSteps productBundlesSteps = new ProductBundlesSteps();
    IndividualProductsSteps individualProductsSteps = new IndividualProductsSteps();
    CheckboxesSteps checkboxesSteps = new CheckboxesSteps();
    DropDownSteps dropDownSteps = new DropDownSteps();
    TextBoxSteps textBoxSteps = new TextBoxSteps();
    @Test
    public void validateBundleOffers(){
        open(Constants.telerikURL);
        navigationSteps
                .goToPricingPage();
        productBundlesSteps
                .mockingSolutionNotInUI()
                .issueEscalationOnlyInUltimate()
                .reportManagementOnlyInUltimate();
        boolean checkTelerikTestStudio = productBundlesSteps
                .telerikTestStudioOnlyInUltimate();
        Assert.assertTrue(checkTelerikTestStudio);
        boolean checkUiForJquery = productBundlesSteps
                .uiForJqueryInAllOffers();
        Assert.assertTrue(checkUiForJquery);
        productBundlesSteps
                .validateTelerikReportServer();
        boolean checkTelerikReporting = productBundlesSteps
                .validateTelerikReporting();
        Assert.assertTrue(checkTelerikReporting);
        boolean checkOnDemandVideos = productBundlesSteps
                .validateAccessOnDemandVideos();
        Assert.assertTrue(checkOnDemandVideos);
        productBundlesSteps
                .validateOfferNamesRemainSticky();
    }

    @Test
    public void validateIndividualOffers(){
        open(Constants.telerikURL);
        navigationSteps
                .goToPricingPage();
        productBundlesSteps
                .acceptCookies();
        individualProductsSteps
                .clickPage()
                .imagesAppearOnceHover()
                .validatePrioritySupport()
                .validateKendoReactPrice()
                .validateKendoUiPrice();
    }

    @Test
    public void checkBoxTest(){
        open(Constants.checkBoxURL);
        checkboxesSteps
                .setFirstCheckBoxSelected()
                .validateCheckboxesType();
    }

    @Test
    public void dropDownTest(){
        open(Constants.dropDownURL);
        dropDownSteps
                .validatePleaseSelectOption()
                .selectOption2()
                .validateOption2Selected();
    }

    @Test
    public void collectionsTest(){
        open(Constants.textBoxURL);
        textBoxSteps
                .fillTextBoxWithData()
                .submitData()
                .validateResult();
    }

    @AfterMethod
    public void afterMethod(){
        closeWebDriver();
    }
}
