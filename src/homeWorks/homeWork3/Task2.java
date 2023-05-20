package homeWorks.homeWork3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Введите целое число");

        int num = Helper.getPositiveUserInput(input);
        if (num <= 0){
            System.out.println("Число должно быть положительным и больше 0");
        }
        else if (num <= 9){
            System.out.println("Ваше число -> " + num);
        }
        else {
            int result = 0;
            for (var i: Integer.toString(num).split("")){
                result += Integer.parseInt(i);
            }
            System.out.printf("Ваше число -> %d\tсумма чисел которого -> %d\n", num, result);
        }
    }
}
