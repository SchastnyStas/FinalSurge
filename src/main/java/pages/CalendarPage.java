package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static elements.ElementExtensions.getButtonByClass;
import static elements.ElementExtensions.getButtonById;

public class CalendarPage extends BasePage {
    private static final SelenideElement QUICK_ADD_BUTTON = getButtonById("QuickAddToggle");
    private static final String EVENT_PRESENT_DETAILS = "//*[@data-day='%s']//*[@data" +
            "-title='%s']";
    private static final SelenideElement FULL_ADD_BUTTON = getButtonById("FullAddBtn");

    private static final SelenideElement QUICK_DELETE_BUTTON = getButtonByClass("quick-delete");
    private static final SelenideElement QUICK_DELETE_CLICK_OK_BUTTON = getButtonByClass("btn btn-primary");
    private static final SelenideElement GO_TO_DASHBOARD_BUTTON = $x("//*[@class='icsw16-home']");


    public NewQuickAddWindow goToNewQuickAddWindow() {
        QUICK_ADD_BUTTON.click();
        return new NewQuickAddWindow();
    }

    public FullAddPage goToFullAddPage() {
        FULL_ADD_BUTTON.click();
        return new FullAddPage();
    }

    //    public String isElementVisible() {
//        //WORK_OUT_DETAILS.shouldBe(Condition.visible);
//        return WORK_OUT_DETAILS.getText();
//    }
    public boolean checkEventIsPresentForDay(String day, String event) {
        return $x(String.format(EVENT_PRESENT_DETAILS, day, event))
                .isDisplayed();
    }

    public CalendarPage deleteEventForDay(String day, String event) {
        String xpath = String.format(EVENT_PRESENT_DETAILS, day, event);
        SelenideElement eventElement = $x(xpath);
        eventElement.shouldBe(Condition.visible).click();
        QUICK_DELETE_BUTTON.click();
        QUICK_DELETE_CLICK_OK_BUTTON.click();
        eventElement.shouldNotBe(Condition.visible);
        return new CalendarPage();
    }

    public DashboardPage goToDashboardPage() {
        GO_TO_DASHBOARD_BUTTON.click();
        return new DashboardPage();
    }
}

