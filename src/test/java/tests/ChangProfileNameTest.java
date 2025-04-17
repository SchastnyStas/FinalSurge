package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static utils.DataGenerator.generateRandomName;

public class ChangProfileNameTest extends BaseTest {

    @Test
    public void changProfileName() {
        SoftAssert softAssert = new SoftAssert();
        String name = generateRandomName();

        changProfileSettingsSteps.changFirstName(name);
        softAssert.assertEquals(settingsPage.getUserInfo(), name);
        softAssert.assertAll();
    }
}
