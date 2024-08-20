import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTests {
    protected WebDriver driver;
    protected ActionBot bot;

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-search-engine-choice-screen");

        driver = new ChromeDriver(options);
        String baseURL = "https://www.pajacyk.pl";
        bot = new ActionBot(driver, baseURL);
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }
}
