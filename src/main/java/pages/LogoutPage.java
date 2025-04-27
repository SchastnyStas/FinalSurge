package pages;

import com.codeborne.selenide.SelenideElement;

import static elements.ElementExtensions.findElementByClass;

public class LogoutPage extends BasePage {
    private static final SelenideElement GET_LOGOUT_TEXT = findElementByClass("heading_main");

    public boolean checkIfUserIsLoggedOut() {
        return GET_LOGOUT_TEXT.isDisplayed();
    }
}
