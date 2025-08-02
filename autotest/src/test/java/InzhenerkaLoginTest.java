import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;
import com.codeborne.selenide.Configuration;

public class InzhenerkaLoginTest {
    public static void main(String[] args) {
        Configuration.browser = "edge";
        System.setProperty("webdriver.edge.driver", "C:\\Users\\admin\\Desktop\\autotest\\edgedriver_win64\\msedgedriver.exe");

        open("http://qa-stand-login.inzhenerka.tech/login");

        $("#username").shouldBe(Condition.visible).setValue("admin");
        $("[name='password']").shouldBe(Condition.visible).setValue("admin123");
        $(".loginClass").shouldBe(Condition.visible).click();

        // Проверяем, что появилось приветствие "Привет, admin"
        $("body").shouldHave(Condition.text("Привет, admin"));

        // Кликаем на кнопку "Выход"
        $(byText("Выйти")).shouldBe(Condition.visible).click();

        // Проверяем, что снова на странице логина
        $("#username").shouldBe(Condition.visible);

        closeWebDriver();
    }
}
