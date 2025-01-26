package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

import java.time.Duration;
import java.util.Objects;


public class CreateOrderPage {
    private final WebDriver driver;

    //Кнопка куки
    private final By cookieButton = By.id("rcc-confirm-button");

    //Верхняя кнопка "Заказать"
    private final By topButton = By.cssSelector(".Header_Nav__AGCXC > button:nth-child(1)");

    //Нижняя кнопка "Заказать"
    private final By bottomButton = By.cssSelector(".Button_Middle__1CSJM");

    //Поле "Имя"
    private final By nameInput = By.cssSelector(".Order_Form__17u6u > div:nth-child(1) > input:nth-child(1)");

    //Поле "Фамилия"
    private final By lastNameInput = By.cssSelector("div.Input_InputContainer__3NykH:nth-child(2) > input:nth-child(1)");

    //Поле "Адрес"
    private final By addressInput = By.cssSelector("div.Input_InputContainer__3NykH:nth-child(3) > input:nth-child(1)");

    //Поле "Станция метро"
    private final By metroInput = By.cssSelector(".select-search__input");

    //Поле "Телефон"
    private final By phoneNumberInput = By.cssSelector("div.Input_InputContainer__3NykH:nth-child(5) > input:nth-child(1)");

    //Кнопка "Далее"
    private final By nextButton = By.cssSelector(".Button_Middle__1CSJM");

    //Поле "Когда привезти самокат"
    private final By dateInput = By.cssSelector(".react-datepicker__input-container > input:nth-child(1)");

    //Поле "Срок аренды"
    private final By rentPeriodInput = By.cssSelector(".Dropdown-control");

    //Поле "Комментарий для курьера"
    private final By commentInput = By.cssSelector("div.Input_InputContainer__3NykH:nth-child(4) > input:nth-child(1)");

    //Кнопка "Заказать"
    private final By createOrderButton = By.cssSelector("button.Button_Middle__1CSJM:nth-child(2)");

    //Кнопка "Да"
    private final By yesButton = By.cssSelector("div.Order_Buttons__1xGrp:nth-child(2) > button:nth-child(2)");

    //Текст успешного оформления заказа
    private final By successMessage = By.xpath(".//div[text()='Заказ оформлен']");

    public CreateOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get(EnvConfig.BASE_URL);
    }

    public void acceptCookies() {
        waitForCookiesFloater();
        driver.findElement(cookieButton).click();
        waitForCookiesFloaterToDisappear();

    }

    private void waitForCookiesFloater() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(cookieButton));
    }

    private void waitForCookiesFloaterToDisappear() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.invisibilityOfElementLocated(cookieButton));
    }

    public CreateOrderPage open() {
        driver.get(EnvConfig.BASE_URL);

        return this;
    }

    public CreateOrderPage clickOnMakeOrderButton (String button) {
        if (Objects.equals(button, "Верхняя кнопка")){
            new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                    .until(ExpectedConditions.visibilityOfElementLocated(topButton));
            driver.findElement(topButton).click();
        } else if (Objects.equals(button, "Нижняя кнопка")) {
            new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                    .until(ExpectedConditions.visibilityOfElementLocated(bottomButton));
            driver.findElement(bottomButton).click();
        }
        return this;
    }

    public CreateOrderPage typeName(String name){
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    public CreateOrderPage typeLastName(String lastName){
        driver.findElement(lastNameInput).sendKeys(lastName);
        return this;
    }

    public CreateOrderPage typeAddress(String address){
        driver.findElement(addressInput).sendKeys(address);
        return this;
    }

    public CreateOrderPage selectMetro(String id){
        driver.findElement(metroInput).click();
        final By metroList = By.xpath(".//li[@data-index='" + id + "']");
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(metroList));
        driver.findElement(metroList).click();
        return this;
    }

    public CreateOrderPage typePhoneNumber(String phone){
        driver.findElement(phoneNumberInput).sendKeys(phone);
        return this;
    }

    public CreateOrderPage clickOnNextButton() {
        driver.findElement(nextButton).click();
        return this;
    }

    public CreateOrderPage selectDate(String id){
        driver.findElement(dateInput).click();
        driver.findElement(By.cssSelector(".react-datepicker__day--0" + id)).click();
        return this;
    }

    public CreateOrderPage selectRentPeriod(String id){
        driver.findElement(rentPeriodInput).click();
        driver.findElement(By.cssSelector("div.Dropdown-option:nth-child(" + id + ")")).click();
        return this;
    }

    public CreateOrderPage selectColor(String color){
        driver.findElement(By.cssSelector("#"+ color)).click();
        return this;
    }

    public CreateOrderPage typeComment(String comment){
        driver.findElement(commentInput).sendKeys(comment);
        return this;
    }

    public CreateOrderPage clickOnCreateOrderButton(){
        driver.findElement(createOrderButton).click();
        return this;
    }

    public CreateOrderPage clickOnYesButton(){
        driver.findElement(yesButton).click();
        return this;
    }

    public CreateOrderPage checkSuccessMessage(){
        String successMessageText = driver.findElement(successMessage).getText();
        System.out.println(successMessageText);
        assert driver.findElement(successMessage).isDisplayed();
        return this;
    }
}
