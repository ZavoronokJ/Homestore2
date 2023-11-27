import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @ParameterizedTest
    @DisplayName("Login test with invalid credentials")
    @CsvSource(useHeadersInDisplayName = true, textBlock = """
        username,            password,    message
        katinukai@gmail.com, katinukai,   'Unknown email address. Check again or try your username.'
        katinukai123,        katinukai,   'Error: The username katinukai123 is not registered on this site. If you are unsure of your username, try your email address instead.'
        '',                  katinukai,   'Error: Username is required.'
        katinukai123,        '',          'Error: The password field is empty.'
        '',                  '',          'Error: Username is required.'
        """)
    public void loginTestWithInvalidCredentials(String username, String password, String message) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToPage();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.checkRememberMe();
        loginPage.clickLogin();

        assertThat(loginPage.getWarningText())
                .isEqualTo(message);
    }

    @ParameterizedTest
    @DisplayName("Lost password test with invalid credentials")
    @CsvSource(useHeadersInDisplayName = true, textBlock = """
        username,              message
        katinukai123,          'Invalid username or email.'
        katinukai@gmail.com,   'Invalid username or email.'
        '',                    'Enter a username or email address.'
        """)
    public void loginTestResetPassword(String username, String message) {
        LoginPage loginPage = new LoginPage(driver);
        LostPasswordPage lostPasswordPage = new LostPasswordPage(driver);

        loginPage.goToPage();
        loginPage.clickLostYouPassword();

        lostPasswordPage.setUsername(username);
        lostPasswordPage.clickResetPassword();

        String warningText = lostPasswordPage.getWarningText();
        assertTrue(warningText.equals("You have exceeded the password reset limit. Please wait a few minutes and try again.") || warningText.equals(message));
    }
}