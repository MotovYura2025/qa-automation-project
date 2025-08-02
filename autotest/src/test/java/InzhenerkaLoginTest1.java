import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InzhenerkaLoginTest1 {

    @Test
    @DisplayName("Проверка логина")
    public void runLoginTest() {
        LoginPage loginPage = new LoginPage();

        loginPage.openPage();
        loginPage.setUsername("admin");
        loginPage.setPassword("admin123");
        loginPage.login();
        loginPage.logout();
    }
}
