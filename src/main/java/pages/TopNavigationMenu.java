package pages;

import com.codeborne.selenide.SelenideElement;

import static elements.ElementExtensions.getElementByClass;

public class TopNavigationMenu extends BasePage {

    private static final SelenideElement GO_TO_CALENDAR_BUTTON = getElementByClass("icsw16-day-calendar");

    public CalendarPage goToCalendarPage() {
        GO_TO_CALENDAR_BUTTON.click();
        return new CalendarPage();
    }
}
