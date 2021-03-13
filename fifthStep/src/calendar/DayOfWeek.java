package calendar;

public enum DayOfWeek {

    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public static DayOfWeek getDay(int i) {
        return switch (i) {
            case 1 -> SUNDAY;
            case 2 -> MONDAY;
            case 3 -> TUESDAY;
            case 4 -> WEDNESDAY;
            case 5 -> THURSDAY;
            case 6 -> FRIDAY;
            case 7 -> SATURDAY;
            default -> null;
        };
    }
}
