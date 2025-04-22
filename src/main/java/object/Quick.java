package object;

import com.github.javafaker.Faker;
import enums.DistType;
import enums.HowFeel;
import enums.PerceivedEffort;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Quick {
    private String workoutDate;
    private String workoutTime;
    private String activityType;
    private String workoutName;
    private String distance;
    private DistType distType;
    private HowFeel howFeel;
    private PerceivedEffort perEffort;

    public Quick(String workoutDate, String workoutTime, String activityType, String workoutName, String distance,
                 DistType distType, HowFeel howFeel, PerceivedEffort perEffort) {
        this.workoutDate = workoutDate;
        this.workoutTime = workoutTime;
        this.activityType = activityType;
        this.workoutName = (workoutName == null || workoutName.isEmpty()) ? new Faker().lorem().word() : workoutName;
        this.distance = (distance == null || distance.isEmpty()) ? String.valueOf(new Faker().number().numberBetween(1, 101)) : distance;
        this.distType = distType;
        this.howFeel = howFeel;
        this.perEffort = perEffort;
    }
}

