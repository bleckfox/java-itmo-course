package courseWorks.courseWork2.newVersion_08062023.Commands;

import courseWorks.courseWork2.newVersion_08062023.Game;
import courseWorks.courseWork2.newVersion_08062023.Helper;

import java.util.Scanner;

public class LoadGameCommand implements ICommand{
    private Game game;

    public LoadGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {

        System.out.println("Введите логин, чтобы загрузить игру или 'выход', чтобы завершить игру");

        Scanner loginScan = new Scanner(System.in);
        String login;
        int loginIndex = -1;

        while (loginIndex < 0){
            // Получение login
            login = loginScan.nextLine();

            // чтобы прервать бесконечный ввод логина
            if (login.equals("выход")) new ExitGameCommand().execute();

            // Если не пустая строка, проверим
            if (!login.isEmpty()){
                 loginIndex = Helper.getLoginIfExist(login, true);
            }
        }

        game.load(loginIndex);
    }
}
