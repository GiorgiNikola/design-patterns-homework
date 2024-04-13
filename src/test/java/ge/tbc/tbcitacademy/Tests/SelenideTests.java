package ge.tbc.tbcitacademy.Tests;

import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.Listeners.CustomTestListener;
import ge.tbc.tbcitacademy.POM.Steps.DemoqaSteps.TextBoxSteps;
import ge.tbc.tbcitacademy.POM.Steps.HerokuappSteps.CheckboxesSteps;
import ge.tbc.tbcitacademy.POM.Steps.HerokuappSteps.DropDownSteps;
import ge.tbc.tbcitacademy.POM.Steps.TelerikSteps.IndividualProductsSteps;
import ge.tbc.tbcitacademy.POM.Steps.TelerikSteps.NavigationSteps;
import ge.tbc.tbcitacademy.POM.Steps.TelerikSteps.ProductBundlesSteps;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@Epic("Web Application Testing")
public class SelenideTests extends ConfigTests{
    NavigationSteps navigationSteps = new NavigationSteps();
    ProductBundlesSteps productBundlesSteps = new ProductBundlesSteps();
    IndividualProductsSteps individualProductsSteps = new IndividualProductsSteps();
    CheckboxesSteps checkboxesSteps = new CheckboxesSteps();
    DropDownSteps dropDownSteps = new DropDownSteps();
    TextBoxSteps textBoxSteps = new TextBoxSteps();

    @Severity(SeverityLevel.NORMAL)
    @Feature("Telerik Pricing Page")
    @Story("Validate Bundle Offers")
    @Test(description = "Validate that features are included correctly in different versions of bundle")
    public void validateBundleOffers(){
        open(Constants.telerikURL);
        navigationSteps
                .goToPricingPage();
        productBundlesSteps
                .mockingSolutionNotInUI() // intentionally failing this to see screenshot
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

    @Severity(SeverityLevel.CRITICAL)
    @Feature("Telerik Pricing Page")
    @Story("Validate Individual Offers")
    @Test(description = "Validate that images appear once you hover on offers and also validate " +
            "prices of offers")
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

    @Severity(SeverityLevel.CRITICAL)
    @Feature("Checkbox Testing")
    @Story("Validate Checkbox Behavior")
    @Test(description = "Set first checkbox selected and validate checkboxes type")
    public void checkBoxTest(){
        open(Constants.checkBoxURL);
        checkboxesSteps
                .setFirstCheckBoxSelected()
                .validateCheckboxesType();
    }



    @Feature("Dropdown Testing")
    @Story("Validate Dropdown Options")
    @Test(description = "Validate 'please select an option is selected' is selected and then select 'Option 2'")
    public void dropDownTest(){
        open(Constants.dropDownURL);
        dropDownSteps
                .validatePleaseSelectOption()
                .selectOption2()
                .validateOption2Selected();
    }

    @Severity(SeverityLevel.TRIVIAL)
    @Feature("Text Box Testing")
    @Story("Validate Text Box Submission")
    @Test(description = "Fill text box with data, submit and then validate the result")
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
