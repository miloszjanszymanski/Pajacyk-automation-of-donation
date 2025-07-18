import org.openqa.selenium.WebDriver;

public class ContributePage {
    private final WebDriver driver;
    public ContributePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}