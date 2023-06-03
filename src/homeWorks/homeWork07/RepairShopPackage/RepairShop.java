package homeWorks.homeWork07.RepairShopPackage;

import homeWorks.homeWork07.HelperPackage.Helper;
import homeWorks.homeWork07.TansportPackage.Car;
import homeWorks.homeWork07.TansportPackage.Transport;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс ремонтной мастерской
 */
public class RepairShop {

    /**
     * Массив транспортных средств
     */
    private final ArrayList<Transport> transports = new ArrayList<>();

    /**
     * Массив названия цветов красок
     */
    private final ArrayList<String> colorSchemes = new ArrayList<>(
            List.of("синий", "зеленый", "красный", "желтый", "голубой", "коричневый", "фиолетовый")
    );

    public RepairShop(ArrayList<String> colors){
        for (var color : colors) {
            addColorScheme(color);
        }
    }

    public RepairShop(String color){
        addColorScheme(color);
    }

    /**
     * Ремонт всех транспортных средств в массиве
     */
    public void doRepair(){
        if (transports.size() > 0){
            for (var transport: this.transports ) {
                transport.repair();
                if (transport instanceof Car){
                    String newColor = setNewColor();
                    // Пока полученный случайным образом цвет, равен текущему цвету автомобиля
                    // Продолжим попытки получить новый цвет
                    while (((Car) transport).getColor().equals(newColor)){
                        newColor = setNewColor();
                    }
                    // Покраска автомобиля новым цветом
                    ((Car) transport).setColor(newColor);
                }

            }
            transports.removeAll(transports);
        }
    }

    /**
     * Метод получения нового цвета для покраски
     * @return Новый цвет
     */
    public String getNewColor(){
        return setNewColor();
    }

    /**
     * Метод получения нового цвета
     * @return Новый цвет
     */
    private String setNewColor(){
        int colorNumber = Helper.getRandomNumber(0, colorSchemes.size() - 1);
        return colorSchemes.get(colorNumber);
    }

    /**
     * Метод получения массива траспортных средств в ремонте
     * @return Массив траспортных средств в ремонте
     */
    public ArrayList<Transport> getTransports() {
        return this.transports;
    }

    /**
     * Метод получения массива названий цветов красок
     * @return Массив названий цветов красок
     */
    public ArrayList<String> getColorSchemes() {
        return this.colorSchemes;
    }

    /**
     * Метод добавления цвета в массив
     * @param color Новый цвет
     */
    public void addColorScheme(String color){
        Helper.checkNullOrEmpty(color, "Введите название цвета");
        if (!color.contains(color)){
            colorSchemes.add(color.toLowerCase());
        }
    }

    /**
     * Метод добавления транспорта в массив
     * @param transport Новый транспорт
     */
    public void addTransport(Transport transport){
        if (transport == null){
            throw new IllegalArgumentException("Укажите транспортное средство!");
        }
        // Если количество транспорта менее 10, добавим ещё
        if (this.transports.size() < 10){
            transports.add(transport);
        }
        else {
            throw new IllegalArgumentException("Количество транспорта в ремонте более 10. Нужно сначала отправить их в ремонт!");
        }
    }
}
