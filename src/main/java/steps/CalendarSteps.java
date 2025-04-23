package steps;

import io.qameta.allure.Step;
import pages.CalendarPage;

public class CalendarSteps extends BaseSteps {

    @Step("Check {event} event is present for {day} day")
    public boolean isElementVisibleSteps(String day, String event) {
        return calendarPage.checkEventIsPresentForDay(day, event);
    }

    @Step("Delete {event} event for the {day} day")
    public CalendarPage deleteEventForDay(String day, String event) {
        return calendarPage.deleteEventForDay(day, event);
    }
}