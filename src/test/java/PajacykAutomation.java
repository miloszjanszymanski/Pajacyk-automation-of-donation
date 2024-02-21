
package org.example;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class PajacykAutomation {
    WebDriver driver;
    String mainPage = "https://www.pajacyk.pl/";

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

    @Test
    @DisplayName("Verifies that main page is displayed - by title")
    public void checkTitle() {
        driver.get(mainPage);
        String mainPageExpectedTitle = "Pajacyk – Pajacyk od wielu lat dożywia dzieci. Pamiętaj, że kliknięcie w brzuszek, to pierwszy krok, by pomóc dzieciom.";
        String mainPageActualTitle = driver.getTitle();
        Assertions.assertEquals(mainPageExpectedTitle, mainPageActualTitle, "Actual title is different than expected title");
    }

    @Test
    @DisplayName("Verifies that after clicking on toy clown proper message is displayed")
    public void checkClickPajacyk() {
        driver.get(mainPage);
        WebElement donateButton = driver.findElement(By.className("pajacyk__clickbox"));
        donateButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        WebElement element = driver.findElement(By.className("pajacyk__thankyou"));
        WebElement p1Element = element.findElement(By.className("p2"));
        Assertions.assertEquals("dziękujemy :)", p1Element.getText());
    }

    @Test
    @DisplayName("Verifies that after clicking on round button 'Wesprzyj' and on the bottom proper page is displayed")
    public void checkExternalLinks() {
        driver.get(mainPage);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        final WebElement contributeButton = driver.findElement(By.className("buttons__item--pink"));
        contributeButton.click();
        String expectedContributePageUrl = "https://www.pajacyk.pl/wesprzyj/";
        String actualContributePageUrl = driver.getCurrentUrl();
        ;
        Assertions.assertEquals(expectedContributePageUrl, actualContributePageUrl, "Actual contribute page is different than expected");
    }

    @Test
    @DisplayName("Test check that font size switcher is working properly")
    public void checkFontSizeSwitcher() {
        driver.get(mainPage);
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



//        String expectedContributePageUrl = "https://www.pajacyk.pl/wesprzyj/";
//        String actualContributePageUrl = driver.getCurrentUrl();
//        Assertions.assertEquals(expectedContributePageUrl, actualContributePageUrl, "Actual contribute page is different than expected");
    }
    //element_present = exprected_conditions.presence_of_element_located((By.XPATH, "//[@id='myDiv']"))


}
