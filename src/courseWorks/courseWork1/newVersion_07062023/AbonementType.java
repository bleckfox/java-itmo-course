package courseWorks.courseWork1.newVersion_07062023;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Класс для типов абонементов
 */
public class AbonementType {
    /**
     * Название
     */
    private final String name;
    /**
     * Время открытия
     */
    private final LocalTime openTime;
    /**
     * Время закрытия (когда нельзя приходить)
     */
    private final LocalTime closeTime;

    /**
     * Массив доступных зон в клубе
     */
    private final ArrayList<ClubZoneEnum> accessedZones;

    public AbonementType(
            String name,
            LocalTime openTime,
            LocalTime closeTime,
            ArrayList<ClubZoneEnum> clubZones) {
        this.name = name;
        this.openTime = openTime;
        this.closeTime = closeTime;
        accessedZones = clubZones;
    }

    public void getAbonementInfo(){
        System.out.println(
                "Тип абонемента: " + name + "\n" +
                "Время посещения: " + openTime + " - " + closeTime
                + "Доступные зоны:"
        );
        accessedZones.forEach(zone -> System.out.println("\t" + zone.label.toLowerCase()));
    }

    public String getName() {
        return name;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public ArrayList<ClubZoneEnum> getAccessedZones() {
        return accessedZones;
    }
}
