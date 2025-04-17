package pages;

import com.codeborne.selenide.SelenideElement;
import windows.NewFullAddWindow;

import static elements.ElementExtensions.getElementByDataCode;

public class FullAddPage extends TopNavigationMenu {
    public static final SelenideElement SELECT_ACTIVITY_TYPE = getElementByDataCode("bike");

    public NewFullAddWindow goToNewFullAddWindow() {
        SELECT_ACTIVITY_TYPE.click();
        return new NewFullAddWindow();
    }
}
