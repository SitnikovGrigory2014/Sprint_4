package praktikum;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.pages.CreateOrderPage;

@RunWith(Parameterized.class)
public class CreateOrderTest {
    private final String name;
    private final String lastname;
    private final String address;
    private final String metroId;
    private final String phone;
    private final String day;
    private final String rentPeriod;
    private final String color;
    private final String comment;
    private final String button;

    @ClassRule
    public static DriverRule driverRule = new DriverRule();


    public CreateOrderTest(String button,
                           String name,
                           String lastname,
                           String address,
                           String metroId,
                           String phone,
                           String day,
                           String rentPeriod,
                           String color,
                           String comment) {
        this.button = button;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.metroId = metroId;
        this.phone = phone;
        this.day = day;
        this.rentPeriod = rentPeriod;
        this.color = color;
        this.comment = comment;
    }

    @BeforeClass
    public static void closeCookies() {
        new CreateOrderPage(driverRule.getDriver())
                .open()
                .acceptCookies();
    }

    @Parameterized.Parameters
    public static Object[][] faqData() {
        return new Object[][]{
                {"Верхняя кнопка",
                        "Иван",
                        "Иванов",
                        "г.Москва, ул. Песчаная, д.31",
                        "0",
                        "79171112233",
                        "20",
                        "1",
                        "black",
                        "Коммент"},
                {"Нижняя кнопка",
                        "Денис",
                        "Денисов",
                        "г.Москва, ул. Песчаная, д.33",
                        "3",
                        "79172223344",
                        "23",
                        "2",
                        "grey",
                        "Коммент"}
        };
    }

    @Test
    public void createOrder() {
        new CreateOrderPage(driverRule.getDriver())
                .clickOnMakeOrderButton(button)
                .typeName(name)
                .typeLastName(lastname)
                .typeAddress(address)
                .selectMetro(metroId)
                .typePhoneNumber(phone)
                .clickOnNextButton()
                .selectDate(day)
                .selectRentPeriod(rentPeriod)
                .selectColor(color)
                .typeComment(comment)
                .clickOnCreateOrderButton()
                .clickOnYesButton()
                .checkSuccessMessage().openMainPage();
    }

}
