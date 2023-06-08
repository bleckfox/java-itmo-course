package courseWorks.courseWork2.newVersion_08062023;

import courseWorks.courseWork2.newVersion_08062023.Commands.*;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        while (true){
            System.out.println("МЕНЮ:");
            System.out.println("1. Начать игру");
            System.out.println("2. Загрузить игру");
//            System.out.println("3. Сохранить игру");
            System.out.println("4. Выйти");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            Game game = new Game();

            switch (choice) {
                case 1 -> new StartGameCommand(game).execute();
                case 2 -> new LoadGameCommand(game).execute();
                //case 3 -> new SaveGameCommand(game).execute();
                case 4 -> new ExitGameCommand().execute();
                default -> System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }
}
