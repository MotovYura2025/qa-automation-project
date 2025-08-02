import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BaseTest {

    private final SelenideElement usernameField = $("#username");
    private final SelenideElement passwordField = $("[name='password']");
    private final SelenideElement loginButton = $("button[type='submit']");
    private final SelenideElement logoutButton = $(".mb-3"); // проверь правильность селектора в DevTools

    public void openPage() {
        String URL = "http://qa-stand-login.inzhenerka.tech/login";
        open(URL);
    }

    public void setUsername(String username) {
        usernameField.setValue(username);
    }

    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    public void login() {
        loginButton.click();
    }

    public void logout() {
        logoutButton.click();
    }
}
