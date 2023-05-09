package homeWork6.MountainEntities;

import homeWork6.MountainEntities.HelperPackage.Helper;

/**
 * Модель горы
 */
public class Mountain {
    /**
     * Название горы
     */
    private String name;

    /**
     * Страна, в которой гора находится
     */
    private String country;

    /**
     * Высота горы, метры
     */
    private int height;

    public Mountain(){
        System.out.println("Новая гора. Задайте свойства.");
    }

    public Mountain(String name){
        setName(name);
    }

    public Mountain(String name, int height){
        setName(name);
        setHeight(height);
    }

    public Mountain(int height){
        setHeight(height);
    }

    public Mountain(String name, String country, int height){
        setName(name);
        setCountry(country);
        setHeight(height);
    }


    /**
     * Получение названия горы
     * @return Название
     */
    public String getName(){ return name; }

    /**
     * Получение названия страны
     * @return Название
     */
    public String getCountry() { return country; }

    /**
     * Получение высоты
     * @return Высота
     */
    public int getHeight() { return height; }

    /**
     * Установка значения названия
     * @param name Новое название
     */
    public void setName(String name){
        Helper.checkNullOrLength(name, 4, "Название горы должно быть не короче 4 букв");

        this.name = name;
    }

    /**
     * Установка названия страны
     * @param country Новое название
     */
    public void setCountry(String country) {
        Helper.checkNullOrLength(country, 4, "Название страны должно быть не короче 4 букв");

        this.country = country;
    }

    /**
     * Установка высоты
     * @param height Новое значение
     */
    public void setHeight(int height){
        if (height < 100){
            throw new IllegalArgumentException("Высота горы должна быть не меньше 100 метров");
        }

        this.height = height;
    }
}
