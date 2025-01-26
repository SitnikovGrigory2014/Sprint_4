package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class MainPage {
    private final WebDriver driver;

    protected final By goButton = By.cssSelector(".Header_Button__28dPO");
    protected final By inputOrder = By.xpath(".//input[contains(@class,'Input_Input__1iN_Z')]");
    protected final By status = By.className("Header_Link__1TAG7");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public StatusPage clickOnGoButton() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(goButton));
        driver.findElement(goButton).click();
        return new StatusPage(driver);
    }

    public void typeOrderId(String orderId) {
        driver.findElement(inputOrder).sendKeys(orderId);
    }

    public void clickOnStatus() {
        driver.findElement(status).click();
    }

    public void openMainPage() {
        driver.get(EnvConfig.BASE_URL);
    }
}
