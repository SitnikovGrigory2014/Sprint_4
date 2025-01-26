package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class SampleWebTest {
    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    public void openMainPage() throws Exception {
        WebDriver driver = factory.getDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        driver.findElement(By.className("Header_Link__1TAG7")).click();

        driver.findElement(By.xpath(".//input[contains(@class,'Input_Input__1iN_Z')]")).sendKeys("123");

        By goButton = By.cssSelector(".Header_Button__28dPO");
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(goButton));
        driver.findElement(goButton).click();

        By notFoundImage = By.cssSelector("img[alt='Not found']");

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(notFoundImage));

        assertTrue(driver.findElement(notFoundImage).isDisplayed());
    }
}
