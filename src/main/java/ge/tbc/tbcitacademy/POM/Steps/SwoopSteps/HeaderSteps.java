package ge.tbc.tbcitacademy.POM.Steps.SwoopSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.Pages.SwoopPages.HeaderPage;
import io.qameta.allure.Step;

public class HeaderSteps {
    HeaderPage headerPage = new HeaderPage();

    @Step("Go to Sport section")
    public HeaderSteps goToSportSection(){
        headerPage.sportSection.click();
        return this;
    }

    @Step("Go to {0} section")
    public HeaderSteps goToSection(String sectionName){
        headerPage.sections.filter(Condition.innerText(sectionName)).get(0).click();
        return this;
    }

    @Step("Check 'გაანაწილე 4 თვეზე' button is visible")
    public HeaderSteps checkDivideIntoFourMonthsBtn(){
        headerPage.divideIntoFourMonthsBtn.shouldBe(Condition.visible);
        return this;
    }

    @Step("Send 'ბურგერ' text to the search box")
    public HeaderSteps sendTextToSearchBox(){
        headerPage.searchBox.sendKeys(Constants.burgerTxt);
        return this;
    }

    @Step("Check suggestions contain 'ბურგერ'")
    public HeaderSteps checkSuggestions(){
        for (SelenideElement suggestion : headerPage.suggestions){
            suggestion.shouldHave(Condition.innerText(Constants.burgerTxt));
        }
        return this;
    }

    @Step("Click the first suggestion option")
    public HeaderSteps clickFirstOption(){
        headerPage.suggestions.get(0).click();
        return this;
    }

    @Step("Get the title of the first suggestion option")
    public String firstOptionTitle(){
        return headerPage.suggestions.get(0).$("div.search-result__title").getText();
    }
}
