import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTests {
    protected WebDriver driver;
    protected ActionBot bot;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        String baseURL = "https://www.pajacyk.pl";
        bot = new ActionBot(driver, baseURL);
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }
}
