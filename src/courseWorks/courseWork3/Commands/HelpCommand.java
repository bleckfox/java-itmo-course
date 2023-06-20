package courseWorks.courseWork3.Commands;

public class HelpCommand implements ICommand {
    @Override
    public void execute(){
        System.out.println("""
                ----- Доступные команды -----
                Полная\t|\tКороткая\t|\t Описание
                -------------------------------------------------------------------------
                help\t|\t-h\t\t\t|\t полный список команд с описанием
                exit\t|\t-e\t\t\t|\t завершение работы
                send\t|\t-s\t\t\t|\t загрузка файла на сервер. Например, -s название.txt
                give\t|\t-g\t\t\t|\t загрузка файла с сервера. Например, -g название.txt
                all\t\t|\t-a\t\t\t|\t получить весь список файлов
                """);
    }

}
