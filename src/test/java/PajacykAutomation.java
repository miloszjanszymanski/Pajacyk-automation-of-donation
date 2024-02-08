
package org.example;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class PajacykAutomation{
    WebDriver driver;
    String mainPage = "https://www.pajacyk.pl/";

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void quitDriver(){
        driver.quit();
    }

    @Test
    @DisplayName("Verifies that main page is displayed - by title")
    public void checkTitle() {
        driver.get(mainPage);
        String mainPageExpectedTitle = "Pajacyk – Pajacyk od wielu lat dożywia dzieci. Pamiętaj, że kliknięcie w brzuszek, to pierwszy krok, by pomóc dzieciom.";
        String mainPageActualTitle = driver.getTitle();
        Assertions.assertEquals(mainPageExpectedTitle,mainPageActualTitle,"Actual title is different than expected title");
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

}}