package Family.View.command;

import Family.View.ConsoleUI;

public class SearchByName extends Command {
    public SearchByName(ConsoleUI consoleUI)
    {
        super("Search family member by name",consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().searchbyname();
    }
}
