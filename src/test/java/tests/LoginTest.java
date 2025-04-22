package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Login user with valid credentials")
    public void checkUserLogin() {
        Assert.assertTrue(loginSteps.isCalendarButtonVisible());
    }

    @Test(description = "Check the logout process")
    public void checkUserLogout() {
        Assert.assertTrue(logoutSteps.proceedLogoutAndCheck());
    }
}
