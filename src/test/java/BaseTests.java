import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

public class BaseTests {
    protected WebDriver driver;
    protected ActionBot bot;
    WebDriverWait wait;
    @BeforeEach
    public void setup() {

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.addArguments("--disable-search-engine-choice-screen");
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));





        String baseURL = "https://www.pajacyk.pl";
        bot = new ActionBot(driver, baseURL);

    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

}
