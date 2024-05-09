package Family.View.command;

import Family.View.ConsoleUI;

public class AddHuman extends Command {


    public AddHuman(ConsoleUI consoleUI)
    {
        super("Add family member",consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().addHuman();
    }
}
