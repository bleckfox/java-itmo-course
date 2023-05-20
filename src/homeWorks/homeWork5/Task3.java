package homeWorks.homeWork5;

import homeWorks.homeWork3.Helper;

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean working = true;

        System.out.println("Определите длину массива положительным целым числом от 1 и выше!");

        do {
            int input = Helper.getPositiveUserInput(scanner);

            if (input == -1 || input == 0){
                System.out.println("Определите длину массива положительным целым числом от 1 и выше!");
            } else {
                System.out.printf("Спасибо, ваш массив длиной %d создан!\n", input);

                int max, min, avg;
                int[] array = new int[input];

                System.out.println("В вашем массиве содержаться следующие значения:");
                System.out.println("индекс -> значение");
                for (int i = 0; i < array.length; i++) {
                    array[i] = (int) (Math.random() * 500);
                    System.out.printf("%d -> %d\n", i, array[i]);
                }
                // Просто пустая строка
                System.out.println();

                max = Arrays.stream(array).max().getAsInt();
                min = Arrays.stream(array).min().getAsInt();
                avg = Arrays.stream(array).sum() / array.length;

                System.out.printf("Максимальное значение в нем = %d\n", max);
                System.out.printf("Минимальное значение в нем = %d\n", min);
                System.out.printf("Среднее арифметическое значение в нем = %d\n", avg);

                working = false;
            }

        } while (working);

    }
}
