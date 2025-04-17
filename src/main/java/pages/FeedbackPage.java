package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static elements.ElementExtensions.getElementById;
import static elements.ElementExtensions.getSelectById;

public class FeedbackPage extends TopNavigationMenu {
    private static final SelenideElement FEEDBACK_REASON_SELECT = getSelectById("Reason");
    private static final SelenideElement YOUR_FEEDBACK_TEXT = $("textarea[name='Feedback']");
    private static final SelenideElement SEND_FEEDBACK_BUTTON = getElementById("submitButton");
    private static final SelenideElement GET_TEXT_AFTER_SEND_FEEDBACK = $x("//*[@class='alert alert-success']");

    public void sendFeedback(String select, String text) {
        FEEDBACK_REASON_SELECT.selectOption(select);
        YOUR_FEEDBACK_TEXT.setValue(text);
        SEND_FEEDBACK_BUTTON.click();
    }

    public boolean isDisplayedTextAfterSend() {
        return GET_TEXT_AFTER_SEND_FEEDBACK.isDisplayed();
    }
}
