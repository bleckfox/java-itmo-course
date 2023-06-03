package homeWorks.homeWork05;

import homeWorks.homeWork03.Helper;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task6 {
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

        int[] array = new int[arraySize];

        Random random = new Random();

        for (int i = 0; i < arraySize; i++) {
            int rand = random.nextInt(100) * (random.nextBoolean() ? -1 : 1);
            array[i] = rand;
        }

        System.out.println("Исходный массив");
        for (int item : array) {
            System.out.println(item);
        }

        int positiveValuesNum = (int) Arrays.stream(array).filter(i -> i >= 0).count();
        int negativeValuesNum = (int) Arrays.stream(array).filter(i -> i < 0).count();
        System.out.printf("Количество положительных элементов -> %d\n", positiveValuesNum);
        System.out.printf("Количество отрицательных элементов -> %d\n", negativeValuesNum);

        // Просто пустая строка
        System.out.println();

        System.out.println("Массив только отрицательных целых чисел");
        int[] negativeArray = new int[negativeValuesNum];
        int index = 0;

        for (int item: array){
            if (item < 0){
                negativeArray[index] = item;
                index++;
            }
        }

        // Вывод значений массива
        for (int item : negativeArray) {
            System.out.println(item);
        }
    }
}
