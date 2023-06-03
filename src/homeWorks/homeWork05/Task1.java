package homeWorks.homeWork05;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean canContinue = true;

        do {
            System.out.println("Введите строку. Чтобы выйти -> exit");

            var input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")){
                canContinue = false;
            } else {
                String output = input.substring(0, 1).toUpperCase()
                        + input.substring(1).toLowerCase();

                System.out.println(output.trim());
            }

        }
        while (canContinue);

    }
}
