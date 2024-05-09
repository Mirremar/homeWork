package Family.View.command;

import Family.View.ConsoleUI;

public class ExitProgram extends Command{
    public ExitProgram(ConsoleUI consoleUI)
    {
        super("Exit program",consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().closeprogram();
    }
}
