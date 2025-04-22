package object;

import com.github.javafaker.Faker;
import enums.DistType;
import enums.HowFeel;
import enums.PerceivedEffort;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Full {
    private String workoutDate;
    private String workoutTime;
    private String workoutName;
    private String distance;
    private DistType distType;
    private String elevationGain;
    private String elevationLoss;
    private HowFeel howFeel;
    private PerceivedEffort perEffort;

    public Full(String workoutDate, String workoutTime, String workoutName, String distance,
                DistType distType, String elevationGain, String elevationLoss, HowFeel howFeel,
                PerceivedEffort perEffort) {
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
