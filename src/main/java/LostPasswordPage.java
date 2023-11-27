import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LostPasswordPage extends BasePage {
    public LostPasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#user_login")
    WebElement inputUsername;

    public void setUsername(String Username) {
        inputUsername.sendKeys(Username);
    }

    @FindBy(xpath = "//button[normalize-space()='Reset password']")
    WebElement resetPassword;

    public void clickResetPassword() {
        resetPassword.click();
    }

    @FindBy(css = "ul[role='alert'] li")
    WebElement alertMessage;

    public String getWarningText() {
        return alertMessage.getText();
    }
}
