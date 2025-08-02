package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.By;

public class InzhenerkaLoginTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\admin\\Desktop\\autotest\\edgedriver_win64\\msedgedriver.exe");
        Configuration.browser = "edge";

        // Очистка куков и локального хранилища браузера
        clearBrowserCookies();
        clearBrowserLocalStorage();

        // Открываем страницу входа
        open("http://qa-stand-login.inzhenerka.tech/login");

        System.out.println("Current URL: " + webdriver().driver().url());
        System.out.println("Page title: " + title());

        Thread.sleep(1000);

        // --- Вход с корректными данными ---
        $("#username").shouldBe(Condition.visible).setValue("admin");
        $(By.name("password")).shouldBe(Condition.visible).setValue("admin123");
        $("button[type='submit']").click();

        Thread.sleep(2000); // Ждем загрузки после входа

        // --- Выход из системы ---
        // Предположим, что кнопка выхода доступна с каким-то локатором, например id=logout или класс logout-button
        // Здесь нужно заменить на реальный локатор кнопки logout
        $(By.id("logoutButton")).shouldBe(Condition.visible).click();

        Thread.sleep(2000); // Ждем разлогинивания и перехода на страницу входа

        // --- Вход с пустыми полями ---
        $("#username").shouldBe(Condition.visible).setValue("");
        $(By.name("password")).shouldBe(Condition.visible).setValue("");
        $("button[type='submit']").click();

        Thread.sleep(2000); // Ждем обработки попытки входа

        // --- Повторный выход ---
        // Тут может не быть кнопки выхода, если вход не прошел.
        // Но согласно заданию, попробуем кликнуть на кнопку logout, если она есть
        if ($(By.id("logoutButton")).exists()) {
            $(By.id("logoutButton")).click();
        }
    }
}