import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    WebDriver driver;

    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");

        driver = new ChromeDriver(options);
    }

//    @AfterEach                //sita atkomentuojam
//    void tearDown() {
//        driver.quit();
//    }
}
