package homeWorks.homeWork06;

import homeWorks.homeWork06.MountainEntities.*;

public class Task1 {
    public static void main(String[] args) {

        // задание про альпинистов
        // Горы
        Mountain caucasian = new Mountain(
                "Кавказские горы", "Россия", 5642
        );

        Mountain altai = new Mountain(
                "Алтайские горы", "Россия", 5642
        );

        Mountain ural = new Mountain(
                "Уральские горы", "Россия", 1895
        );

        // Альпинисты
        Climber tom = new Climber(
                "Tom Ford", "New York, Bulls ave. 156"
        );

        Climber james = new Climber(
                "James Brown", "Ohio, Jackson street 16"
        );

        Climber charles = new Climber(
                "Charles Xavier", "New York, Salem Center, Graymalkin Lane 1407"
        );

        // Группы
        ClimbingGroup group1 = new ClimbingGroup(caucasian);
        ClimbingGroup group2 = new ClimbingGroup(altai);
        ClimbingGroup group3 = new ClimbingGroup(ural);

        group1.addClimber(tom);
        group1.addClimber(james);
        group1.addClimber(charles);

        group1.isRecruiting(false);


        group2.addClimber(tom);
        group2.addClimber(charles);

        group3.addClimber(james);
        group3.addClimber(charles);

        group1.getClimbers();
    }
}
