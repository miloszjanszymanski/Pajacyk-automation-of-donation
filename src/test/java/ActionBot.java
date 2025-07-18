import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionBot {
    protected final WebDriver driver;
    private final String baseURL;

    public ActionBot(WebDriver driver, String baseURL) {
        this.driver = driver;
        this.baseURL = baseURL;
    }
    public void go() {
        driver.get(baseURL);
    }
}