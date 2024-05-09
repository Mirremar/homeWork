package Family.View.command;

import Family.View.ConsoleUI;

public class SaveTree extends Command{
    public SaveTree(ConsoleUI consoleUI)
    {
        super("Save tree",consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().savetree();
    }
}
