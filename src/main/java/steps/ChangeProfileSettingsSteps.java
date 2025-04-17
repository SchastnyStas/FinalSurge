package steps;

import io.qameta.allure.Step;

public class ChangeProfileSettingsSteps extends BaseSteps {

    @Step("Chang profile first name")
    public void changFirstName(String newFirstName) {
        dashboardPage.goToSettingPage();
        settingsPage.goToEditProfilePage();
        editProfilePage.changeFirstName(newFirstName);
    }

    @Step("Chang profile image")
    public void changeImage(String picture) {
        dashboardPage.goToSettingPage();
        settingsPage
                .goToEditProfilePage()
                .changeImage(picture);
    }

    @Step("Check the visibility of the image")
    public String checkVisibilityImage() {
        return editProfilePage.getImgScr();
    }

    @Step("Refresh page")
    public void refreshEditPage() {
        editProfilePage.refreshEditPage();
    }

    @Step("Remove Profile Image")
    public void removePicture() {
        editProfilePage.removeProfileImage();
    }
}
