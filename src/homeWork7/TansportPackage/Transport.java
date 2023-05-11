package homeWork7.TansportPackage;

import homeWork7.HelperPackage.Helper;

/**
 * Абстрактный класс транспорта
 */
abstract public class Transport {

    /**
     * Уровень износа
     */
    protected int damage;

    /**
     * Регистрационный номер (нельзя изменить)
     */
    protected final String registerNumber;

    /**
     * Цвет транспорта
     */
    protected String color;

    protected Transport(String registerNumber, String color) {
        Helper.checkNullOrEmpty(registerNumber, "Введите регистрационный номер");
        this.registerNumber = registerNumber;

        Helper.checkNullOrEmpty(color, "Введите цвет автомобиля!");
        this.color = color;
    }

    protected Transport(int damage, String registerNumber, String color){
        Helper.checkNullOrEmpty(registerNumber, "Введите регистрационный номер");
        this.registerNumber = registerNumber;

        Helper.checkNullOrEmpty(color, "Введите цвет автомобиля!");
        this.color = color;

        Helper.checkTansportDamaged(damage);
        this.damage = damage;
    }

    abstract public void repair();

    /**
     * Установка знаечния уровня износа
     * @param damage Новое значение
     */
    public void setDamage(int damage){
        Helper.checkTansportDamaged(damage);
        this.damage = damage;
    };

    /**
     * Получение уровня износа
     * @return Текущий уровень износа
     */
    public int getDamage(){ return this.damage; }

    /**
     * Получение регистрационного номера
     * @return Текущий регистрационный номер
     */
    public String getRegisterNumber() { return this.registerNumber; }

    /**
     * Получение цвета
     * @return текущий цвет
     */
    public String getColor() { return this.color; }

}
