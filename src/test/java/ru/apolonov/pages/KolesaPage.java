package ru.apolonov.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class KolesaPage {

    private final ElementsCollection makers = $$(".kd-checkbox");

    public KolesaPage openUrl() {
        open("https://kolesa-darom.ru/catalog/avto/shiny/");
        return this;
    }

    public KolesaPage openBrandsFilter() {
        $(".kd-producers-filter__expand-trigger").click();
        return this;
    }

    public KolesaPage selectMarker(String value) {
        makers.findBy(text(value)).click();
        return this;
    }

    public KolesaPage showFilterResult() {
        $(".kd-filter__result-link").click();
        return this;
    }

    public KolesaPage shouldHaveTitleWithBrandName(String value) {
        $(".catalog__title").shouldHave(text(value));
        return this;
    }

    public KolesaPage shouldHaveDescriptionWithText(String value) {
        $(".brand-info__text").shouldHave(text(value));
        return this;
    }

    public KolesaPage shouldHaveCardWithBrandName(String value) {
        $(".product-card__model-name").shouldHave(text(value));
        return this;
    }
}
