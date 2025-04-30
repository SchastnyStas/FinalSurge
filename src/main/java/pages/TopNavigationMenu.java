package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;

import static elements.ElementExtensions.findElementByClass;

@Slf4j
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
        log.info("Calendar page is opened.");
        return new CalendarPage();
    }
}
