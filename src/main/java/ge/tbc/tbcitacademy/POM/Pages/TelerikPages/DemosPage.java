package ge.tbc.tbcitacademy.POM.Pages.TelerikPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class DemosPage {
    public SelenideElement hoverElement = $(byTitle("Kendo Ui")).parent(),
    innerElement = hoverElement.$(byText("UI for Vue demos")),
    mobileElement = $(byTitle("Telerik UI for Xamarin Demos Overview")).ancestor(".row u-mb8"),
    webSection = $(byTitle("Kendo Ui")).ancestor(".row u-mb8"),
    desktopSection = $(byTitle("winui-product-thumb")).ancestor(".row u-mb8"),
    mobileSection = $(byTitle("Telerik UI for Xamarin Demos Overview")).ancestor(".row u-mb8");
    public ElementsCollection webHoverElements = $(byTitle("Kendo Ui"))
            .ancestor(".row u-mb8")
            .$$(".HoverImg"),
    desktopElements = $(byTitle("winforms"))
            .ancestor(".row u-mb8")
            .$$(".sf_colsIn"),
    filteredDesktopElements = desktopElements
            .filter(Condition.attributeMatching("title", "Get It from Microsoft")),
    sectionLinks = $$x("//div[@class='container']//a");
}
