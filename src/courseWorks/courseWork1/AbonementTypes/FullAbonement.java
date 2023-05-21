package courseWorks.courseWork1.AbonementTypes;

import java.time.LocalTime;

public class FullAbonement extends AbonementType{
    public FullAbonement() {
        super("Полный",
                LocalTime.of(8, 0, 0), LocalTime.of(22, 0, 0),
                true, true, true);
    }
}
