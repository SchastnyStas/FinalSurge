package tests;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utils.DataGenerator.generateRandomName;

public class ChangeProfileDataTest extends BaseTest {

    @Test(description = "Change profile image")
    public void changeProfileImage() {
        String src = "img/default-profile60x60.png";

        changeProfileSettingsSteps.changeImage("avatar.png");
        Assert.assertNotEquals(changeProfileSettingsSteps.checkVisibilityImage(), src);
        changeProfileSettingsSteps.refreshEditPage();
        Selenide.sleep(3000);
        changeProfileSettingsSteps.removePicture();
    }

    @Test(description = "Change profile first name")
    public void changeProfileName() {
        String name = generateRandomName();

        changeProfileSettingsSteps.changeFirstName(name);
        Assert.assertEquals(changeProfileSettingsSteps.getUserName(), name);
    }
}
