package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static elements.ElementExtensions.findElementById;
import static elements.ElementExtensions.findInputByName;

@Slf4j
public class EditProfilePage extends TopNavigationMenu {
    private static final SelenideElement GET_FIRST_NAME_INPUT = findInputByName("fname");
    private static final SelenideElement CLICK_SAVE_CHANGES_BUTTON = findElementById(
            "saveButtonProfile");
    private static final SelenideElement CLICK_CHANGE_IMAGE_BUTTON = findElementById(
            "EditProfilePicOther");
    private static final SelenideElement UPLOAD_BUTTON = $x("//*[@id='NextStep' and text()='Upload']");
    private static final SelenideElement SAVE_BUTTON = $x("//*[@id='NextStep' and text()='Save']");
    private static final SelenideElement FILE_INPUT = $("input[type='file']");
    private static final SelenideElement PROFILE_PICTURE = findElementById("LayoutProfilePic");
    private static final SelenideElement REMOVE_IMAGE_BUTTON = findElementById("del-pic");
    private static final SelenideElement REMOVE_IMAGE_OK_BUTTON = $x("//*[@class='modal-footer']//*[@class='btn btn-primary']");

    /**
     * Pass new first name.
     *
     * @param newFirstName the first name
     * @return edit profile page
     */
    public EditProfilePage changeFirstName(String newFirstName) {
        GET_FIRST_NAME_INPUT.setValue(newFirstName);
        CLICK_SAVE_CHANGES_BUTTON.click();
        log.info("Change user name for: {}", newFirstName);
        return this;
    }

    /**
     * Uploads a new user image and saves profile changes.
     *
     * @param picture the image
     * @return current page {@link EditProfilePage} after image update
     */
    public EditProfilePage changeImage(String picture) {
        CLICK_CHANGE_IMAGE_BUTTON.click();

        File filePath = new File("src/test/resources/" + picture);
        switchTo().frame("uploader");

        FILE_INPUT.should(Condition.exist).uploadFile(filePath);
        switchTo().defaultContent();

        UPLOAD_BUTTON.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        log.info("Wait until image is loaded.");
        Selenide.sleep(5000);
        SAVE_BUTTON.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        log.info("User image has been changed.");
        return this;
    }

    /**
     * Returns a link (URL) to the user's profile image.
     *
     * @return attribute value {@code src} at the profile picture element
     */
    public String getImageSrc() {
        return PROFILE_PICTURE.shouldBe(Condition.visible, Duration.ofSeconds(10))
                .getAttribute("src");
    }

    /**
     * Refreshes the current edit profile page.
     *
     * @return a new instance of {@link EditProfilePage} after the page refresh
     */
    public EditProfilePage refreshEditPage() {
        Selenide.refresh();
        log.info("Page is refreshed");
        return new EditProfilePage();
    }

    /**
     * Delete profile image.
     */
    public void removeProfileImage() {
        REMOVE_IMAGE_BUTTON.click();
        REMOVE_IMAGE_OK_BUTTON.click();
        log.info("User image has been removed.");
    }
}


