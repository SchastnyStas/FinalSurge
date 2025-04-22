package pages;

import com.codeborne.selenide.SelenideElement;

import static elements.ElementExtensions.getElementByClass;

public class LogoutPage extends BasePage {
    public static final SelenideElement GET_LOGOUT_TEXT = getElementByClass("heading_main");

    public boolean checkIfUserIsLoggedOut() {
        return GET_LOGOUT_TEXT.isDisplayed();
    }
}
