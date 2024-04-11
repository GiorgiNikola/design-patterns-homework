package ge.tbc.tbcitacademy.POM.Steps.SwoopSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.Pages.SwoopPages.HeaderPage;

public class HeaderSteps {
    HeaderPage headerPage = new HeaderPage();
    public HeaderSteps goToSportSection(){
        headerPage.sportSection.click();
        return this;
    }

    public HeaderSteps goToSection(String sectionName){
        headerPage.sections.filter(Condition.innerText(sectionName)).get(0).click();
        return this;
    }

    public HeaderSteps checkDivideIntoFourMonthsBtn(){
        headerPage.divideIntoFourMonthsBtn.shouldBe(Condition.visible);
        return this;
    }

    public HeaderSteps sendTextToSearchBox(){
        headerPage.searchBox.sendKeys(Constants.burgerTxt);
        return this;
    }

    public HeaderSteps checkSuggestions(){
        for (SelenideElement suggestion : headerPage.suggestions){
            suggestion.shouldHave(Condition.innerText(Constants.burgerTxt));
        }
        return this;
    }

    public HeaderSteps clickFirstOption(){
        headerPage.suggestions.get(0).click();
        return this;
    }

    public String firstOptionTitle(){
        return headerPage.suggestions.get(0).$("div.search-result__title").getText();
    }
}
