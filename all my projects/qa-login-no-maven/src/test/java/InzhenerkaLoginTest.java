import static com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.*;
import static jdk.internal.misc.ThreadFlock.open;


public class InzhenerkaLoginTest {

    @BeforeEach
    void setUp() {
        Configuration.browser = "firefox";  // Или "chrome", если установлен
    }

    @Test
    public void testLoginAndLogout() {
        // Открываем страницу входа
        open("http://qa-stand-login.inzhenerka.tech/login");

        // Вводим имя пользователя
        $("#username").setValue("admin");

        // Вводим пароль
        $(By.name("password")).setValue("admin123");

        // Нажимаем кнопку "Вход"
        $("button[type='submit']").click();

        // Проверяем, что кнопка "Выход" появилась
        Object visible;
        $(".mb-3").shouldBe(visible);

        // Нажимаем кнопку "Выход"
        $(".mb-3").click();

        // Проверяем, что вернулись на страницу входа
        $("button[type='submit']").shouldBe(visible);
    }

    @AfterEach
    void tearDown() {
        // Закрываем браузер после теста
        Selenide.closeWebDriver();
    }
}
