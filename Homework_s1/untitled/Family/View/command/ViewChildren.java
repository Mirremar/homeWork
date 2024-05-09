package Family.View.command;

import Family.View.ConsoleUI;

public class ViewChildren extends Command{
    public ViewChildren(ConsoleUI consoleUI)
    {
        super("View Children",consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().viewchildren();
    }
}
