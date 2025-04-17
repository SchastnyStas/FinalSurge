package steps;

import io.qameta.allure.Step;
import pages.CalendarPage;
import pages.DashboardPage;

public class CalendarSteps extends BaseSteps {

    @Step("Check event is present for day")
    public boolean isElementVisibleSteps(String day, String event) {
        return calendarPage.checkEventIsPresentForDay(day, event);
    }

    @Step("Delete event for the day")
    public CalendarPage deleteEventForDay(String day, String event) {
        return calendarPage.deleteEventForDay(day, event);
    }

    @Step("Go to dashboard page")
    public DashboardPage goToDashboardPage() {
        return calendarPage.goToDashboardPage();
    }
}