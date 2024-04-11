package ge.tbc.tbcitacademy.POM.Steps.TelerikSteps;

import ge.tbc.tbcitacademy.POM.Pages.TelerikPages.BasePage;

public class BaseSteps {
    BasePage basePage = new BasePage();
    //This acceptCookies function works for every page
    //and i did not wanted to write it separately everywhere
    //that's why i made another class BaseSteps
    public BaseSteps acceptCookies(){
        basePage.acceptCookies.click();
        return this;
    }
}
