package homeWorks.homeWork06.MountainEntities;

import homeWorks.homeWork06.MountainEntities.HelperPackage.Helper;

/**
 * Модель альпиниста
 */
public class Climber {
    /**
     * Имя
     */
    private String name;

    /**
     * Адрес проживания
     */
    private String address;

    public Climber(){
        System.out.println("Новый альпинист. Задайте свойства");
    }

    public Climber(String name, String address){
        setName(name);
        setAddress(address);
    }

    /**
     * Получение имени
     * @return Имя
     */
    public String getName(){
        return name;
    }

    /**
     * Получение адреса
     * @return Адрес
     */
    public String getAddress(){
        return address;
    }

    /**
     * Установка значения имени
     * @param name Новое имя
     */
    public void setName(String name){
        Helper.checkNullOrLength(name, 3, "Имя должно быть не короче 3 букв");

        this.name = name;
    }

    /**
     * Установка значения адреса
     * @param address Новый адрес
     */
    public void setAddress(String address){
        Helper.checkNullOrLength(address, 5, "Адрес должен быть не короче 5 букв");

        this.address = address;
    }

}
