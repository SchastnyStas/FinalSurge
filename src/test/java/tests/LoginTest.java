package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(testName = "Login user with valid credentials")
    public void checkUserLogin() {
        Assert.assertTrue(loginSteps.isCalendarButtonVisible());
    }

    @Test(testName = "Check the logout process")
    public void checkUserLogout() {
        Assert.assertTrue(logoutSteps.proceedLogoutAndCheck());
    }
}
