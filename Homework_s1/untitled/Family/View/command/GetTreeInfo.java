package Family.View.command;

import Family.View.ConsoleUI;

public class GetTreeInfo extends Command{
    public GetTreeInfo(ConsoleUI consoleUI)
    {
        super("Get tree info",consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().gettreeinfo();
    }
}
