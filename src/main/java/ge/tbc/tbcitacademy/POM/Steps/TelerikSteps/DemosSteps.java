package ge.tbc.tbcitacademy.POM.Steps.TelerikSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.Pages.TelerikPages.DemosPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.cssValue;

public class DemosSteps extends BaseSteps{
    DemosPage demosPage = new DemosPage();

    @Step("Validate purple overlay appears while hovering")
    public DemosSteps validatePurpleOverlay(){
        for (SelenideElement element : demosPage.webHoverElements){
            element.scrollTo();
            element.hover();
            element.shouldHave(Condition.cssValue("background-color", "rgba(40, 46, 137, 0.75)"));
        }
        return this;
    }

    @Step("Validate 'UI For Vue Demos' appear while hovering")
    public DemosSteps validateUiForVueDemos(){
        demosPage.hoverElement.scrollIntoView(false);
        demosPage.hoverElement.hover();
        demosPage.innerElement.shouldBe(Condition.appear);
        return this;
    }

    @Step("return boolean whether Telerik UI is available on google play, apple store and microsoft store")
    public boolean validateTelerikUiAvailableOnStores(){
        return demosPage.mobileElement.innerHtml().contains(Constants.downloadFromApple)
        && demosPage.mobileElement.innerHtml().contains(Constants.downloadFromGoogle)
        && demosPage.mobileElement.innerHtml().contains(Constants.downloadFromMicrosoft);
    }

    @Step("validate that sections remain sticky after scroll")
    public DemosSteps validateSectionsRemainSticky(){
        Selenide.executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        for (SelenideElement element : demosPage.sectionLinks){
            element.shouldHave(cssValue("position", "static"));
        }
        return this;
    }

    @Step("validate section links work properly")
    public DemosSteps validateSectionLinks(){
        demosPage.sectionLinks.get(0).click();
        demosPage.webSection.shouldBe(appear);
        demosPage.sectionLinks.get(1).click();
        demosPage.desktopSection.shouldBe(appear);
        demosPage.sectionLinks.get(2).click();
        demosPage.mobileSection.shouldBe(appear);
        return this;
    }
}
