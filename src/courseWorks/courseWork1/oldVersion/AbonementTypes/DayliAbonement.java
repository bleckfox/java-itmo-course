package courseWorks.courseWork1.oldVersion.AbonementTypes;

import java.time.LocalTime;

public class DayliAbonement extends  AbonementType{
    public DayliAbonement() {
        super("Дневной",
                LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0),
                true, false, true);
    }
}
