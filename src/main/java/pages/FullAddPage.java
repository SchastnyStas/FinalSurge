package pages;

import com.codeborne.selenide.SelenideElement;
import windows.NewFullAddWindow;

import static elements.ElementExtensions.findElementByDataCode;

public class FullAddPage extends TopNavigationMenu {
    private static final SelenideElement SELECT_ACTIVITY_TYPE = findElementByDataCode("bike");

    /**
     * Open full add workout window.
     *
     * @return the full add window
     */
    public NewFullAddWindow goToNewFullAddWindow() {
        SELECT_ACTIVITY_TYPE.click();
        return new NewFullAddWindow();
    }
}
