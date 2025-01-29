package praktikum;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.pages.FaqPage;

@RunWith(Parameterized.class)
public class FaqTest {
    private final String itemId;

    @ClassRule
    public static DriverRule driverRule = new DriverRule();

    public FaqTest(String itemId) {
        this.itemId = itemId;
    }

    @BeforeClass
    public static void closeCookies() {
        new FaqPage(driverRule.getDriver())
                .open()
                .acceptCookies();
    }

    @Parameterized.Parameters
    public static Object[][] faqData() {
        return new Object[][]{
                {"0"},
                {"1"},
                {"2"},
                {"3"},
                {"4"},
                {"5"},
                {"6"},
                {"7"}
        };
    }

    @Test
    public void clickOnFaqItems() {
        new FaqPage(driverRule.getDriver())
                .checkAnswerIsInvisible(itemId)
                .clickOnQuestion(itemId)
                .waitForAnswer(itemId);
    }
}
