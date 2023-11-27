import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddToCartTest extends BaseTest{

    @Test
    @DisplayName("Add product to cart functionality")
    public void addToCartButton() {
        AddToCartPage addToCartPage= new AddToCartPage(driver);
        addToCartPage.goToPage();
        addToCartPage.clickAddToCartButton();
        addToCartPage.waitForViewCartButton();

        assertTrue(addToCartPage.addToCartButton.isDisplayed());
    }

    @Test
    @DisplayName("Add product to header cart")
    public void headerCart() {
        AddToCartPage addToCartPage = new AddToCartPage(driver);
        addToCartPage.goToPage();
        addToCartPage.clickAddToCartButton();
        String price = addToCartPage.getProductPriceText();

        addToCartPage.waitForViewCartButton();

        assertThat(addToCartPage.getHeaderCartPriceText()).isEqualTo(price);
        assertThat(addToCartPage.getHeaderCartItemAmountText()).isEqualTo("1 item");
    }

    @Test
    @DisplayName("Header cart details")
    public void headerCartDetails() {
        AddToCartPage addToCartPage = new AddToCartPage(driver);
        addToCartPage.goToPage();
        addToCartPage.clickAddToCartButton();
        String price = addToCartPage.getProductPriceText();
        String title = addToCartPage.getProductNameText();
        addToCartPage.waitForViewCartButton();
        addToCartPage.hoverCart();


        assertThat(addToCartPage.getHeaderCartFirstProductText()).isEqualTo("×\n" + title + "\n1 × " + price);
        assertThat(addToCartPage.getHeaderProductSubtotalText()).isEqualTo(price);
        assertTrue(addToCartPage.headerCartViewButton.isDisplayed());
        assertTrue(addToCartPage.headerCheckOutButton.isDisplayed());
    }
}
