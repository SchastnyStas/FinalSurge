package enums;

import lombok.Getter;

@Getter
public enum DistType {
    MI("mi"),
    KM("km"),
    M("m"),
    YD("yd");

    private final String value;

    DistType(String value) {
        this.value = value;
    }
}