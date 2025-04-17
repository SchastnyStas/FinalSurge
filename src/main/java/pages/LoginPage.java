package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.open;
import static elements.ElementExtensions.getButtonByText;
import static elements.ElementExtensions.getInputByName;

public class LoginPage extends TopNavigationMenu {
    private static final SelenideElement SIGN_IN_BUTTON = getButtonByText("Login");
    private static final SelenideElement EMAIL_INPUT = getInputByName("login_name");
    private static final SelenideElement PASSWORD_INPUT = getInputByName("login_password");

    public LoginPage openLoginPage(String url) {
        open(url);
        return this;
    }

    public LoginPage waitForPageToLoad() {
        SIGN_IN_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    public DashboardPage login(String email, String password) {
        waitForPageToLoad();
        EMAIL_INPUT.setValue(email);
        PASSWORD_INPUT.setValue(password);
        SIGN_IN_BUTTON.click();
        return new DashboardPage();
    }
}
