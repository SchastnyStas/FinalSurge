package enums;

import lombok.Getter;


@Getter
public enum HowFeel {
    GREAT("Great"),
    GOOD("Good"),
    NORMAL("Normal"),
    POOR("Poor"),
    TERRIBLE("Terrible");

    private final String value;

    HowFeel(String value) {
        this.value = value;
    }
}

