package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$x;
import static elements.ElementExtensions.findElementById;

@Slf4j

public class SettingsPage extends TopNavigationMenu {

    private static final SelenideElement GO_TO_EDIT_PROFILE_BUTTON = findElementById("ProfileEditLink");
    private static final SelenideElement USER_INFO = $x("//*[@class='user-info']//strong");

    public boolean checkSettingsPageIsLoaded() {
        return $x("//*[@id='breadcrumbs']//span").isDisplayed();
    }

    public EditProfilePage goToEditProfilePage() {
        GO_TO_EDIT_PROFILE_BUTTON.click();
        return new EditProfilePage();
    }

    public String getUserInfo() {
        try {
            log.info("Getting the current date.");
            return USER_INFO.getText();
        } catch (Exception e) {
            log.error("Failed to get current name.", e);
            return "";
        }
    }
}
