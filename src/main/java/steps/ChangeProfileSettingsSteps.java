package steps;

import io.qameta.allure.Step;

public class ChangeProfileSettingsSteps extends BaseSteps {

    @Step("Change profile first name to: {newFirstName}")
    public void changeFirstName(String newFirstName) {
        dashboardPage.goToSettingPage();
        settingsPage.goToEditProfilePage();
        editProfilePage.changeFirstName(newFirstName);
    }

    @Step("Change profile image")
    public void changeImage(String picture) {
        dashboardPage.goToSettingPage();
        settingsPage
                .goToEditProfilePage()
                .changeImage(picture);
    }

    @Step("Get user name")
    public String getUserName() {
        return settingsPage.getUserInfo();
    }

    @Step("Check the visibility of the image")
    public String checkVisibilityImage() {
        return editProfilePage.getImageScr();
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
