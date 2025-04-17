package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static elements.ElementExtensions.*;
import static java.time.temporal.ChronoUnit.SECONDS;

public class DashboardPage extends TopNavigationMenu {

    protected static final String GET_UPCOMING_WORKOUTS_EVENT = "//*[@data-label='future-workouts']//*[@data-title='%s']";
    protected static final String GET_RECENT_PAST_WORKOUTS_EVENT = "//*[@data-label='past-workouts']//*[@data-title='%s']";
    private static final SelenideElement VIEW_CALENDAR_PROJECT_BUTTON = $x("//button[contains(@class, 'btn-info')]");
    private static final SelenideElement UPCOMING_WORKOUTS_BUTTON = getElementByDataLabel("future-workouts");
    private static final SelenideElement RECENT_PAST_WORKOUTS_BUTTON = getElementByDataLabel("past-workouts");
    private static final SelenideElement CURRENT_DATE_LINK = getElementByClass("currentdatelink");
    private static final SelenideElement CLICK_FEEDBACK_BUTTON = getElementByHref("Feedback.cshtml");
    private static final SelenideElement CLICK_CUSTOMER_SUPPORT_BUTTON = getElementByHref("CustSupport.cshtml");

    public boolean isVisibleCalendarButton() {
        return VIEW_CALENDAR_PROJECT_BUTTON.shouldBe(Condition.visible)
                .isDisplayed();
    }

    public boolean checkUpcomingWorkoutsVisible(String workoutName) {
        UPCOMING_WORKOUTS_BUTTON.shouldBe(Condition.visible).click();
        return $x(String.format(GET_UPCOMING_WORKOUTS_EVENT, workoutName)).is(Condition.visible, Duration.of(2, SECONDS));
    }

    public boolean openRecentPastWorkoutsList(String workoutName) {
        RECENT_PAST_WORKOUTS_BUTTON.shouldBe(Condition.visible).click();
        return $x(String.format(GET_RECENT_PAST_WORKOUTS_EVENT, workoutName)).is(Condition.visible, Duration.of(2, SECONDS));
    }

    public String getCurrentDate() {
        return CURRENT_DATE_LINK.getText();
    }

    public FeedbackPage goToFeedback() {
        CLICK_FEEDBACK_BUTTON.click();
        return new FeedbackPage();
    }

    public CustomerSupportPage goToSupportPage() {
        CLICK_CUSTOMER_SUPPORT_BUTTON.click();
        return new CustomerSupportPage();
    }
}

