package pages;

import com.codeborne.selenide.SelenideElement;

import static elements.ElementExtensions.findElementByClass;

public class TopNavigationMenu extends BasePage {

    private static final SelenideElement GO_TO_CALENDAR_BUTTON = findElementByClass("icsw16-day-calendar");


    /**
     * Clicks on the project calendar button
     * and opens the calendar page.
     *
     * @return new object {@link CalendarPage}, representing a calendar page.
     */
    public CalendarPage goToCalendarPage() {
        GO_TO_CALENDAR_BUTTON.click();
        return new CalendarPage();
    }
}
