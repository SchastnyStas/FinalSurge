package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ElementExtensions {

    public static SelenideElement getButtonByType(String type) {
        return $x("//button[type()='" + type + "']");
    }

    public static SelenideElement getButtonByText(String text) {
        return $x("//button[text()='" + text + "']");
    }

    public static SelenideElement getButtonById(String text) {
        return $x("//*[@id='" + text + "']");
    }

    public static SelenideElement getInputByName(String name) {
        return $x("//input[@name='" + name + "']");
    }

    public static SelenideElement getSelectById(String id) {
        return $x("//select[@id='" + id + "']");
    }
    public static SelenideElement getOptionByText(String text) {
        return $x("//option[text()='" + text + "']");
    }
    public static SelenideElement getAccordionByDataCode(String dataCode){
        return $x("//*[@data-code='" + dataCode + "']");
    }

    public static SelenideElement getButtonByClass(String byClass){
        return $x("//*[@class='" + byClass + "']");
    }

    public static SelenideElement getButtonByDataLabel(String dataLabel){
        return $x("//*[@data-label='" + dataLabel + "']");
    }

    public static SelenideElement getLabelByText(String text){
        return $x("//label[span[text()='" + text + "']]");
    }

}
