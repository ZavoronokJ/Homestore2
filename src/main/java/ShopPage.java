import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends BasePage {
    public ShopPage(WebDriver driver) {
        super(driver);
    }

    public void goToPage() {
        this.driver.get("https://themes.woocommerce.com/homestore/shop/");
    }

    @FindBy(xpath = "(//a[@class='next page-numbers'][contains(text(),'→')])[1]")
    WebElement nextPageArrowButton;
//

    public void clickNextPageArrowButton() {
        nextPageArrowButton.click();
    }

    @FindBy(xpath = "(//a[@class='prev page-numbers'][contains(text(),'←')])[1]")
    WebElement previousPageArrowButton;

    public void clickPreviousArrowButton() {
        previousPageArrowButton.click();
    }


    @FindBy(css = ".page-numbers.current")
    WebElement currentPageButton;

    public String getCurrentPage() {
        return currentPageButton.getText();
    }


    @FindBy(xpath = "(//a[@class='page-numbers'][normalize-space()='2'])")
    WebElement secondPageNumberButton;


    public void clickSecondPageNumberButton() {
        secondPageNumberButton.click();
    }

    @FindBy(xpath = "(//a[@class='page-numbers'][normalize-space()='1'])")
    WebElement previousPageNumberButton;

    public void clickPreviousPageNumberButton() {
        previousPageNumberButton.click();
    }

    @FindBy(xpath = "//header[@class='woocommerce-products-header']")
    WebElement isFilterFieldClick;

    public boolean filterField() {
        return isFilterFieldClick.isDisplayed();
    }

    @FindBy(xpath = "//input[@id='woocommerce-product-search-field-0']")
    WebElement searchField;

    public void setSearchField(String Text) {
        searchField.sendKeys(Text);
    }

    @FindBy(xpath = "(//form[@role='search'])[1]")
    WebElement searchForm;

    public void submitSearchForm() {
        searchForm.submit();
    }

    @FindBy(css = ".woocommerce-result-count")
    public WebElement resultCount;

    public String getResultCountText(){
        return resultCount.getText();
    }

    @FindBy(css = ".woocommerce-info.woocommerce-no-products-found")
    public WebElement noResultMessage;

    public String getNoResultMessageText(){
        return noResultMessage.getText();
    }
}