package pages;

import com.codeborne.selenide.SelenideElement;

import static elements.ElementExtensions.findElementByClass;

public class LogoutPage extends BasePage {
    private static final SelenideElement GET_LOGOUT_TEXT = findElementByClass("heading_main");

    /**
     * Checks if the user is logged out by verifying the presence of the logout confirmation text.
     * *
     * @return {@code true} if the logout confirmation text is displayed,
     *         {@code false} otherwise
     */
    public boolean checkIfUserIsLoggedOut() {
        return GET_LOGOUT_TEXT.isDisplayed();
    }
}
