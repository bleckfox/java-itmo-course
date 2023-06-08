package courseWorks.courseWork2.newVersion_08062023.Commands;

import courseWorks.courseWork2.newVersion_08062023.Game;
import courseWorks.courseWork2.newVersion_08062023.Helper;

import java.util.Scanner;

public class SaveGameCommand implements ICommand{
    private Game game;

    public SaveGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        System.out.println("Введите логин:");

        Scanner loginScan = new Scanner(System.in);
        String login = "";

        // Проверяем, что строка не пустая. Пользователь ввел логин
        while (login.isEmpty()){
            login = loginScan.nextLine();
        }

        // Проверка существования логина
        int loginIndex = Helper.getLoginIfExist(login, false);

        // логика перезаписи в случае существаования в методе save
        game.save(login, loginIndex);
    }
}
