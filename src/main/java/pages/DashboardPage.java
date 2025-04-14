package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static com.codeborne.selenide.Selenide.$x;
import static elements.ElementExtensions.*;
import static java.time.temporal.ChronoUnit.SECONDS;

public class DashboardPage extends BasePage {

    private static final SelenideElement VIEW_CALENDAR_PROJECT_BUTTON = getButtonByText("View Calendar");
    private static final SelenideElement UPCOMING_WORKOUTS_BUTTON = getButtonByDataLabel("future-workouts");
    private static final SelenideElement RECENT_PAST_WORKOUTS_BUTTON = getButtonByDataLabel("past-workouts");

    protected static final String GET_TEXT_BY_UPCOMING_WORKOUTS_EVENT = "//*[@data-label='future-workouts']//*[@data-title='%s']";

    protected static final String GET_TEXT_BY_RECENT_PAST_WORKOUTS_EVENT = "//*[@data-label='past-workouts']//*[@data-title='%s']";



    public boolean waitForViewCalendarButton() {
        return VIEW_CALENDAR_PROJECT_BUTTON.shouldBe(Condition.visible).isDisplayed();
    }

    public CalendarPage goToCalendarPage() {
        VIEW_CALENDAR_PROJECT_BUTTON.click();
        return new CalendarPage();
    }

    public boolean openUpcomingWorkoutsList(String workoutName) {
        UPCOMING_WORKOUTS_BUTTON.shouldBe(Condition.visible).click();
          return $x(String.format(GET_TEXT_BY_UPCOMING_WORKOUTS_EVENT, workoutName)).is(Condition.visible, Duration.of(2, SECONDS));

    }

    public boolean openRecentPastWorkoutsList(String workoutName){
        RECENT_PAST_WORKOUTS_BUTTON.shouldBe(Condition.visible).click();
        return $x(String.format(GET_TEXT_BY_RECENT_PAST_WORKOUTS_EVENT, workoutName)).is(Condition.visible, Duration.of(2, SECONDS));
    }
}

