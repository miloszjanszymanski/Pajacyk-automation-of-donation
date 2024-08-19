import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainPageTests extends BaseTests {

    @Test
    @DisplayName("Verifies that main page is displayed - by title")
    public void checkTitle() {
        bot.go();
        String mainPageExpectedTitle = "Pajacyk – Pajacyk od wielu lat dożywia dzieci. Pamiętaj, że kliknięcie w brzuszek, to pierwszy krok, by pomóc dzieciom.";
        String title = driver.getTitle();
        Assertions.assertEquals(mainPageExpectedTitle, title, "Actual title is different than expected title");
    }

}