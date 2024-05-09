package Family.View.command;

import Family.View.ConsoleUI;

public class SearchByYear extends Command{
    public SearchByYear(ConsoleUI consoleUI)
    {
        super("Who lived in a year",consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().searchbyyear();
    }
}
