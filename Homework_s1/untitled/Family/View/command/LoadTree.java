package Family.View.command;

import Family.View.ConsoleUI;

public class LoadTree extends Command{
    public LoadTree(ConsoleUI consoleUI)
    {
        super("Load Tree from file",consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().loadtree();
    }
}
