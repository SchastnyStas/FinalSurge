package windows;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import object.Full;
import pages.BasePage;

import static elements.ElementExtensions.*;

public class NewFullAddWindow extends BasePage {

    private static final SelenideElement DATE_INPUT = findInputByName("WorkoutDate");
    private static final SelenideElement TIME_OF_DAY = findInputByName("WorkoutTime");
    private static final SelenideElement WORKOUT_NAME_INPUT = findInputByName("Name");
    private static final SelenideElement DISTANCE_INPUT = findInputByName("Distance");
    private static final SelenideElement ELEVATION_GAIN_INPUT = findInputByName("EGain");
    private static final SelenideElement ELEVATION_LOSS_INPUT = findInputByName("ELoss");
    private static final SelenideElement DIST_TYPE_SELECT = findSelectById("DistType");
    private static final SelenideElement PER_EFFORT_SELECT = findSelectById("PerEffort");
    private static final SelenideElement ADD_WORKOUT_BUTTON = findElementById("saveButton");

    public void addNewFull(Full full) {
        DATE_INPUT.setValue(full.getWorkoutDate());
        TIME_OF_DAY.setValue(full.getWorkoutTime());
        WORKOUT_NAME_INPUT.setValue(full.getWorkoutName());
        DISTANCE_INPUT.setValue(full.getDistance());
        ELEVATION_GAIN_INPUT.setValue(full.getElevationGain());
        ELEVATION_LOSS_INPUT.setValue(full.getElevationLoss());
        DIST_TYPE_SELECT.shouldBe(Condition.visible).selectOption(full.getDistType().getValue());
        findLabelByText(full.getHowFeel().getValue()).click();
        PER_EFFORT_SELECT.shouldBe(Condition.visible).selectOption(full.getPerEffort().getValue());
        ADD_WORKOUT_BUTTON.click();
    }
}
