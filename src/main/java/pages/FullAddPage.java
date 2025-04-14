package pages;

import com.codeborne.selenide.SelenideElement;

import static elements.ElementExtensions.getAccordionByDataCode;

public class FullAddPage extends BasePage {
    public static final SelenideElement SELECT_ACTIVITY_TYPE = getAccordionByDataCode("bike");

    public NewFullAddWindow goToNewFullAddWindow() {
        SELECT_ACTIVITY_TYPE.click();
        return new NewFullAddWindow();
    }
}
