package Family.View.command;

import Family.View.ConsoleUI;

public class SortTreeByName extends Command{
    public SortTreeByName(ConsoleUI consoleUI)
    {
        super("Sort tree by name",consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortbyname();
    }
}
