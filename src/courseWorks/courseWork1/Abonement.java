package courseWorks.courseWork1;

import courseWorks.courseWork1.AbonementTypes.AbonementType;

import java.time.LocalDate;

/**
 * Абонемент клуба
 */
public class Abonement {
    private final int number;
    private final LocalDate registrationDate;
    private final LocalDate endDate;
    private AbonementType abonementType;
    private final Client client;

    public Abonement(int number, LocalDate registrationDate, LocalDate endDate, AbonementType abonementType, Client client){
        this.number = number;
        this.registrationDate = registrationDate;
        this.endDate = endDate;
        this.client = client;
        setAbonementType(abonementType);
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
    public void setAbonementType(AbonementType abonementType) {
        this.abonementType = abonementType;
    }

    /**
     * Метод получения информации о владельце абонемента
     * @return Информация о посетителе
     */
    public Client getClient() {
        return client;
    }
}
