package Family.View.command;

import Family.View.ConsoleUI;

public abstract class Command {
    private final String description;
    private ConsoleUI consoleUI;

    public Command(String description,ConsoleUI consoleUI){
        this.consoleUI=consoleUI;
        this.description=description;
    }

    public String getDescription(){
        return description;
    }
    public ConsoleUI getConsoleUI(){
        return consoleUI;
    }
    public abstract void execute();
}
