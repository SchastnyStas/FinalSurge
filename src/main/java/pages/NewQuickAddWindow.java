package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import object.Quick;

import static elements.ElementExtensions.*;

public class NewQuickAddWindow extends BasePage {

    public static final SelenideElement DATE_INPUT = getInputByName("WorkoutDate");
    public static final SelenideElement TIME_OF_DAY = getInputByName("WorkoutTime");
    public static final SelenideElement WORKOUT_NAME_INPUT = getInputByName("Name");
    public static final SelenideElement DISTANCE_INPUT = getInputByName("Distance");
    public static final SelenideElement ACTIVITY_TYPE_SELECT = getSelectById("ActivityType");
    public static final SelenideElement DIST_TYPE_SELECT = getSelectById("DistType");
    public static final SelenideElement HOW_FEEL_SELECT = getSelectById("HowFeel");
    public static final SelenideElement PER_EFFORT_SELECT = getSelectById("PerEffort");
    public static final SelenideElement ADD_WORKOUT_BUTTON = getButtonById("saveButton");

    public void addNewQuick(Quick quick) {
        DATE_INPUT.setValue(quick.getWorkoutDate());

        TIME_OF_DAY.setValue(quick.getWorkoutTime());

        ACTIVITY_TYPE_SELECT.shouldBe(Condition.visible).selectOption(quick.getActivityType());

        WORKOUT_NAME_INPUT.setValue(quick.getWorkoutName());

        DISTANCE_INPUT.setValue(quick.getDistance());

        DIST_TYPE_SELECT.shouldBe(Condition.visible).selectOption(quick.getDistType());

        HOW_FEEL_SELECT.shouldBe(Condition.visible).selectOption(quick.getHowFeel());

        PER_EFFORT_SELECT.shouldBe(Condition.visible).selectOption(quick.getPerEffort());

        ADD_WORKOUT_BUTTON.click();

    }
}
