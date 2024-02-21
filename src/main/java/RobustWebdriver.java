import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RobustWebDriver implements WebDriver {

    WebDriver originalWebDriver;

    RobustWebDriver(WebDriver webDriver) {
        this.originalWebDriver = webDriver;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return originalWebDriver.findElements(by)
                .stream().map(e -> new RobustWebElement(e, by, this))
                .collect(Collectors.toList());
    }

    @Override
    public WebElement findElement(By by) {
        return new RobustWebElement(originalWebDriver.findElement(by), by, this);
    }

}