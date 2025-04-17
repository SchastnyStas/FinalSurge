package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static elements.ElementExtensions.getElementById;

public class SettingsPage extends TopNavigationMenu {

    public static final SelenideElement GO_TO_EDIT_PROFILE_BUTTON = getElementById("ProfileEditLink");
    public static final SelenideElement USER_INFO = $x("//*[@class='user-info']//strong");

    public boolean checkSettingsPageIsLoaded() {
        return $x("//*[@id='breadcrumbs']//span").isDisplayed();
    }

    public EditProfilePage goToEditProfilePage() {
        GO_TO_EDIT_PROFILE_BUTTON.click();
        return new EditProfilePage();
    }

    public String getUserInfo() {
        return USER_INFO.getText();
    }
}
