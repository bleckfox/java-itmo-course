package homeWork3;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        System.out.println("Task 4");

        Scanner input = new Scanner(System.in);

        int minValue = 1, maxValue = 100, lastAnswer = 50;
        boolean searching = true;

        System.out.println("Загадайте целое число от 1 до 100 (включительно)...");
        System.out.println("Я попытаюсь угадать его. На мои вопросы отвечайте 0 - НЕТ, 1 - ДА...");

        do {
            System.out.printf("Ваше число равно %d? 0 - НЕТ, 1 - ДА\n", lastAnswer);

            int answer = Helper.getPositiveUserInput(input);

            if (answer == -1 || answer > 2){
                System.out.println("Не знаю такого ответа. Давайте попробуем ещё раз...");
            } else if (answer == 1) {
                System.out.println("Ура, я смог угадать. Спасибо за игру. До скорого...");
                searching = false;
            } else if (answer == 0) {
                System.out.println("Ваше число больше? 0 - НЕТ, 1 - ДА");

                int nextAnswer = Helper.getPositiveUserInput(input);

                if (nextAnswer == -1 || nextAnswer > 2){
                    System.out.println("Не знаю такого ответа. Давайте попробуем ещё раз...");
                } else if (nextAnswer == 1) {
                    minValue = lastAnswer + 1;
                    lastAnswer = (maxValue + lastAnswer) / 2;
                } else if (nextAnswer == 0){
                    maxValue = lastAnswer - 1;
                    lastAnswer = (lastAnswer + minValue) / 2;
                }

            }
        }
        while (searching);

    }
}
