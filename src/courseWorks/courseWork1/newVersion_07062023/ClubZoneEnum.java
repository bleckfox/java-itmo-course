package courseWorks.courseWork1.newVersion_07062023;

public enum ClubZoneEnum {
    GYM ("Тренажерный зал"),
    POOL ("Бассейн"),
    GROUP_CLASSES ("Групповые занятия");

    public final String label;

    ClubZoneEnum(String label){
        this.label = label;
    }
}
