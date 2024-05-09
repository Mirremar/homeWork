package Family.View;

import Family.View.command.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
   private final List<Command> commandList;
   public MainMenu(ConsoleUI consoleUI) {
       commandList = new ArrayList<>();
       commandList.add(new AddHuman(consoleUI));
       commandList.add(new SortTreeByName(consoleUI));
       commandList.add(new SortByAge(consoleUI));
       commandList.add(new GetTreeInfo(consoleUI));
       commandList.add(new DeleteRelative(consoleUI));
       commandList.add(new LoadTree(consoleUI));
       commandList.add(new RedactRelative(consoleUI));
       commandList.add(new SaveTree(consoleUI));
       commandList.add(new SearchByName(consoleUI));
       commandList.add(new SearchByYear(consoleUI));
       commandList.add(new ViewChildren(consoleUI));
       commandList.add(new ExitProgram(consoleUI));
   }

       public String getMenu()
       {
            StringBuilder sb = new StringBuilder();
            sb.append("Menu:\n");
            for (int i=0;i<commandList.size();i++){
                sb.append(i+1);
                sb.append(". ");
                sb.append(commandList.get(i).getDescription());
                sb.append("\n");
            }
            return sb.toString();
       }

       public void execute(int choice)
       {
           Command cmd = commandList.get(choice-1);
           cmd.execute();
       }

   }
