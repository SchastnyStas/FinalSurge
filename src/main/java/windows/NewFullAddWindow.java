package windows;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import object.Full;
import pages.BasePage;

import static elements.ElementExtensions.*;

public class NewFullAddWindow extends BasePage {

    public static final SelenideElement DATE_INPUT = getInputByName("WorkoutDate");
    public static final SelenideElement TIME_OF_DAY = getInputByName("WorkoutTime");
    public static final SelenideElement WORKOUT_NAME_INPUT = getInputByName("Name");
    public static final SelenideElement DISTANCE_INPUT = getInputByName("Distance");
    public static final SelenideElement ELEVATION_GAIN_INPUT = getInputByName("EGain");
    public static final SelenideElement ELEVATION_LOSS_INPUT = getInputByName("ELoss");
    public static final SelenideElement DIST_TYPE_SELECT = getSelectById("DistType");

    //public static final SelenideElement HOW_FEEL_SELECT = getLabelByText("Great");

    public static final SelenideElement PER_EFFORT_SELECT = getSelectById("PerEffort");
    public static final SelenideElement ADD_WORKOUT_BUTTON = getElementById("saveButton");


    public void addNewFull(Full full) {
        DATE_INPUT.setValue(full.getWorkoutDate());
        TIME_OF_DAY.setValue(full.getWorkoutTime());
        WORKOUT_NAME_INPUT.setValue(full.getWorkoutName());
        DISTANCE_INPUT.setValue(full.getDistance());
        ELEVATION_GAIN_INPUT.setValue(full.getElevationGain());
        ELEVATION_LOSS_INPUT.setValue(full.getElevationLoss());
        DIST_TYPE_SELECT.shouldBe(Condition.visible).selectOption(full.getDistType().getValue());
        //HOW_FEEL_SELECT.setValue(full.getHowFeel()).click();
        getLabelByText(full.getHowFeel().getValue()).click();
        PER_EFFORT_SELECT.shouldBe(Condition.visible).selectOption(full.getPerEffort().getValue());
        ADD_WORKOUT_BUTTON.click();
    }
}
