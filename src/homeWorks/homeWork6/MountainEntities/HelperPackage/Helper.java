package homeWorks.homeWork6.MountainEntities.HelperPackage;

/**
 * Класс Helper для типовых операций
 */
public class Helper {

    /**
     * Метод проверки на null и длину строки
     * @param parameter Проверяемое свойство (строка)
     * @param length Требуемая длина строки
     * @param exceptionMessage Сообщение об ошибке
     */
    public static void checkNullOrLength(String parameter, int length, String exceptionMessage){
        if (parameter == null || parameter.length() < length){
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
