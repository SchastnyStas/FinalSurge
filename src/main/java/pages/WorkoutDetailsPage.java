package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class WorkoutDetailsPage extends BasePage {
    private static final SelenideElement GO_TO_CALENDAR_BUTTON = $x("//*[@class='icsw16-day-calendar']");

    public CalendarPage goToCalendarPage() {
        GO_TO_CALENDAR_BUTTON.click();
        return new CalendarPage();
    }
}
