package steps;

import io.qameta.allure.Step;

public class LogoutSteps extends BaseSteps {

    @Step("Check the logout process")
    public boolean proceedLogoutAndCheck() {
        dashboardPage.clickLogoutButton();
        return logoutPage.checkIfUserIsLoggedOut();
    }
}
