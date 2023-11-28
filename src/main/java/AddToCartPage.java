import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCartPage extends BasePage {

    public AddToCartPage(WebDriver driver) {
        super(driver);
    }

    public void goToPage() {
        this.driver.get("https://themes.woocommerce.com/homestore/shop/");
    }

    @FindBy(xpath = "//li[contains(@class, 'product')][2]//a[contains(@class, 'add_to_cart_button')]")
    WebElement addToCartButton;

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    @FindBy(xpath = "//a[@title='View cart']")
    WebElement productViewCartButton;

    public void clickProductViewCartButton() {
        productViewCartButton.click();
    }

    public void waitForViewCartButton() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='View cart']")));
    }

    @FindBy(xpath = "//li[contains(@class, 'product')][2]//*[contains(@class, 'price')]")
    WebElement productPrice;

    public String getProductPriceText() {
        return productPrice.getText();
    }

    @FindBy(xpath = "//a[@title='View your shopping cart']//span[@class='woocommerce-Price-amount amount']")
    WebElement headerCartPrice;

    public String getHeaderCartPriceText() {
        return headerCartPrice.getText();
    }

    @FindBy(xpath = "//*[@id='site-header-cart']//*[contains(@class, 'count')]")
    WebElement headerCartItemAmount;

    public String getHeaderCartItemAmountText() {
        return headerCartItemAmount.getText();
    }

    public void clickHeaderCartItemAmountText() {
         headerCartItemAmount.click();
    }

    public void hoverCart() {
        WebElement elementToHover = driver.findElement(By.id("site-header-cart"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
    }

    @FindBy(xpath = "//ul[@id='site-header-cart']//li[contains(@class,'woocommerce-mini-cart-item')]")
    WebElement headerCartFirstProduct;

    public String getHeaderCartFirstProductText() {
        return headerCartFirstProduct.getText();
    }

    @FindBy(xpath = "//ul[@id='site-header-cart']//span[@class='woocommerce-Price-amount amount']")
    WebElement headerProductSubtotal;

    public String getHeaderProductSubtotalText() {
        return headerProductSubtotal.getText();
    }

    @FindBy(xpath = "//li[contains(@class, 'product')][2]//*[contains(@class, 'woocommerce-loop-product__title')]")
    WebElement productName;

    public String getProductNameText() {
        return productName.getText();
    }

    @FindBy(xpath = "//ul[@id='site-header-cart']//a[normalize-space()='View cart']")
    WebElement headerCartViewButton;

    @FindBy(xpath = "//ul[@id='site-header-cart']//a[normalize-space()='Checkout']")
    WebElement headerCheckOutButton;

    @FindBy(css = ".entry-title")
    WebElement productCartPage;

    public String getProductCartPage() {
        return productCartPage.getText();
    }
}