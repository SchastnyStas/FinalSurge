package object;

import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Full {

    private String workoutDate;
    private String workoutTime;
    private String workoutName;
    private String distance;
    private String distType;
    private String elevationGain;
    private String elevationLoss;
    private String howFeel;
    private String perEffort;

    public Full(String workoutDate, String workoutTime, String workoutName, String distance,
                String distType, String elevationGain, String elevationLoss, String howFeel,
                String perEffort) {
        this.workoutDate = workoutDate;
        this.workoutTime = workoutTime;
        this.workoutName = (workoutName == null || workoutName.isEmpty()) ? new Faker().lorem().word() : workoutName;
        this.distance = (distance == null || distance.isEmpty()) ? String.valueOf(new Faker().number().numberBetween(1, 101)) : distance;
        this.distType = distType;
        this.elevationGain = (elevationGain == null || elevationGain.isEmpty()) ?
                String.valueOf(new Faker().number().numberBetween(1, 101)) : elevationGain;
        this.elevationLoss = (elevationLoss == null || elevationLoss.isEmpty()) ?
                String.valueOf(new Faker().number().numberBetween(1, 101)) : elevationLoss;
        this.howFeel = howFeel;
        this.perEffort = perEffort;
    }
}
