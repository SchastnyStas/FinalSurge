package tests;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ChangeProfileImageTest extends BaseTest {

    @Test
    public void changeProfileImage() {
        SoftAssert softAssert = new SoftAssert();
        String src = "img/default-profile60x60.png";
        changProfileSettingsSteps.changeImage("avatar.png");
        softAssert.assertNotEquals(changProfileSettingsSteps.checkVisibilityImage(), src);
        changProfileSettingsSteps.refreshEditPage();
        Selenide.sleep(3000);
        changProfileSettingsSteps.removePicture();
        softAssert.assertAll();
    }
}
