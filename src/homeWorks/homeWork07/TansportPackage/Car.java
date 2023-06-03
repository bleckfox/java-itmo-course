package homeWorks.homeWork07.TansportPackage;

import homeWorks.homeWork07.HelperPackage.Helper;
import homeWorks.homeWork07.TansportPackage.interfaces.ITransport;

/**
 * Класс автомобиля
 */
public class Car extends Transport implements ITransport {

    public Car(String registerNumber, String color) {
        super(registerNumber, color);
    }

    public Car(int damage, String registerNumber, String color){
        super(damage, registerNumber, color);
    }

    /**
     * Метод ремонта для автомобиля
     */
    @Override
    public void repair() {
        this.damage = defaultRepair(this.damage);
    }

    /**
     * Установка цвета автомобиля
     * @param color Новый цвет
     */
    public void setColor(String color){
        Helper.checkNullOrEmpty(color, "Введите цвет автомобиля!");
        this.color = color;
    }

}
