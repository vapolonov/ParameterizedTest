package ru.apolonov;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import ru.apolonov.pages.KolesaPage;

public class TestBase {

    final String displayName = "Поиск на kolesa-darom.ru";

    @BeforeAll
    public static void setUpBeforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    KolesaPage kolesaPage = new KolesaPage();
}
