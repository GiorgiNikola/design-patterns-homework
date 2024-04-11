package ge.tbc.tbcitacademy.POM.Steps.TelerikSteps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.Pages.TelerikPages.ProductBundlesPage;

import static com.codeborne.selenide.Condition.*;

public class ProductBundlesSteps extends BaseSteps{
    ProductBundlesPage productBundlesPage = new ProductBundlesPage();
    public ProductBundlesSteps mockingSolutionNotInUI(){
        for (SelenideElement element : productBundlesPage.uiFeatures){
            element.shouldNotHave(text(Constants.mockingSolutionTxt));
        }
        return this;
    }

    public ProductBundlesSteps issueEscalationOnlyInUltimate(){
        productBundlesPage.ultimateSupport.shouldHave(partialText(Constants.issueEscalation));
        productBundlesPage.completeSupport.shouldNotHave(partialText(Constants.issueEscalation));
        productBundlesPage.uiSupport.shouldNotHave(partialText(Constants.issueEscalation));
        return this;
    }

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

    public boolean uiForJqueryInAllOffers(){
        for (int i = 0; i < productBundlesPage.uiForJqueryTds.size(); i++){
            if(!productBundlesPage.uiForJqueryTds.get(i).innerHtml().contains(Constants.dotTxt)){
                return false;
            }
        }
        return true;
    }

    public ProductBundlesSteps validateTelerikReportServer(){
        productBundlesPage.telerikReportServer.shouldHave(innerText(Constants.telerikReportTxt));
        return this;
    }

    public boolean validateTelerikReporting(){
        return !productBundlesPage.telerikReportingTds.get(0).innerHtml().contains(Constants.dotTxt)
                && productBundlesPage.telerikReportingTds.get(1).innerHtml().contains(Constants.dotTxt)
                && productBundlesPage.telerikReportingTds.get(2).innerHtml().contains(Constants.dotTxt);
    }

    public boolean validateAccessOnDemandVideos(){
        for (SelenideElement element : productBundlesPage.accessToVideosTds){
            if(!element.innerHtml().contains(Constants.dotTxt)){
                return false;
            }
        }
        return true;
    }

    public ProductBundlesSteps validateOfferNamesRemainSticky(){
        Selenide.executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        for (SelenideElement element : productBundlesPage.offerNames){
            element.shouldHave(cssValue("position", "relative"));
        }
        return this;
    }

    public ProductBundlesSteps clickBuyButton(){
        productBundlesPage.buyBtn.click();
        return this;
    }
}
