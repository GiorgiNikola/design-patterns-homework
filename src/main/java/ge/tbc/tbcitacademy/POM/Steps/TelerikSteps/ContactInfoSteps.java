package ge.tbc.tbcitacademy.POM.Steps.TelerikSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.Pages.TelerikPages.ContactInfoPage;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;

public class ContactInfoSteps {
    ContactInfoPage contactInfoPage = new ContactInfoPage();

    public ContactInfoSteps fillTheForm(){
        contactInfoPage.firstName.sendKeys(Constants.fullName);
        contactInfoPage.lastName.sendKeys(Constants.lastName);
        contactInfoPage.email.sendKeys(Constants.myEmail);
        contactInfoPage.company.sendKeys(Constants.companyName);
        contactInfoPage.phone.sendKeys(Constants.myPhone);
        contactInfoPage.address.sendKeys(Constants.currentAddress);
        contactInfoPage.countrySelect.click();
        contactInfoPage.options.filter(Condition.text(Constants.myCountry)).get(0).click();
        contactInfoPage.city.sendKeys(Constants.permanentAddress);
        contactInfoPage.postalCode.sendKeys(Constants.postalCode);
        return this;
    }

    public ContactInfoSteps clickGoBackButton(){
        contactInfoPage.backBtn.click();
        return this;
    }

    public ContactInfoSteps validateInfoIsStillPresent(){
        contactInfoPage.firstName.shouldHave(Condition.value(Constants.fullName));
        contactInfoPage.lastName.shouldHave(Condition.value(Constants.lastName));
        contactInfoPage.email.shouldHave(Condition.value(Constants.myEmail));
        contactInfoPage.company.shouldHave(Condition.value(Constants.companyName));
        contactInfoPage.phone.shouldHave(Condition.value(Constants.myPhone));
        contactInfoPage.address.shouldHave(Condition.value(Constants.currentAddress));
        contactInfoPage.country.shouldHave(value(Constants.myCountry));
        contactInfoPage.city.shouldHave(Condition.value(Constants.permanentAddress));
        contactInfoPage.postalCode.shouldHave(value(Constants.postalCode));
        return this;
    }

    public ContactInfoSteps clickContinueButton(){
        contactInfoPage.continueBtn.click();
        return this;
    }
}
