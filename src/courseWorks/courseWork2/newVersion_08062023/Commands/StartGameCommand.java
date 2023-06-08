package courseWorks.courseWork2.newVersion_08062023.Commands;

import courseWorks.courseWork2.newVersion_08062023.Game;

public class StartGameCommand implements ICommand{
    private Game game;

    public StartGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.start();
    }
}
