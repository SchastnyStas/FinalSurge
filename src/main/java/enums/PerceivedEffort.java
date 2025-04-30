package enums;

import lombok.Getter;

@Getter
public enum PerceivedEffort {
    ONEVERYLIGHT("1 (Very Light)"),
    TWOLIGHT("2 (Light)"),
    THREELIGHT("3 (Light)"),
    FOURMODERATE("4 (Moderate)"),
    FIVEMODERATE("5 (Moderate)"),
    SIXMODERATE("6 (Moderate)"),
    SEVENHARD("7 (Hard)"),
    EIGHTHARD("8 (Hard)"),
    NINEVERYHARD("9 (Very Hard)"),
    TENMAXEFFORT("10 (Max Effort)");

    private final String value;

    PerceivedEffort(String value) {
        this.value = value;
    }
}
