package homeWorks.homeWork10;

/**
 * Часовые пояса
 */
public enum TimeZone {

    SYDNEY("Australia/Sydney"),
    HOUSTON("America/Chicago"),
    WASHINGTON("America/New_York"),
    OTTAWA("America/Toronto");

    public final String label;

    TimeZone(String label) {
        this.label = label;
    }
}
