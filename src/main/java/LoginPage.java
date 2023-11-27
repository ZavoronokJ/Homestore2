import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToPage() {
        this.driver.get("https://themes.woocommerce.com/homestore/my-account/");
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement inputUsername;

    public void setUsername(String Username) {
        inputUsername.sendKeys(Username);
    }

    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;

    public void setPassword(String Password) {
        inputPassword.sendKeys(Password);
    }

    @FindBy(xpath = "//input[@id='rememberme']")
    WebElement inputRememberMe;

    public void checkRememberMe() {
        inputRememberMe.click();
    }

    @FindBy(css = "button[value='Log in']")
    WebElement loginButton;

    public void clickLogin() {
        loginButton.click();
    }

    @FindBy(css = "ul[role='alert']")
    WebElement alertMessage;

    public String getWarningText() {
        return alertMessage.getText();
    }

    @FindBy(xpath = "//a[normalize-space()='Lost your password?']")
    WebElement lostYourPassword;

    public void clickLostYouPassword() {
        lostYourPassword.click();
    }
}