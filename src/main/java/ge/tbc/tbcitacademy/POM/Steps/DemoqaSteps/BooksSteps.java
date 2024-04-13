package ge.tbc.tbcitacademy.POM.Steps.DemoqaSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.POM.Data.Constants;
import ge.tbc.tbcitacademy.POM.Pages.DemoqaPages.BooksPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.image;
import static com.codeborne.selenide.Selenide.$;

public class BooksSteps {
    BooksPage booksPage = new BooksPage();
    @Step("Filter books by publisher and title")
    public BooksSteps filterBooks(){
        ElementsCollection filteredBooks = booksPage.books
                .filterBy(Condition.innerText(Constants.publisher))
                .filterBy(Condition.partialText(Constants.innerText));
        return this;
    }

    @Step("Validate book images are displayed")
    public BooksSteps validateBookImages(){
        for (SelenideElement book : booksPage.booksWithImg){
            book.shouldBe(image);
        }
        return this;
    }

    @Step("Find specific books by publisher and title")
    public ElementsCollection findSpecificBooks(){
        return  $(".rt-tbody")
                .findAll(".rt-tr-group")
                .filterBy(Condition.innerText(Constants.publisher))
                .filterBy(Condition.partialText(Constants.innerText));
    }
}
