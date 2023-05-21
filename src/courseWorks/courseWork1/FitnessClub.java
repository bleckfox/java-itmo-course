package courseWorks.courseWork1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * Фитнес клуб
 */
public class FitnessClub {
    private static final int MAX_CAPACITY = 20;
    private Abonement[] gymAbonements;
    private Abonement[] poolAbonements;
    private Abonement[] groupClassesAbonements;
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
    public void registerAbonement(Abonement abonement, ClubZones desiredZone){

        // Если нельзя попасть в зал (вывод внутри метода), то завершить процесс регистрации
        if (!canAccessToClub(abonement, desiredZone)){
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
            Client client = abonement.getClient();
            System.out.println(
                    client.getLastName() + " " + client.getFirstName() + " посещает " +
                            desiredZone + " в " + LocalDateTime.now().format(dateTimeFormatter)
            );
        }
        else {
            System.out.println("Извините, в зоне " + desiredZone + " сейчас нет свободных мест. Попробуйте прийти позже.");
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
        Client client;

        for (Abonement abonement: abonements) {
            if (abonement != null){
                client = abonement.getClient();

                System.out.println(
                        client.getFirstName() + " " + client.getLastName() + " - " + client.getBirthDate()
                );
            }
        }
    }

    /**
     * Метод проверки доступа в зал
     * @param abonement Абонемент
     * @param desiredZone Желаемая зона
     * @return Можно ли пройти (true или false)
     */
    private boolean canAccessToClub(Abonement abonement, ClubZones desiredZone){

        if (abonement.getEndDate().isBefore(LocalDate.now())){
            System.out.println("Абонемент просрочен!");
            return false;
        }

        if (isAbonementRegistered(abonement)){
            System.out.println("Абонемент уже зарегистрирован в другой зоне! Сначала необходимо выйти!");
            return false;
        }

        // Проверяем, можно ли посещать желаемую зону
        boolean canAccess = switch (desiredZone) {
            case POOL -> abonement.getAbonementType().isHasAccessToPool();
            case GYM -> abonement.getAbonementType().isHasAccessToGym();
            case GROUP_CLASSES -> abonement.getAbonementType().isHasAccessToGroupClass();
            default -> false;
        };

        if (!canAccess) {
            System.out.println("У вас " + abonement.getAbonementType().getName().toLowerCase()
                    + "абонемент. По нему вход в желаемую зону невозможен!");
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
