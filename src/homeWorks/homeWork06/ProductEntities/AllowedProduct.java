package homeWorks.homeWork06.ProductEntities;

import java.util.ArrayList;

/**
 * Модель разрешенных продуктов
 */
public class AllowedProduct {
    /**
     * Максимальное количество белков
     */
    private int maxProtein;

    /**
     * Максимальное количество жиров
     */
    private int maxFat;

    /**
     * Максимальное количество углеводов
     */
    private int maxCarbohydrate;

    /**
     * Максимальное количество калорий
     */
    private int maxCalorie;

    /**
     * Список продуктов
     */
    private final ArrayList<Product> products = new ArrayList<>();

    public AllowedProduct(){
        System.out.println("Список создан. Заполните свойства.");
    }

    public AllowedProduct(int maxProtein, int maxFat, int maxCarbohydrate, int maxCalorie) {
        setMaxProtein(maxProtein);
        setMaxFat(maxFat);
        setMaxCarbohydrate(maxCarbohydrate);
        setMaxCalorie(maxCalorie);
    }

    /**
     * Получение максимального количества белков
     * @return Максимальное количество белков
     */
    public int getMaxProtein() {
        return maxProtein;
    }

    /**
     * Установка максимального количества белков
     * @param maxProtein Новое значение
     */
    public void setMaxProtein(int maxProtein) {
        this.maxProtein = maxProtein;
    }

    /**
     * Получение максимального количества жиров
     * @return Максимальное количество жиров
     */
    public int getMaxFat() {
        return maxFat;
    }

    /**
     * Установка максимального количества жиров
     * @param maxFat Новое значение
     */
    public void setMaxFat(int maxFat) {
        this.maxFat = maxFat;
    }

    /**
     * Получение максимального количества углеводов
     * @return Максимальное количество углеводов
     */
    public int getMaxCarbohydrate() {
        return maxCarbohydrate;
    }

    /**
     * Установка максимального количества углеводов
     * @param maxCarbohydrate Новое значение
     */
    public void setMaxCarbohydrate(int maxCarbohydrate) {
        this.maxCarbohydrate = maxCarbohydrate;
    }

    /**
     * Получение максимального количества калорий
     * @return Максимальное количество калорий
     */
    public int getMaxCalorie() {
        return maxCalorie;
    }

    /**
     * Установка максимального количества калорий
     * @param maxCalorie Новое значение
     */
    public void setMaxCalorie(int maxCalorie) {
        this.maxCalorie = maxCalorie;
    }

    /**
     * Получение списка продуктов
     */
    public void getProductList() {
        System.out.println("Продукты в списке:");
        System.out.println("Название\tБелки\tЖиры\tУглеводы\tКалории");
        for (var product : products) {
            System.out.printf("%s\t%.2f\t%.2f\t%.2f\t%.2f\n",
                    product.getName(),
                    product.getProtein(),
                    product.getFat(),
                    product.getCarbohydrate(),
                    product.getCalorie()
            );
        }
    }

    /**
     * Добавление продукта в список
     * @param product Новый продукт
     */
    public void addProduct(Product product) {
        if (product.getProtein() > maxProtein){
            System.out.printf("Количество белков не более %d", maxProtein);
            throw new IllegalArgumentException("Слишком большое количество белков");
        } else if (product.getFat() > maxFat) {
            System.out.printf("Количество жиров не более %d", maxFat);
            throw new IllegalArgumentException("Слишком большое количество жиров");
        } else if (product.getCarbohydrate() > maxCarbohydrate) {
            System.out.printf("Количество углеводов не более %d", maxCarbohydrate);
            throw new IllegalArgumentException("Слишком большое количество углеводов");
        } else if (product.getCalorie() > maxCalorie) {
            System.out.printf("Количество калорий не более %d", maxCalorie);
            throw new IllegalArgumentException("Слишком большое количество калорий");
        }

        this.products.add(product);

        System.out.println("Продукт добавлен");
    }
}
