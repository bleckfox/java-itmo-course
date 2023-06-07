package courseWorks.courseWork1.newVersion_07062023;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public enum AbonementTypeEnum {
    ONETIME ("Разовый",
            LocalTime.of(8, 0, 0),
            LocalTime.of(22,0,0),
            new ArrayList<>(Arrays.asList(ClubZoneEnum.GYM, ClubZoneEnum.POOL))
    ),
    DAILY ("Дневной",
            LocalTime.of(8, 0, 0),
            LocalTime.of(16, 0, 0),
            new ArrayList<>(Arrays.asList(ClubZoneEnum.GYM, ClubZoneEnum.GROUP_CLASSES))
    ) ,
    FULL ("Полный",
            LocalTime.of(8, 0, 0),
            LocalTime.of(22, 0, 0),
            new ArrayList<>(Arrays.asList(ClubZoneEnum.GYM, ClubZoneEnum.POOL, ClubZoneEnum.GROUP_CLASSES))
    );

    private final AbonementType abonementType;
    
    AbonementTypeEnum(String name,
                      LocalTime openTime,
                      LocalTime closeTime,
                      ArrayList<ClubZoneEnum> clubZones){
        this.abonementType = new AbonementType(
                name, openTime, closeTime, clubZones);
    }
    
    public AbonementType getAbonementType(){
        return abonementType;
    }

}