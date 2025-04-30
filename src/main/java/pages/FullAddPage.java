package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;
import windows.NewFullAddWindow;

import static elements.ElementExtensions.findElementByDataCode;

@Slf4j
public class FullAddPage extends TopNavigationMenu {
    private static final SelenideElement SELECT_ACTIVITY_TYPE = findElementByDataCode("bike");

    /**
     * Open full add workout window.
     *
     * @return the full add window
     */
    public NewFullAddWindow goToNewFullAddWindow() {
        SELECT_ACTIVITY_TYPE.click();
        log.info("Create a new full window is open.");
        return new NewFullAddWindow();
    }
}
