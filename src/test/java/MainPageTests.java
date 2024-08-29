import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class MainPageTests extends BaseTests {

    String mainPageExpectedTitle = "Pajacyk – Pajacyk od wielu lat dożywia dzieci. Pamiętaj, że kliknięcie w brzuszek, to pierwszy krok, by pomóc dzieciom.";
    String thankYouClass = "pajacyk__thankyou";
    String divergentTitle = "Actual title is different than expected title";
    String thankYouXpath = ".//section[contains(@class, 'pajacyk__thankyou')]//p[2]";
    String thankYouText = "Dziękujemy!!!";

    @Test
    @DisplayName("Verifies that main page is displayed - by title")
    public void checkTitle() {
        bot.go();

        String title = driver.getTitle();
        Assertions.assertEquals(mainPageExpectedTitle, title, divergentTitle);
    }

    @Test
    @DisplayName("Verifies that after clicking on toy clown proper message is displayed")
    public void checkClickPajacykTest() {
        bot.go();
        WebElement donateButton = driver.findElement(By.className(thankYouClass));
        donateButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(thankYouClass)));
        WebElement thankYouLocator = driver.findElement(By.xpath(thankYouXpath));
        System.out.println(thankYouLocator.getText());
        Assertions.assertEquals("Dziękujemy!!!", thankYouLocator.getText());
    }
    @Test
    @DisplayName("Verifies that after clicking on round button 'Wesprzyj' and on the bottom proper page is displayed")
    public void checkExternalLinks() {
        bot.go();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        final WebElement contributeButton = driver.findElement(By.className("buttons__item--pink"));
        contributeButton.click();
        String expectedContributePageUrl = "https://www.pajacyk.pl/wesprzyj/";
        String actualContributePageUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedContributePageUrl, actualContributePageUrl, "Actual contribute page is different than expected");
    }
    @Test
    @DisplayName("Test check that font size switcher is working properly")
    public void checkFontSizeSwitcher() {
        bot.go();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement fontSizeButton1 = driver.findElement(By.className("font1"));
        WebElement fontSizeButton2 = driver.findElement(By.className("font2"));
        WebElement fontSizeButton3 = driver.findElement(By.className("font3"));
        WebElement mainPageBarFont = driver.findElement(By.id("menu-item-43"));

        //check that default font size is the smallest
        String defaultFontSize = mainPageBarFont.getCssValue("font-size");
        int defaultEditedFontSize = Integer.parseInt(defaultFontSize.replaceAll("px", ""));
        System.out.println(defaultEditedFontSize);
        fontSizeButton2.click();
        driver.navigate().refresh();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        String xxx = mainPageBarFont.getCssValue("font-size");
        int mediumEditedFontSize = Integer.parseInt(xxx.replaceAll("px", ""));
        System.out.println(mediumEditedFontSize);

    }

    }