package steps;

import io.qameta.allure.Step;
import pages.CalendarPage;

public class TopNavigationSteps extends BaseSteps {
    @Step("Go to calendar page")
    public CalendarPage isElementVisibleSteps() {
        return workoutDetailsPage.goToCalendarPage();
    }
}