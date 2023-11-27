import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


public class ShopTest extends BaseTest{

    //    1. Go to Homestore Shop page: https://themes.woocommerce.com/homestore/shop/
//2. Click page change arrow button.
//3. Click page change arrow button again."

    @Test
    @DisplayName("Page navigation with arrow button")
    public void pageChangeArrowButton() {
        ShopPage shopPage= new ShopPage(driver);
        shopPage.goToPage();
        shopPage.clickNextPageArrowButton();

        assertThat(shopPage.getCurrentPage()).isEqualTo("2");

        shopPage.clickPreviousArrowButton();

        assertThat(shopPage.getCurrentPage()).isEqualTo("1");
    }
    @Test
    @DisplayName("Page navigation with page number button")
    public void pageChangeNumberButton() {
        ShopPage shopPage = new ShopPage(driver);
        shopPage.goToPage();
        shopPage.clickSecondPageNumberButton();

        assertThat(shopPage.getCurrentPage()).isEqualTo("2");

        shopPage.clickPreviousPageNumberButton();

        assertThat(shopPage.getCurrentPage()).isEqualTo("1");
    }

    @ParameterizedTest
    @DisplayName("Searching for product")
    @CsvSource(useHeadersInDisplayName = true, textBlock = """
        word,           message
        couch,          'Showing all 2 results'
        '',             'Showing 1–16 of 21 results'
        """)
    public void searchFieldWithResult(String word, String message) {
        ShopPage shopPage = new ShopPage(driver);
        shopPage.goToPage();
        shopPage.setSearchField(word);
        shopPage.submitSearchForm();

        assertThat(shopPage.getResultCountText()).isEqualTo(message);
    }

//    Norint patikrnti ar tikrai buvo perejimas iš page 1 į page 2 galima naudoti šį work around. Atsižvelgiant į tai, kad ateityje gali būti puslapių daugiau negu 2.
//    https://stackoverflow.com/questions/21263367/webdriver-pageobject-findby-how-to-specify-xpath-with-dynamic-value

    @ParameterizedTest
    @DisplayName("Searching for product with no results")
    @CsvSource(useHeadersInDisplayName = true, textBlock = """
        word
        dog       
        """)
    public void searchFieldWithNoResult(String word) {
        ShopPage shopPage = new ShopPage(driver);
        shopPage.goToPage();
        shopPage.setSearchField(word);
        shopPage.submitSearchForm();

        assertThat(shopPage.getNoResultMessageText()).isEqualTo("No products were found matching your selection.");
    }
}