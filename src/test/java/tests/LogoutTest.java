package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void successLogout() {
        Assert.assertTrue(logoutSteps.logoutProcess());
    }
}
