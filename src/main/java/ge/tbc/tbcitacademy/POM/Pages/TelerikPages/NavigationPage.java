package ge.tbc.tbcitacademy.POM.Pages.TelerikPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class NavigationPage {
    public SelenideElement pricingBtn = $x("//a[@class='TK-Menu-Item-Link'][text()='Pricing']");
}
