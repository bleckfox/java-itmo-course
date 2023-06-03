package homeWorks.homeWork07.HelperPackage;

/**
 * Класс Helper для типовых операций
 */
public class Helper {

    /**
     * Метод проверки на null и пустую строку
     * @param parameter Проверяемое свойство (строка)
     * @param errorMessage Сообщение об ошибке
     */
    public static void checkNullOrEmpty(String parameter, String errorMessage){
        if (parameter == null || parameter.length() == 0){
            throw new IllegalArgumentException(errorMessage);
        }
    }

    /**
     * Метод проверки уровня износа
     * @param damage Текущий уровень износа
     */
    public static void checkTansportDamaged(int damage){
        if (damage < 0){
            throw new IllegalArgumentException("Уровень износа не может быть меньше 0");
        }
    }

    /**
     * Метод проверки количества вагонов поезда
     * @param carriage Текущее количество вагонов
     */
    public static void checkTrainCarriage(int carriage){
        if (carriage < 1){
            throw new IllegalArgumentException("Количество вагонов поезда не может быть меньше 1");
        }
    }

    /**
     * Метод генерации случайного числа в диапазоне
     * @param min Минимальное значение
     * @param max Максимальное значение
     * @return Псевдослучайное число в заданном диапазоне
     */
    public static int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }
}
