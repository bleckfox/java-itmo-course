package homeWorks.homeWork14.task1;

import java.util.ArrayList;
import java.util.List;

public class FruitStorage {
    private ArrayList<Fruit> fruits;

    private int numberOfFruits;

    /**
     * Содержит значение общей стоимости фруктов, определяемой, как количество * цена за шт.
     */
    private double fruitsPrice;

    public FruitStorage() {
        fruits = new ArrayList<>();
    }

    /**
     * Метод добавления фрукта в хранилище
     * @param newFruit Новый фрукт
     * @return Признак удалось ли добавить
     */
    public boolean addFruit(Fruit newFruit){
        if (newFruit == null || fruits.contains(newFruit)) return false;

        for (Fruit fruit : fruits) {
            if (fruit.equals(newFruit)){
                fruit.setCount(fruit.getCount() + newFruit.getCount());

                setNumberOfFruits(newFruit.getCount());
                setFruitsPrice(newFruit.getPrice() * newFruit.getCount());

                return true;
            }
        }

        fruits.add(newFruit);

        setNumberOfFruits(newFruit.getCount());
        setFruitsPrice(newFruit.getPrice() * newFruit.getCount());

        return true;
    }

    /**
     * Метод получения количества фруктов определенного типа
     * @param fruitType Тип фрукта
     * @return Количество фруктов заданного типа в хранилище
     */
    public int getNumberOfFruitsByType(FruitType fruitType){
        if (fruits.size() == 0) return 0;
        int count = 0;
        for (Fruit fruit : fruits) {
            if (fruit.getType() == fruitType) {
                count += fruit.getCount();
            }
        }
        return count;
    }

    /**
     * Метод получения всех фруктов хранилища
     * @return Количество фруктов
     */
    public int getNumberOfFruits(){
        return this.numberOfFruits;
    }

    /**
     * Метод увеличения счетчика фруктов в хранилище
     * @param numberOfFruits Добавленное количество фруктов
     */
    private void setNumberOfFruits(int numberOfFruits){
        this.numberOfFruits += numberOfFruits;
    }

    /**
     * Метод увеличения стоимости фрукта
     * @param value Процентное значение увеления цены [10, 30)
     * @return Признак удалось ли увеличить
     */
    public boolean increasePrice(int value){
        if (value < 10 || value >= 30) {
            throw new IllegalArgumentException("Некорректное значение value. Допустимый диапазон: [10; 30)");
        }

        double percent = 1 + ((double) value / 100);

        // Обнуляю значение счетчика стоимости
        this.fruitsPrice = 0;

        for (Fruit fruit : fruits) {
            fruit.setPrice(fruit.getPrice() * percent);
            // обновление счетчика стоимости с учетом повышения цены
            setFruitsPrice(fruit.getPrice() * fruit.getCount());
        }

        return true;
    }

    /**
     * Метод получения общей стоимости всех фруктов в хранилище
     * @return Общая стоимость фруктов
     */
    public double getFruitsPrice() {
        return this.fruitsPrice;
    }

    public void setFruitsPrice(double fruitPrice) {
        this.fruitsPrice += fruitPrice;
    }

    /**
     * Возвращает список, в который войдут фрукты из коллекции
     * fruits с типом fruitType и ценой не выше maxPrice
     * @param type Тип фрукта
     * @param maxPrice Максимальная цена
     * @return Список, в который войдут фрукты из коллекции
     */
    public List<Fruit> getFruitsByTypeAndPrice(FruitType type, int maxPrice){
        if (maxPrice <= 0){
            throw new IllegalArgumentException("Некорректное значение maxPrice. Значение должно быть положительным.");
        }

        List<Fruit> result = new ArrayList<>();

        for (Fruit fruit :  fruits) {
            if (fruit.getType() == type && fruit.getPrice() <= maxPrice){
                result.add(fruit);
            }
        }

        return result.size() == 0 ? null : result;
    }
}
