package courseWorks.courseWork1.AbonementTypes;

import java.time.LocalTime;

public class OneTimeAbonement extends AbonementType {
    public OneTimeAbonement() {
        super("Разовый",
                LocalTime.of(8, 0, 0),
                LocalTime.of(22, 0, 0),
                true, true, false);
    }
}
