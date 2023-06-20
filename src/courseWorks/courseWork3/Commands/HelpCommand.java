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
                get\t\t|\t-g\t\t\t|\t получение файла с сервера. Например, -g название.txt
                all\t\t|\t-a\t\t\t|\t получить весь список файлов
                -------------------------------------------------------------------------
                ----- Описание файлов -----
                -- длина названия файла не более 15 символов
                -- для обмена используются только файлы .txt (блокнот)
                """);
    }

}
