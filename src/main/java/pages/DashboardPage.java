package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static elements.ElementExtensions.*;
import static java.time.temporal.ChronoUnit.SECONDS;

@Slf4j
public class DashboardPage extends TopNavigationMenu {

    protected static final String GET_UPCOMING_WORKOUTS_EVENT = "//*[@data-label='future-workouts']//*[@data-title='%s']";
    protected static final String GET_RECENT_PAST_WORKOUTS_EVENT = "//*[@data-label='past-workouts']//*[@data-title='%s']";
    private static final SelenideElement VIEW_CALENDAR_PROJECT_BUTTON = $x("//button[contains(@class, 'btn-info')]");
    private static final SelenideElement UPCOMING_WORKOUTS_BUTTON = findElementByDataLabel("future-workouts");
    private static final SelenideElement RECENT_PAST_WORKOUTS_BUTTON = findElementByDataLabel("past-workouts");
    private static final SelenideElement CURRENT_DATE_LINK = findElementByClass("currentdatelink");
    private static final SelenideElement CLICK_FEEDBACK_BUTTON = findElementByHref("Feedback.cshtml");
    private static final SelenideElement CLICK_CUSTOMER_SUPPORT_BUTTON = findElementByHref("CustSupport.cshtml");

    /**
     * Checks if the project calendar button is displayed on the page.
     *
     * @return {@code true}, if the button is visible, otherwise{@code false}.
     */
    public boolean isCalendarButtonVisible() {
        return VIEW_CALENDAR_PROJECT_BUTTON.shouldBe(Condition.visible)
                .isDisplayed();
    }

    /**
     * Checks if the upcoming workout event is displayed on the page.
     *
     * @param workoutName the name of the workout event to check for visibility
     * @return {@code true} if the specified workout event is visible on the page,
     *         {@code false} otherwise
     */
    public boolean checkUpcomingWorkoutsVisible(String workoutName) {
        UPCOMING_WORKOUTS_BUTTON.shouldBe(Condition.visible).click();
        return $x(String.format(GET_UPCOMING_WORKOUTS_EVENT, workoutName)).is(Condition.visible, Duration.of(2, SECONDS));
    }

    /**
     * Checks if the recent past workout event is displayed in the list.
     *
     * @param workoutName the name of the workout event to check for visibility
     * @return {@code true} if the specified workout event is visible in the list,
     *         {@code false} otherwise
     */
    public boolean openRecentPastWorkoutsList(String workoutName) {
        RECENT_PAST_WORKOUTS_BUTTON.shouldBe(Condition.visible).click();
        return $x(String.format(GET_RECENT_PAST_WORKOUTS_EVENT, workoutName)).is(Condition.visible, Duration.of(2, SECONDS));
    }

    /**
     * Retrieves the current date displayed on the page.
     *
     * @return the current date as a {@code String} if it can be retrieved;
     *         an empty {@code String} if there is an error retrieving the date.
     */
    public String getCurrentDate() {
        try {
            log.info("Getting the current date.");
            return CURRENT_DATE_LINK.getText();
        } catch (Exception e) {
            log.error("Failed to get current date.", e);
            return "";
        }
    }

    /**
     * Navigates to the feedback page.
     *
     * @return a new instance of {@link FeedbackPage} after navigating to the feedback page.
     */
    public FeedbackPage goToFeedback() {
        CLICK_FEEDBACK_BUTTON.click();
        return new FeedbackPage();
    }

    /**
     * Navigates to the customer support page.
     *
     * @return a new instance of {@link CustomerSupportPage} after navigating to the customer support page.
     */
    public CustomerSupportPage goToSupportPage() {
        CLICK_CUSTOMER_SUPPORT_BUTTON.click();
        return new CustomerSupportPage();
    }
}

