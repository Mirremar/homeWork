package Family.View.command;

import Family.View.ConsoleUI;

public class SortByAge extends Command{

    public SortByAge(ConsoleUI consoleUI)
    {
        super("Sort tree by age",consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortbyage();
    }

}
