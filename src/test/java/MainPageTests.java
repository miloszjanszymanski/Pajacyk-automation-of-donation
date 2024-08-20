import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.*;
import java.lang.Thread;
import java.time.Duration;


public class MainPageTests extends BaseTests {



    @Test
    @DisplayName("Verifies that main page is displayed - by title")
    public void checkTitle() {
        bot.go();
        String mainPageExpectedTitle = "Pajacyk – Pajacyk od wielu lat dożywia dzieci. Pamiętaj, że kliknięcie w brzuszek, to pierwszy krok, by pomóc dzieciom.";
        String title = driver.getTitle();
        Assertions.assertEquals(mainPageExpectedTitle, title, "Actual title is different than expected title");
    }
    @Test
    @DisplayName("Verifies that after clicking on toy clown proper message is displayed")
    public void checkClickPajacyk() {
        bot.go();
        WebElement donateButton = driver.findElement(By.className("pajacyk__clickbox"));
        donateButton.click();
        try{
            Thread.sleep(900000);
        }
        catch (Exception e) {

            // catching the exception
            System.out.println(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        WebElement element = driver.findElement(By.className("pajacyk__thankyou"));
        WebElement p1Element = element.findElement(By.className("p2"));
        Assertions.assertEquals("dziękujemy :)", p1Element.getText());
    }
    @Test
    @DisplayName("Verifies that after clicking on toy clown proper message is displayed")
    public void checkClickPajacykTest() {
        bot.go();
        WebElement donateButton = driver.findElement(By.className("pajacyk__clickbox"));
        donateButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        WebElement element = driver.findElement(By.className("pajacyk__thankyou"));
        WebElement p1Element = element.findElement(By.className("p2"));
        Assertions.assertEquals("dziękujemy :)", p1Element.getText());
    }

}