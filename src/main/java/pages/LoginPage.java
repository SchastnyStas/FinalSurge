package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.open;
import static elements.ElementExtensions.findButtonByText;
import static elements.ElementExtensions.findInputByName;

@Slf4j
public class LoginPage extends TopNavigationMenu {
    private static final SelenideElement SIGN_IN_BUTTON = findButtonByText("Login");
    private static final SelenideElement EMAIL_INPUT = findInputByName("login_name");
    private static final SelenideElement PASSWORD_INPUT = findInputByName("login_password");

    /**
     * Open login page.
     *
     * @param url the url
     * @return the login page
     */
    public LoginPage openLoginPage(String url) {
        open(url);
        log.info("Login page is opened.");
        return this;
    }

    /**
     * Waits for the login page to fully load by ensuring the visibility of the "Sign In" button.
     *
     * @return the current {@link LoginPage} instance after confirming that the page is loaded
     */
    public LoginPage waitForPageToLoad() {
        SIGN_IN_BUTTON.shouldBe(Condition.visible);
        log.info("Wait until login page is loaded.");
        return this;
    }

    /**
     * Open login page.
     *
     * @param email the email
     * @param password the password
     * @return new {@link DashboardPage}, which represents the main page after logging in
     */
    public DashboardPage login(String email, String password) {
        waitForPageToLoad();
        EMAIL_INPUT.setValue(email);
        PASSWORD_INPUT.setValue(password);
        SIGN_IN_BUTTON.click();
        log.info("User is logged in.");
        return new DashboardPage();
    }
}
