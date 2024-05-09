package Family.View.command;

import Family.View.ConsoleUI;

public class RedactRelative extends Command{
    public RedactRelative(ConsoleUI consoleUI)
    {
        super("Redact family member",consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().redactrelative();
    }
}
