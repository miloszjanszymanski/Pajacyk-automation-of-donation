import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;


    private final By pajacykHelp = By.cssSelector("div.pajacyk__clickbox");
    private final By contributeButton = By.className("buttons__item--pink");
    private final By font1Button = By.className("font1");
    private final By font2Button = By.className("font2");
    private final By font3Button = By.className("font3");
    private final By mainMenu = By.id("menu-item-43");
    private final By thankYouMessage = By.xpath(".//section[contains(@class, 'pajacyk__thankyou')]//p[2]");
    private final By counter = By.xpath(".//p[contains(., 'Dziś kliknęło już')]/span");

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void go(String baseURL) {
        driver.get(baseURL);
    }

    public void clickPajacyk() {
        driver.findElement(pajacykHelp).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(thankYouMessage));
    }

    public String getThankYouMessage() {
        return driver.findElement(thankYouMessage).getText();
    }

    public void clickContribute() {
        driver.findElement(contributeButton).click();
    }

    public void setFontSize(int size) {
        switch (size) {
            case 1 -> driver.findElement(font1Button).click();
            case 2 -> driver.findElement(font2Button).click();
            case 3 -> driver.findElement(font3Button).click();
        }
    }

    public String getMainMenuFontSize() {
        return driver.findElement(mainMenu).getCssValue("font-size");
    }

    public String getTitle() {
        return driver.getTitle();
    }
    public boolean isCounterDisplayed() {
        return driver.findElement(counter).isDisplayed();
    }

    public String getCounterText() {
        return driver.findElement(counter).getText();
    }
}