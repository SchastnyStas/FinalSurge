package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

public class LoginTest extends BaseTest {
    @Test
    public void successLogin() {
     Assert.assertTrue(loginSteps.isElementVisibleCalendarButton());
    }
}
