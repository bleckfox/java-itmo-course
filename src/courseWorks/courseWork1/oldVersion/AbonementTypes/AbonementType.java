package courseWorks.courseWork1.oldVersion.AbonementTypes;

import java.time.LocalTime;

/**
 * Абстрактный класс для типов абонементов
 */
public abstract class AbonementType {
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
     * Можно ли посещать тренажерный зал
     */
    private final boolean hasAccessToGym;
    /**
     * Можно ли посещать бассейн
     */
    private final boolean hasAccessToPool;
    /**
     * Можно ли посещать групповые занятия
     */
    private final boolean hasAccessToGroupClass;


    public AbonementType(String name,
                            LocalTime openTime,
                            LocalTime closeTime,
                            boolean hasAccessToGym,
                            boolean hasAccessToPool,
                            boolean hasAccessToGroupClass) {
        this.name = name;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.hasAccessToGym = hasAccessToGym;
        this.hasAccessToPool = hasAccessToPool;
        this.hasAccessToGroupClass = hasAccessToGroupClass;
    }

    public void getAbonementInfo(){
        String canAccessGym =  hasAccessToGym ? "да" : "нет";
        String canAccessPool =  hasAccessToPool ? "да" : "нет";
        String canAccessGroupClass =  hasAccessToGroupClass ? "да" : "нет";

        System.out.println(
                "Тип абонемента: " + name + "\n" +
                "Время посещения: " + openTime + " - " + closeTime + "\n" +
                "Можно ли посещать тренажерный зал: " + canAccessGym + "\n" +
                "Можно ли посещать тренажерный бассейн: " + canAccessPool + "\n" +
                "Можно ли посещать тренажерный групповый занятия: " + canAccessGroupClass
        );
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

    public boolean isHasAccessToGym() {
        return hasAccessToGym;
    }

    public boolean isHasAccessToPool() {
        return hasAccessToPool;
    }

    public boolean isHasAccessToGroupClass() {
        return hasAccessToGroupClass;
    }
}
