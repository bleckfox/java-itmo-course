package homeWorks.homeWork03;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        System.out.println("Task 3");
        int num = 6;
        int inputNum = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("Я загадал число от 1 до 9 (включительно). Вам нужно его угадать...");
        System.out.println("Если вы введете 0, я завершу свою работу...");
        System.out.println("Введите ваше число...");

        do {
            inputNum = Helper.getPositiveUserInput(input);

            if (inputNum == 0){
                System.out.println("Понял, завершаю свою работу...");
                break;
            } else if (inputNum == num) {
                System.out.println("Поздравляю! Вы угадали моё число, отличная работа. До скорого...");
                break;
            } else if (inputNum > num) {
                System.out.println("Мое число меньше...");
            } else {
                System.out.println("Мое число больше...");
            }
        }
        while (inputNum != num);
    }
}
