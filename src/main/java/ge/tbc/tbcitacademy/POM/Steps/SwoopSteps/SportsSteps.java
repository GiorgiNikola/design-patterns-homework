package ge.tbc.tbcitacademy.POM.Steps.SwoopSteps;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.POM.Pages.SwoopPages.SportsPage;
import io.qameta.allure.Step;

import java.util.concurrent.atomic.AtomicInteger;

import static com.codeborne.selenide.Condition.innerText;

public class SportsSteps {
    SportsPage sportsPage = new SportsPage();

    @Step("Get the actual price for '{0}' offer")
    public int returnActualPrice(String offerName) {
        AtomicInteger atomicExpectedPrice = new AtomicInteger(Integer.MAX_VALUE);
        sportsPage.offers.filterBy(innerText(offerName))
                .get(0).$$(".deal-voucher-price").forEach(e -> {
                    if (!e.getText().isBlank()) {
                        int price = Integer.parseInt(e.getText().trim().replaceAll("[^\\d.]", ""));
                        // intellij indicated to use AtomicInteger, and it works fine.
                        if (price < atomicExpectedPrice.get()) {
                            atomicExpectedPrice.set(price);
                        }
                    }
                });
        return atomicExpectedPrice.get();
    }

    @Step("Accept cookie")
    public SportsSteps acceptCookie() {
        sportsPage.acceptCookieBtn.click();
        return this;
    }

    @Step("Click on '{0}' offer")
    public SportsSteps clickOffer(String offerName) {
        SelenideElement offer = sportsPage.offers.filterBy(innerText(offerName)).get(0);
        offer
                .scrollTo()
                .click();
        return this;
    }
}
