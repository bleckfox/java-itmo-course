package courseWorks.courseWork2.newVersion_08062023.Commands;

public class ExitGameCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("Игра завершена!");
        System.exit(0);
    }
}
