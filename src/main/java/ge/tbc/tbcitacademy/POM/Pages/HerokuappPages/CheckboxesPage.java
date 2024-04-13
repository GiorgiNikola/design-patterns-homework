package ge.tbc.tbcitacademy.POM.Pages.HerokuappPages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class CheckboxesPage {
    public ElementsCollection checkBoxes = $$("form#checkboxes input");
}
