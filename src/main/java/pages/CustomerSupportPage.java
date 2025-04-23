package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static elements.ElementExtensions.getElementById;
import static elements.ElementExtensions.getSelectById;

public class CustomerSupportPage extends TopNavigationMenu {

    private static final SelenideElement SUPPORT_REASON_SELECT = getSelectById("Reason");
    private static final SelenideElement YOUR_SUPPORT_TEXT = $("textarea[name='Feedback']");
    private static final SelenideElement SEND_SUPPORT_BUTTON = getElementById("submitButton");
    private static final SelenideElement GET_TEXT_AFTER_SEND_SUPPORT = $x("//*[@class='alert alert-success']");

    public void sendMessenger(String reason, String text) {
        SUPPORT_REASON_SELECT.selectOption(reason);
        YOUR_SUPPORT_TEXT.setValue(text);
        SEND_SUPPORT_BUTTON.click();
    }

    public boolean isDisplayedTextAfterSend() {
        return GET_TEXT_AFTER_SEND_SUPPORT.isDisplayed();
    }
}
