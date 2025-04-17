package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SettingsNavigateTest extends BaseTest {

    @Test
    public void goToSettingPage() {
        SoftAssert softAssert = new SoftAssert();
        //loginSteps.isElementVisibleCalendarButton();
        softAssert.assertTrue(settingsNavigateSteps.goToSettingsPage());
        softAssert.assertAll();
    }
}
