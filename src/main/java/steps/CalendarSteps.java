package steps;

import io.qameta.allure.Step;
import object.Full;
import pages.CalendarPage;

public class CalendarSteps extends BaseSteps {
    @Step("Check event is present for day")
    public boolean isElementVisibleSteps(String day, String event) {
        return calendarPage.checkEventIsPresentForDay(day, event);
    }
    @Step("Delete event for the day")
    public CalendarPage deleteEventForDay(String day, String event) {
        return calendarPage.deleteEventForDay(day, event);
    }
}