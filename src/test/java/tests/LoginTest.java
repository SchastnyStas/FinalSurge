package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Retry;

public class LoginTest extends BaseTest {

    @Test(description = "Login user with valid credentials", retryAnalyzer = Retry.class)
    public void checkUserLogin() {
        Assert.assertTrue(loginSteps.isCalendarButtonVisible());
    }

    @Test(description = "Check the logout process")
    public void checkUserLogout() {
        Assert.assertTrue(logoutSteps.proceedLogoutAndCheck());
    }
}
