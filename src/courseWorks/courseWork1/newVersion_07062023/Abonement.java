package courseWorks.courseWork1.newVersion_07062023;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Абонемент клуба
 */
public class Abonement {
    /**
     * Номер
     */
    private final int number;

    /**
     * Дата регистрации
     */
    private final LocalDate registrationDate;

    /**
     * Дата завершения
     */
    private final LocalDate endDate;

    /**
     * Тип абонемента
     */
    private AbonementType abonementType;

    /**
     * Клиент
     */
    private final Client client;

    public Abonement(int number,
                     LocalDate registrationDate,
                     LocalDate endDate,
                     AbonementTypeEnum abonementType,
                     Client client) {
        this.number = number;
        this.registrationDate = Objects.requireNonNull(registrationDate, "Необходимо указать дату регистрации");
        this.endDate = Objects.requireNonNull(endDate, "Необходимо указать дату завершения");
        this.abonementType = Objects.requireNonNull(abonementType.getAbonementType(), "Необходимо указать тип абонемента");
        this.client = Objects.requireNonNull(client, "Необходимо указать клиента");
    }

    /**
     * Метод получения информации о номере абонемента
     * @return Номер абонемента
     */
    public int getNumber() {
        return number;
    }

    /**
     * Дата регистрации (начала действия) абонемента
     * @return Дата
     */
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Дата окончания действия абонемента
     * @return Дата
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Метод получения информации о типе абонемента
     * @return Тип абонемента
     */
    public AbonementType getAbonementType() {
        return abonementType;
    }

    /**
     * Метод установки значения типа абонемента
     * @param abonementType Тип абонемента
     */
    public void setAbonementType(AbonementTypeEnum abonementType) {
        this.abonementType = abonementType.getAbonementType();
    }

    /**
     * Метод получения информации о владельце абонемента
     * @return Информация о посетителе
     */
    public Client getClient() {
        return client;
    }
}
