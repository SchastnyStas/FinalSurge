package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static elements.ElementExtensions.getElementById;
import static elements.ElementExtensions.getInputByName;

public class EditProfilePage extends TopNavigationMenu {
    public static final SelenideElement GET_FIRST_NAME_INPUT = getInputByName("fname");
    public static final SelenideElement CLICK_SAVE_CHANGES_BUTTON = getElementById(
            "saveButtonProfile");
    public static final SelenideElement CLICK_CHANGE_IMAGE_BUTTON = getElementById(
            "EditProfilePicOther");
    public static final SelenideElement UPLOAD_BUTTON = $x("//*[@id='NextStep' and text()='Upload']");
    public static final SelenideElement SAVE_BUTTON = $x("//*[@id='NextStep' and text()='Save']");
    public static final SelenideElement FILE_INPUT = $("input[type='file']");
    public static final SelenideElement PROFILE_PICTURE = getElementById("LayoutProfilePic");
    public static final SelenideElement REMOVE_IMAGE_BUTTON = getElementById("del-pic");
    public static final SelenideElement REMOVE_IMAGE_OK_BUTTON = $x("//*[@class='modal-footer']//*[@class='btn btn-primary']");

    public EditProfilePage changeFirstName(String newFirstName) {
        GET_FIRST_NAME_INPUT.setValue(newFirstName);
        CLICK_SAVE_CHANGES_BUTTON.click();
        return this;
    }

    public EditProfilePage changeImage(String picture) {
        CLICK_CHANGE_IMAGE_BUTTON.click();

        File filePath = new File("src/test/resources/" + picture);
        switchTo().frame("uploader");

        FILE_INPUT.should(Condition.exist).uploadFile(filePath);
        switchTo().defaultContent();

        UPLOAD_BUTTON.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        Selenide.sleep(5000);
        SAVE_BUTTON.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }

    public String getImgScr() {
        return PROFILE_PICTURE.shouldBe(Condition.visible, Duration.ofSeconds(10))
                .getAttribute("src");
    }

    public EditProfilePage refreshEditPage() {
        Selenide.refresh();
        return new EditProfilePage();
    }

    public void removeProfileImage() {
        REMOVE_IMAGE_BUTTON.click();
        REMOVE_IMAGE_OK_BUTTON.click();
    }
}


