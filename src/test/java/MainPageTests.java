import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MainPageTests extends BaseTests {
    private final String mainPageExpectedTitle = "Pajacyk – Pajacyk od wielu lat dożywia dzieci. Pamiętaj, że kliknięcie w brzuszek, to pierwszy krok, by pomóc dzieciom.";
    private final String thankYouText = "Dziękujemy!!!";
    private final String expectedContributePageUrl = "https://www.pajacyk.pl/wesprzyj/";

    @Test
    @DisplayName("Verifies that main page is displayed - by title")
    public void checkTitle() {
        MainPage mainPage = new MainPage(driver, wait);
        mainPage.go(baseURL);
        Assertions.assertEquals(mainPageExpectedTitle, mainPage.getTitle(), "Actual title is different than expected title");
    }

    @Test
    @DisplayName("Verifies that after clicking on toy clown proper message is displayed")
    public void checkClickPajacykTest() {
        MainPage mainPage = new MainPage(driver, wait);
        mainPage.go(baseURL);
        mainPage.clickPajacyk();
        Assertions.assertEquals(thankYouText, mainPage.getThankYouMessage());
    }

    @Test
    @DisplayName("Verifies that after clicking on round button 'Wesprzyj' proper page is displayed")
    public void checkExternalLinks() {
        MainPage mainPage = new MainPage(driver, wait);
        mainPage.go(baseURL);
        mainPage.clickContribute();
        ContributePage contributePage = new ContributePage(driver);
        Assertions.assertEquals(expectedContributePageUrl, contributePage.getCurrentUrl(),
                "Actual contribute page is different than expected");
    }

    @Test
    @DisplayName("Test check that font size switcher is working properly")
    public void checkFontSizeSwitcher() {
        MainPage mainPage = new MainPage(driver, wait);
        mainPage.go(baseURL);
        String defaultFontSize = mainPage.getMainMenuFontSize();
        int defaultFontSizeValue = Integer.parseInt(defaultFontSize.replaceAll("px", ""));
        mainPage.setFontSize(2);
        driver.navigate().refresh();
        String newFontSize = mainPage.getMainMenuFontSize();
        int newFontSizeValue = Integer.parseInt(newFontSize.replaceAll("px", ""));
        Assertions.assertTrue(newFontSizeValue > defaultFontSizeValue, "Font size should increase");
    }

    @Test
    @DisplayName("Verifies that counter is displayed and contains numbers")

    public void testCounterIsDisplayed() {
        MainPage mainPage = new MainPage(driver, wait);
        mainPage.go(baseURL);
        mainPage.clickContribute();
        Assertions.assertTrue(mainPage.isCounterDisplayed(), "Counter should be displayed");
        String counterText = mainPage.getCounterText();
        Assertions.assertTrue(counterText.matches(".*\\d+.*"), "Counter should contain numbers");
    }
}