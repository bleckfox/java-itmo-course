package homeWorks.homeWork5;

import homeWorks.homeWork3.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean creatingArray = true;
        int arraySize = 0;

        System.out.println("Определите длину массива положительным целым числом от 1 и выше!");

        // Определение длины массива
        do {
            int input = Helper.getPositiveUserInput(scanner);

            if (input == -1 || input == 0){
                System.out.println("Определите длину массива положительным целым числом от 1 и выше!");
            } else {
                arraySize = input;
                creatingArray = false;
            }
        } while (creatingArray);

        // Создание массива и заполнение данными
        System.out.println("Массив был создан");
        List<String> array = new ArrayList<>();
        do {
            System.out.printf("Осталось заполнить элементов -> %d\n", arraySize);
            System.out.println("Введите значение...");

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")){
                break;
            }
            if (input.isEmpty() || input.isBlank() || input.equals(" ")){
                continue;
            }
            if (!array.contains(input)){
                array.add(input);
                arraySize--;
            } else {
                System.out.println("Такой элемент уже содержится в массиве!");
            }

        } while (arraySize > 0);

        System.out.println("Массив заполнен. Вот он:");

        for (var item : array) {
            System.out.println(item);
        }

    }
}
