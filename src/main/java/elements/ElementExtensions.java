package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ElementExtensions {

    public static SelenideElement getElementByHref(String href) {
        return $x("//*[@href='" + href + "']");
    }

    public static SelenideElement getButtonByText(String text) {
        return $x("//button[text()='" + text + "']");
    }

    public static SelenideElement getElementById(String id) {

        return $x("//*[@id='" + id + "']");
    }

    public static SelenideElement getInputByName(String name) {
        return $x("//input[@name='" + name + "']");
    }

    public static SelenideElement getSelectById(String id) {
        return $x("//select[@id='" + id + "']");
    }

    public static SelenideElement getElementByDataCode(String dataCode) {
        return $x("//*[@data-code='" + dataCode + "']");
    }

    public static SelenideElement getElementByClass(String byClass) {
        return $x("//*[@class='" + byClass + "']");
    }

    public static SelenideElement getElementByDataLabel(String dataLabel) {
        return $x("//*[@data-label='" + dataLabel + "']");
    }

    public static SelenideElement getLabelByText(String text) {
        return $x("//label[span[text()='" + text + "']]");
    }
}
