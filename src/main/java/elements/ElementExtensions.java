package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ElementExtensions {

    public static SelenideElement findElementByHref(String href) {
        return $x("//*[@href='" + href + "']");
    }

    public static SelenideElement findButtonByText(String text) {
        return $x("//button[text()='" + text + "']");
    }

    public static SelenideElement findElementById(String id) {

        return $x("//*[@id='" + id + "']");
    }

    public static SelenideElement findInputByName(String name) {
        return $x("//input[@name='" + name + "']");
    }

    public static SelenideElement findSelectById(String id) {
        return $x("//select[@id='" + id + "']");
    }

    public static SelenideElement findElementByDataCode(String dataCode) {
        return $x("//*[@data-code='" + dataCode + "']");
    }

    public static SelenideElement findElementByClass(String byClass) {
        return $x("//*[@class='" + byClass + "']");
    }

    public static SelenideElement findElementByDataLabel(String dataLabel) {
        return $x("//*[@data-label='" + dataLabel + "']");
    }

    public static SelenideElement findLabelByText(String text) {
        return $x("//label[span[text()='" + text + "']]");
    }
}
