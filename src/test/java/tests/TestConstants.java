package tests;

import java.time.format.DateTimeFormatter;

public interface TestConstants {
    DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("M/d" +
            "/yyyy");
}
