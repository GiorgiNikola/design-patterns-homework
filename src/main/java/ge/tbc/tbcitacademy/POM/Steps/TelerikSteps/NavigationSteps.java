package ge.tbc.tbcitacademy.POM.Steps.TelerikSteps;

import ge.tbc.tbcitacademy.POM.Pages.TelerikPages.NavigationPage;
import io.qameta.allure.Step;

public class NavigationSteps extends BaseSteps{
    NavigationPage navigationPage = new NavigationPage();
    @Step("go to pricing page")
    public NavigationSteps goToPricingPage(){
        navigationPage
                .pricingBtn
                .click();
        return this;
    }
}
