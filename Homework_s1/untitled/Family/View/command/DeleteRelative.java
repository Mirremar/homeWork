package Family.View.command;

import Family.View.ConsoleUI;

public class DeleteRelative extends Command{
    public DeleteRelative(ConsoleUI consoleUI)
    {
        super("Delete relative from tree",consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().deleterelative();
    }
}
