package courseWorks.courseWork1;

import courseWorks.courseWork1.AbonementTypes.DayliAbonement;
import courseWorks.courseWork1.AbonementTypes.FullAbonement;
import courseWorks.courseWork1.AbonementTypes.OneTimeAbonement;

import java.time.LocalDate;
import java.time.LocalTime;

public class Application {
    public static void main(String[] args) {

        // с точки зрения расхода памяти - было бы лучше один раз объявить класс для типа абонемента и указывать его
        // или каждый раз создать новый экземпляр типа абонемента ???
        // -свойства для этих классов final
        OneTimeAbonement oneTimeAbonement = new OneTimeAbonement();
        DayliAbonement dayliAbonement = new DayliAbonement();
        FullAbonement fullAbonement = new FullAbonement();

        Client client01 = new Client("Иван", "Иванов", LocalDate.of(1985, 5, 15));
        Client client02 = new Client("Петр", "Петров", LocalDate.of(1995, 12, 10));
        Client client03 = new Client("Игорь", "Азаров", LocalDate.of(1985, 1, 25));
        Client client04 = new Client("Юлия", "Гончарова", LocalDate.of(1985, 6, 3));
        Client client05 = new Client("Ирина", "Батурина", LocalDate.of(1985, 10, 1));

        Abonement abonement01 = new Abonement(1,
                LocalDate.of(2023, 5,25),
                LocalDate.of(2023, 5, 25),
                oneTimeAbonement,
                client01);
        Abonement abonement02 = new Abonement(1,
                LocalDate.of(2023, 5,25),
                LocalDate.of(2023, 5, 25),
                oneTimeAbonement,
                client02);
        Abonement abonement03 = new Abonement(1,
                LocalDate.of(2023, 5,25),
                LocalDate.of(2023, 6, 25),
                dayliAbonement,
                client03);
        Abonement abonement04 = new Abonement(1,
                LocalDate.of(2023, 5,25),
                LocalDate.of(2023, 10, 25),
                fullAbonement,
                client04);
        Abonement abonement05 = new Abonement(1,
                LocalDate.of(2023, 5,25),
                LocalDate.of(2023, 7, 25),
                dayliAbonement,
                client05);

        FitnessClub club = new FitnessClub();


    }
}
