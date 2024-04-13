package ge.tbc.tbcitacademy.POM.Steps.TelerikSteps;

import ge.tbc.tbcitacademy.POM.Pages.TelerikPages.NavigationPage;

public class NavigationSteps extends BaseSteps{
    NavigationPage navigationPage = new NavigationPage();
    public NavigationSteps goToPricingPage(){
        navigationPage
                .pricingBtn
                .click();
        return this;
    }
}
