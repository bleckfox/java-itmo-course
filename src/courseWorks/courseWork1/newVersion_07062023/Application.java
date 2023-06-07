package courseWorks.courseWork1.newVersion_07062023;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        
        Client client01 = new Client("Иван", "Иванов", LocalDate.of(1996, 5, 15));
        Client client02 = new Client("Петр", "Петров", LocalDate.of(1995, 12, 10));
        Client client03 = new Client("Игорь", "Азаров", LocalDate.of(1989, 1, 25));
        Client client04 = new Client("Юлия", "Гончарова", LocalDate.of(1985, 6, 3));
        Client client05 = new Client("Ирина", "Батурина", LocalDate.of(1997, 10, 1));

        Abonement abonement01 = new Abonement(1,
                LocalDate.of(2023, 5,25),
                LocalDate.of(2023, 5, 25),
                AbonementTypeEnum.DAILY,
                client01);
        Abonement abonement02 = new Abonement(2,
                LocalDate.of(2023, 5,25),
                LocalDate.of(2023, 5, 25),
                AbonementTypeEnum.ONETIME,
                client02);
        Abonement abonement03 = new Abonement(3,
                LocalDate.of(2023, 5,25),
                LocalDate.of(2023, 6, 25),
                AbonementTypeEnum.DAILY,
                client03);
        Abonement abonement04 = new Abonement(4,
                LocalDate.of(2023, 5,25),
                LocalDate.of(2023, 10, 25),
                AbonementTypeEnum.FULL,
                client04);
        Abonement abonement05 = new Abonement(5,
                LocalDate.of(2023, 5,25),
                LocalDate.of(2023, 7, 25),
                AbonementTypeEnum.DAILY,
                client05);

        FitnessClub club = new FitnessClub();

        club.registerAbonement(abonement01, ClubZoneEnum.GYM);
        club.registerAbonement(abonement02, ClubZoneEnum.GROUP_CLASSES);
        club.registerAbonement(abonement03, ClubZoneEnum.POOL);
        club.registerAbonement(abonement04, ClubZoneEnum.POOL);
        club.registerAbonement(abonement05, ClubZoneEnum.GYM);

        club.printRegisteredClients();

        club.closeFitnessClub();
    }
}
