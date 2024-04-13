package ge.tbc.tbcitacademy.POM.Pages.SwoopPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HeaderPage {
    public ElementsCollection sections = $$(".Menus li"),
    suggestions = $$("a.search-result");
    public SelenideElement sportSection = $("div.Menus")
            .$(byAttribute("href","/category/110/sporti")),
    divideIntoFourMonthsBtn = $(".MenuSponsored.TbcGanacileba"),
            searchBox = $(".search-box input[class='reheadersearch']");
}
