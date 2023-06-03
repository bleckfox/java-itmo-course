package homeWorks.homeWork06.ProductEntities;

/**
 * Модель продукта
 */
public class Product {
    /**
     * Название
     */
    private String name;

    /**
     * Белки
     */
    private double protein;

    /**
     * Жиры
     */
    private double fat;

    /**
     * Углеводы
     */
    private double carbohydrate;

    /**
     * Калории
     */
    private double calorie;


    public Product(){
        System.out.println("Создан новый  продукт. Заполните свойства.");
    }

    public Product(String name){
        setName(name);
    }

    public Product(String name, double calorie){
        setName(name);
        setCalorie(calorie);
    }

    public Product(String name, double protein,
                   double fat, double carbohydrate,
                   double calorie)
    {
        setName(name);
        setProtein(protein);
        setFat(fat);
        setCarbohydrate(carbohydrate);
        setCalorie(calorie);
    }


    /**
     * Получение названия
     * @return Название
     */
    public String getName() {
        return name;
    }

    /**
     * Установка названия
     * @param name Новое название
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получение значения белков
     * @return Значение белков
     */
    public double getProtein() {
        return protein;
    }

    /**
     * Установка значения белков
     * @param protein Новое значение
     */
    public void setProtein(double protein) {
        this.protein = protein;
    }

    /**
     * Получение значения жиров
     * @return Значение жиров
     */
    public double getFat() {
        return fat;
    }

    /**
     * Установка значения жиров
     * @param fat Новое значение
     */
    public void setFat(double fat) {
        this.fat = fat;
    }

    /**
     * Получение значения углеводов
     * @return Значение углеводов
     */
    public double getCarbohydrate() {
        return carbohydrate;
    }

    /**
     * Установка значения углеводов
     * @param carbohydrate Новое значение
     */
    public void setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    /**
     * Получение значения калорий
     * @return Значение калорий
     */
    public double getCalorie() {
        return calorie;
    }

    /**
     * Установка значения калорий
     * @param calorie Новое значение
     */
    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }
}
