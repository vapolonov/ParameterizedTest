package ru.apolonov;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

public class KolesaDaromTest extends TestBase {

    @ValueSource(strings = {"Yokohama", "Nokian", "Michelin"})
    @DisplayName(displayName)
    @Tag("critical")
    @ParameterizedTest(name = "Поиск шин по бренду {0}")
    void findProductsWithValueSourceTest(String brandName) {
        kolesaPage
                .openUrl()
                .openBrandsFilter()
                .selectMarker(brandName)
                .showFilterResult()
                .shouldHaveTitleWithBrandName(brandName);
    }

    @CsvSource(value = {
            "Yokohama| Японский бренд Yokohama",
            "Nokian| Высококлассные покрышки Nokian"
    },
            delimiter = '|')
    @DisplayName(displayName)
    @Tag("critical")
    @ParameterizedTest(name = "Поиск шин по бренду {0}," +
            "проверка отображения текста {1}," +
            "проверка отображения названия бренда {0} в карточке")
    void findProductWithCsvSourceTest(String brandName, String productText) {
        kolesaPage
                .openUrl()
                .openBrandsFilter()
                .selectMarker(brandName)
                .showFilterResult()
                .shouldHaveDescriptionWithText(productText)
                .shouldHaveCardWithBrandName(brandName);
    }

    static Stream<Arguments> findProductWithMethodSourceTest() {
        return Stream.of(
                Arguments.of("Yokohama", List.of("Японский бренд Yokohama")),
                Arguments.of("Nokian", List.of("Высококлассные покрышки Nokian"))
        );
    }

    @MethodSource
    @DisplayName(displayName)
    @Tag("critical")
    @ParameterizedTest(name = "Поиск шин по бренду {0} и проверка отображения текста {1}")
    void findProductWithMethodSourceTest(String brandName, List<String> productText) {
        kolesaPage
                .openUrl()
                .openBrandsFilter()
                .selectMarker(brandName)
                .showFilterResult()
                .shouldHaveDescriptionWithText(productText.get(0));
    }

    @EnumSource(BrandName.class)
    @DisplayName(displayName)
    @Tag("critical")
    @ParameterizedTest(name = "Поиск шин по бренду {0}")
    void findProductWithEnumSourceTest(BrandName brandName) {
        kolesaPage
                .openUrl()
                .openBrandsFilter()
                .selectMarker(brandName.name())
                .showFilterResult()
                .shouldHaveTitleWithBrandName(brandName.name());
    }
}
