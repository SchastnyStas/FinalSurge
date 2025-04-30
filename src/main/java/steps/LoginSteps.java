package steps;

import io.qameta.allure.Step;

public class LoginSteps extends BaseSteps {

    @Step("Login by user: {email}")
    public void login(String url, String email, String password) {
        loginPage
                .openLoginPage(url)
                .login(email, password);
    }

    @Step("Check calendar button is visible")
    public boolean isCalendarButtonVisible() {
        return dashboardPage.isCalendarButtonVisible();
    }
}
