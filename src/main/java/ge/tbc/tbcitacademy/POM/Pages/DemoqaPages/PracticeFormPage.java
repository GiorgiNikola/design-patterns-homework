package ge.tbc.tbcitacademy.POM.Pages.DemoqaPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PracticeFormPage {
    public SelenideElement firstNameBox = $("#firstName"),
    lastNameBox = $("#lastName"),
    maleBtn = $("label[for='gender-radio-1']"),
    femaleBtn = $("label[for='gender-radio-2']"),
    otherBtn = $("label[for='gender-radio-3']"),
    mobileNumberBox = $("#userNumber"),
    submitBtn = $("#submit"),
    studentName = $x("//td[normalize-space()='Student Name']");
}
