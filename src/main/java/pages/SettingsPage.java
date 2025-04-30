package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$x;
import static elements.ElementExtensions.findElementById;

@Slf4j
public class SettingsPage extends TopNavigationMenu {

    private static final SelenideElement GO_TO_EDIT_PROFILE_BUTTON = findElementById("ProfileEditLink");
    private static final SelenideElement USER_INFO = $x("//*[@class='user-info']//strong");
    private static final SelenideElement GET_TEXT_SETTINGS_PAGE = $x("//*[@id='breadcrumbs']//span");

    /**
     * Checks if the settings page is loaded by verifying the visibility of a specific element.
     *
     * @return {@code true} if the settings page is loaded,
     *         {@code false} otherwise
     */
    public boolean checkSettingsPageIsLoaded() {
        log.info("Check if settings page is loaded.");
        return GET_TEXT_SETTINGS_PAGE.isDisplayed();
    }

    /**
     * Navigates to the edit profile page.
     *
     * @return a new instance of {@link EditProfilePage} after navigating to the edit profile page
     */
    public EditProfilePage goToEditProfilePage() {
        GO_TO_EDIT_PROFILE_BUTTON.click();
        log.info("Edit profile page is opened.");
        return new EditProfilePage();
    }

    /**
     * Retrieves the user information from the user info element.
     *
     * @return the text content of the user info element, or an empty string if an error occurs
     */
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
