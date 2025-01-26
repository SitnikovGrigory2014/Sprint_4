package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.pages.MainPage;

public class SampleWebTest {
    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    public void openMainPage() throws Exception {
        WebDriver driver = factory.getDriver();

        var mainPage = new MainPage(driver);

        mainPage.openMainPage();

        mainPage.clickOnStatus();

        String invalidId = "123";
        mainPage.typeOrderId(invalidId);

        var statusPage = mainPage.clickOnGoButton();

        statusPage.checkNotFoundMessage();
    }
}
