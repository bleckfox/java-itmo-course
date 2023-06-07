package courseWorks.courseWork1.newVersion_07062023;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

/**
 * Фитнес клуб
 */
public class FitnessClub {
    /**
     * Максимальное количество клиентов для каждой зоны
     */
    private static final int MAX_CAPACITY = 20;

    /**
     * Список клиентов в тренажерном зале
     */
    private final Abonement[] gymAbonements;

    /**
     * Список клиентов в бассейне
     */
    private final Abonement[] poolAbonements;

    /**
     * Список клиентов на групповых занятиях
     */
    private final Abonement[] groupClassesAbonements;

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm");

    public FitnessClub() {
        this.gymAbonements = new Abonement[MAX_CAPACITY];
        this.poolAbonements = new Abonement[MAX_CAPACITY];
        this.groupClassesAbonements = new Abonement[MAX_CAPACITY];
    }

    /**
     * Регистрация абонемента в желаемой зоне
     * @param abonement Абонемент
     * @param desiredZone Желаемая зона
     */
    public void registerAbonement(Abonement abonement, ClubZoneEnum desiredZone){

        // Если нельзя попасть в зал (вывод внутри метода), то завершить процесс регистрации
        if (!canAccessToClub(abonement, desiredZone)){
            String outputMessage = "Уважаемый " +
                    abonement.getClient().getFirstName() + " " + abonement.getClient().getLastName() +
                    " вы не можете попасть в выбранную зону - '" + desiredZone.label.toLowerCase() + "'" +
                    ", т.к. ваш абонемент - '" + abonement.getAbonementType().getName() + "'"
                    + " не предусматривает эту зону.";
            System.out.println(outputMessage + "\n");
            return;
        }

        // На момент выполнения switch известно, что зал не занят, абонемент не просрочен,
        // в зону есть доступ
        boolean isRegistered = switch (desiredZone) {
            case POOL -> registerToZone(abonement, poolAbonements);
            case GYM -> registerToZone(abonement, gymAbonements);
            case GROUP_CLASSES -> registerToZone(abonement, groupClassesAbonements);
        };

        if (isRegistered){
            String outputMessage = abonement.getClient().getFirstName() + " " + abonement.getClient().getLastName()
                    + " посещает " + desiredZone.label.toLowerCase()
                    + " - дата и время посещения: " + dateTimeFormatter.format(LocalDateTime.now()) + "\n";
            System.out.println(outputMessage);
        }
        else {
            System.out.println("Извините, в зоне " + desiredZone.label + " сейчас нет свободных мест. Попробуйте прийти позже.");
        }
    }

    /**
     * Метод закрытия клуба
     */
    public void closeFitnessClub(){
        Arrays.fill(gymAbonements, null);
        Arrays.fill(poolAbonements, null);
        Arrays.fill(groupClassesAbonements, null);
    }

    /**
     * Вывод информации о посетителях клуба
     */
    public void printRegisteredClients() {
        System.out.println("Клиенты в тренажерном зале:");
        printClientsInZone(gymAbonements);
        System.out.println("Клиенты в бассейне:");
        printClientsInZone(poolAbonements);
        System.out.println("Клиенты на групповых занятиях:");
        printClientsInZone(groupClassesAbonements);
    }

    /**
     * Метода для формирования вывода о посетителях в конкретной зоне
     * @param abonements Массив абонементов
     */
    private void printClientsInZone(Abonement[] abonements){
        Arrays.stream(abonements)
                .filter(Objects::nonNull)
                // .filter(abonement -> abonement != null)
                .forEach(abonement -> {
                    System.out.println(
                            abonement.getClient().getFirstName()
                                    + " " + abonement.getClient().getLastName()
                                    + " - " + abonement.getClient().getBirthDate() + "\n");
                });
    }

    /**
     * Метод добавления абонемента в массив
     * @param abonement Абонемент, который нужно добавить
     * @param abonements Массив абонементов
     * @return Признак добавился ли абонемент в массив (true или false)
     */
    private boolean registerToZone(Abonement abonement, Abonement[] abonements){
        for (int i = 0; i < MAX_CAPACITY; i++) {
            if (abonements[i] == null){
                abonements[i] = abonement;
                return true;
            }
        }
        return false;
    }

    /**
     * Метод проверки доступа в зал
     * @param abonement Абонемент
     * @param desiredZone Желаемая зона
     * @return Можно ли пройти (true или false)
     */
    private boolean canAccessToClub(Abonement abonement, ClubZoneEnum desiredZone){
        if (abonement.getEndDate().isBefore(LocalDate.now())){
            System.out.println("Абонемент просрочен!");
            return false;
        }

        if (isAbonementRegistered(abonement)){
            System.out.println("Абонемент уже зарегистрирован в другой зоне! Сначала необходимо выйти!");
            return false;
        }

        boolean canAccess = abonement.getAbonementType().getAccessedZones().contains(desiredZone);

        if (!canAccess){
            System.out.println(
                    "У вас " + abonement.getAbonementType().getName().toLowerCase()
                    + " абонемент. По нему вход в желаемую зону '" + desiredZone.label.toLowerCase()
                    + "' невозможен"
            );
            return false;
        }

        return true;
    }

    /**
     * Содержится ли абонемент в какой-либо из зон
     * @param abonement Абонемент
     * @return Признак содержания (true или false)
     */
    private boolean isAbonementRegistered(Abonement abonement){
        return Arrays.asList(gymAbonements).contains(abonement)
                || Arrays.asList(poolAbonements).contains(abonement)
                || Arrays.asList(groupClassesAbonements).contains(abonement);
    }
}
