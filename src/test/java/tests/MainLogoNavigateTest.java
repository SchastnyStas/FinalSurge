package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MainLogoNavigateTest extends BaseTest {

    @Test
    public void navigationByMainLogo() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mainLogoNavigateSteps.goToDashboardPage());
        softAssert.assertAll();
    }
}
