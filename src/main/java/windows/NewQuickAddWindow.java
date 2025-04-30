package windows;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import object.Quick;
import pages.BasePage;

import static elements.ElementExtensions.*;

public class NewQuickAddWindow extends BasePage {

    private static final SelenideElement DATE_INPUT = findInputByName("WorkoutDate");
    private static final SelenideElement TIME_OF_DAY = findInputByName("WorkoutTime");
    private static final SelenideElement WORKOUT_NAME_INPUT = findInputByName("Name");
    private static final SelenideElement DISTANCE_INPUT = findInputByName("Distance");
    private static final SelenideElement ACTIVITY_TYPE_SELECT = findSelectById("ActivityType");
    private static final SelenideElement DIST_TYPE_SELECT = findSelectById("DistType");
    private static final SelenideElement HOW_FEEL_SELECT = findSelectById("HowFeel");
    private static final SelenideElement PER_EFFORT_SELECT = findSelectById("PerEffort");
    private static final SelenideElement ADD_WORKOUT_BUTTON = findElementById("saveButton");

    public void addNewQuick(Quick quick) {
        DATE_INPUT.setValue(quick.getWorkoutDate());
        TIME_OF_DAY.setValue(quick.getWorkoutTime());
        ACTIVITY_TYPE_SELECT.shouldBe(Condition.visible).selectOption(quick.getActivityType());
        WORKOUT_NAME_INPUT.setValue(quick.getWorkoutName());
        DISTANCE_INPUT.setValue(quick.getDistance());
        DIST_TYPE_SELECT.shouldBe(Condition.visible).selectOption(quick.getDistType().getValue());
        HOW_FEEL_SELECT.shouldBe(Condition.visible).selectOption(quick.getHowFeel().getValue());
        PER_EFFORT_SELECT.shouldBe(Condition.visible).selectOption(quick.getPerEffort().getValue());
        ADD_WORKOUT_BUTTON.click();
    }
}
