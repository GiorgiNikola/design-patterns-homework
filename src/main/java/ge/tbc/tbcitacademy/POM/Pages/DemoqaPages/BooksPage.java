package ge.tbc.tbcitacademy.POM.Pages.DemoqaPages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class BooksPage {
    public ElementsCollection books = $$(".rt-tr-group"),
    booksWithImg = $$(".rt-tr-group img");
}
