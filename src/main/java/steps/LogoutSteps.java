package steps;

import io.qameta.allure.Step;

public class LogoutSteps extends BaseSteps {
    @Step("Check the logout process")
    public boolean logoutProcess() {
        dashboardPage.clickLogoutButton();
        return logoutPage.logoutText();
    }
}
