package homeWorks.homeWork03;

import java.util.Scanner;

public class Helper {
    /**
     * Метод проверки типа числа
     * @param value значение
     * @return является ли число целым типом
     */
    private static boolean isInt(String value){
        try {
            Integer.parseInt(value);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    /**
     * Метод получения положительного целого числа, введенного пользователем
     * @param scanner сканнер ввода
     * @return введенное число
     */
    public static int getPositiveUserInput(Scanner scanner){
        if (scanner != null){
            var input = scanner.next();

            if(isInt(input)){
                return Integer.parseInt(input);
            }

            return -1;
        }
        return -1;
    }
}
