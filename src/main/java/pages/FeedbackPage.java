package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static elements.ElementExtensions.findElementById;
import static elements.ElementExtensions.findSelectById;

@Slf4j
public class FeedbackPage extends TopNavigationMenu {
    private static final SelenideElement FEEDBACK_REASON_SELECT = findSelectById("Reason");
    private static final SelenideElement YOUR_FEEDBACK_TEXT = $("textarea[name='Feedback']");
    private static final SelenideElement SEND_FEEDBACK_BUTTON = findElementById("submitButton");
    private static final SelenideElement GET_TEXT_AFTER_SEND_FEEDBACK = $x("//*[@class='alert alert-success']");

    public void sendFeedback(String reason, String text) {
        FEEDBACK_REASON_SELECT.selectOption(reason);
        YOUR_FEEDBACK_TEXT.setValue(text);
        SEND_FEEDBACK_BUTTON.click();
        log.info("Feedback is sent.");
    }

    /**
     * Gets text after send.
     *
     * @return the text after send
     */
    public boolean isTextDisplayedAfterSend() {
        log.info("Check if success message is displayed.");
        return GET_TEXT_AFTER_SEND_FEEDBACK.isDisplayed();
    }
}

