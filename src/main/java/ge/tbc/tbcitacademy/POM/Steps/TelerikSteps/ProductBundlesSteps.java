package ge.tbc.tbcitacademy.POM.Steps.TelerikSteps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.Pages.TelerikPages.ProductBundlesPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class ProductBundlesSteps extends BaseSteps{
    ProductBundlesPage productBundlesPage = new ProductBundlesPage();
    @Step("validate 'Mocking solution for rapid unit testing' is not present in DevCraftUI")
    public ProductBundlesSteps mockingSolutionNotInUI(){
        for (SelenideElement element : productBundlesPage.uiFeatures){
            element.shouldHave(text(Constants.mockingSolutionTxt)); // shouldNotHave
        }
        return this;
    }

    @Step("validate 'issue escalation' is only present in DevCraftUltimate")
    public ProductBundlesSteps issueEscalationOnlyInUltimate(){
        productBundlesPage.ultimateSupport.shouldHave(partialText(Constants.issueEscalation));
        productBundlesPage.completeSupport.shouldNotHave(partialText(Constants.issueEscalation));
        productBundlesPage.uiSupport.shouldNotHave(partialText(Constants.issueEscalation));
        return this;
    }

    @Step("validate 'End-to-end report management solution' is only present in DevCraftUltimate")
    public ProductBundlesSteps reportManagementOnlyInUltimate(){
        for (SelenideElement element : productBundlesPage.uiFeatures){
            element.shouldNotHave(text(Constants.endToEndReport));
        }
        for (SelenideElement element : productBundlesPage.completeFeatures){
            element.shouldNotHave(text(Constants.endToEndReport));
        }
        productBundlesPage.ultimateFeatures.shouldHave(CollectionCondition.itemWithText(Constants.endToEndReport));
        return this;
    }

    @Step("validate 'Telerik test studio' is only present in DevCraftUltimate")
    public boolean telerikTestStudioOnlyInUltimate(){
        boolean answer = false;
        for (int i = 0; i < productBundlesPage.telerikTestStudioTds.size(); i++){
            if (i == productBundlesPage.telerikTestStudioTds.size() - 1){
                answer = productBundlesPage.telerikTestStudioTds.get(i).innerHtml().contains(Constants.dotTxt);
                break;
            }
            if (productBundlesPage.telerikTestStudioTds.get(i).innerHtml().contains(Constants.dotTxt)){
                break;
            }
        }
        return answer;
    }
    @Step("validate 'UI For Jquery' is present in all offers")
    public boolean uiForJqueryInAllOffers(){
        for (int i = 0; i < productBundlesPage.uiForJqueryTds.size(); i++){
            if(!productBundlesPage.uiForJqueryTds.get(i).innerHtml().contains(Constants.dotTxt)){
                return false;
            }
        }
        return true;
    }

    @Step("validate '1 instance with 15 users' is present in Telerik Report Server")
    public ProductBundlesSteps validateTelerikReportServer(){
        productBundlesPage.telerikReportServer.shouldHave(innerText(Constants.telerikReportTxt));
        return this;
    }

    @Step("Validate Telerik Reporting is not included in DevCraftUi")
    public boolean validateTelerikReporting(){
        return !productBundlesPage.telerikReportingTds.get(0).innerHtml().contains(Constants.dotTxt)
                && productBundlesPage.telerikReportingTds.get(1).innerHtml().contains(Constants.dotTxt)
                && productBundlesPage.telerikReportingTds.get(2).innerHtml().contains(Constants.dotTxt);
    }

    @Step("validate access on demand videos")
    public boolean validateAccessOnDemandVideos(){
        for (SelenideElement element : productBundlesPage.accessToVideosTds){
            if(!element.innerHtml().contains(Constants.dotTxt)){
                return false;
            }
        }
        return true;
    }

    @Step("validate offer remain sticky after scrolling")
    public ProductBundlesSteps validateOfferNamesRemainSticky(){
        Selenide.executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        for (SelenideElement element : productBundlesPage.offerNames){
            element.shouldHave(cssValue("position", "relative"));
        }
        return this;
    }

    @Step("click buy button")
    public ProductBundlesSteps clickBuyButton(){
        productBundlesPage.buyBtn.click();
        return this;
    }
}
