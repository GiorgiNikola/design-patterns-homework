package ge.tbc.tbcitacademy.POM.Pages.TelerikPages;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.POM.Data.Constants;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class IndividualProductsPage {
    public SelenideElement individualProductsBtn = $x("//span[text()='Individual Products']"),
    offer1 = $("div[data-opti-expid='Kendo UI']"),
    offer2 = $("div[data-opti-expid='KendoReact']"),
    offer1Ninja = $("img[title='Kendo Ui Ninja']"),
    offer2Ninja = $("img[title='Kendo React Ninja']"),
    dropDown1 = $x("//div[@class='Dropdown u-pr u-zi1 js-select-pricing-item u-ha u-mb1']/a"),
    dropDown2 = $x("//div[@id='ContentPlaceholder1_C714_Col01']//div[@class='Dropdown u-pr u-zi1 u-ha u-mb1 js-select-pricing-item']/a"),
    kendoReactPrice = $("div[id='ContentPlaceholder1_C714_Col01'] span[class='js-price']"),
    kendoUiPrice = $("div[data-opti-expid='Kendo UI'] span[class='js-price']");
}
