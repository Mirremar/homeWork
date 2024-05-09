package Family.View;

import Family.Model.Gender;
import Family.Presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{

    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);

    }

    @Override
    public void start() {
        presenter.addHuman("And", "1856-05-12", "1906-04-13", Gender.Male, null, null);
        presenter.addHuman("Bor", "1854-01-05", "1954-06-17", Gender.Male, null, null);
        presenter.addHuman("Ann", "1888-05-12", "1966-04-13", Gender.Female, null, null);
        presenter.addHuman("Ber", "1890-05-12", "1965-04-13", Gender.Female, null, null);
        presenter.addHuman("Cat", "1858-05-12", "1916-04-13", Gender.Female, null, null);
        presenter.addHuman("Con", "1858-05-12", "1916-04-13", Gender.Male, null, null);
        presenter.addHuman("Der", "1858-05-12", "1916-04-13", Gender.Male, null, null);
        presenter.addHuman("Dim", "1858-05-12", "1916-04-13", Gender.Male, null, null);
        presenter.addHuman("Kuv", "1858-05-12", "1916-04-13", Gender.Female, null, null);
        presenter.addHuman("Puj", "1858-05-12", "1916-04-13", Gender.Female, null, null);
        presenter.addHuman("Lee", "1858-05-12", "1916-04-13", Gender.Female, null, null);
        while (work==true) {
            System.out.println(menu.getMenu());
            String choice = scanner.nextLine();
            int intchoice = Integer.parseInt(choice);
            menu.execute(intchoice);

        }
    }

    @Override
    public void printInfo(String text) {
        System.out.println(text);
    }

    public void addHuman(){
        System.out.println("Enter name,date of birth,date of death,gender,father's name and mother's name");
        System.out.println("name is");
        String name = scanner.nextLine();
        System.out.println("date of birth is (yyyy-mm-dd)");
        String dob = scanner.nextLine();
        System.out.println("date of death is (yyyy-mm-dd)");
        String dod = scanner.nextLine();
        System.out.println("Gender is (Male or Female)");
        String gen = scanner.nextLine();
        System.out.println("Father's id is");
        Integer fid = Integer.parseInt(scanner.nextLine());
        System.out.println("Mother's id is");
        Integer mid = Integer.parseInt(scanner.nextLine());
        presenter.addHuman(name,dob,dod, Gender.valueOf(gen),fid,mid);
        presenter.getTreeInfo();
    }
    public void sortbyname(){
        presenter.sortTreeByName();
        presenter.getTreeInfo();
    }
    public void sortbyage(){
        presenter.sortTreeByAge();
        presenter.getTreeInfo();
    }
    public void gettreeinfo(){
        presenter.getTreeInfo();
    }
    public void searchbyname(){
        System.out.println("Enter name");
        String name = scanner.nextLine();
        presenter.searchByName(name);
    }
    public void searchbyyear(){
        System.out.println("Enter year");
        Integer year = Integer.parseInt(scanner.nextLine());
        presenter.searchByYearsLived(year);
    }
    public void deleterelative(){
        System.out.println("Enter id of member to remove");
        Integer ID = Integer.parseInt(scanner.nextLine());
        presenter.remover(ID);
    }
    public void viewchildren(){
        System.out.println("Enter id of a member to view children of");
        Integer parentID = Integer.parseInt(scanner.nextLine());
        presenter.childrenviewer(parentID);
    }
    public void redactrelative(){
        System.out.println("Enter id of a member to redact");
        Integer redactID = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new data for this family member:\n");
        presenter.searchById(redactID);
        System.out.println("Enter new name (or press enter to skip)");
        String newName = scanner.nextLine();
        if (newName.equals("")) {newName=null;}
        System.out.println("Enter new date of birth.Format is yyyy-mm-dd(or press enter to skip)");
        String newDob = scanner.nextLine();
        if (newDob.equals("")) {newDob=null;}
        System.out.println("Enter new date of death.Format is yyyy-mm-dd(or press enter to skip)");
        String newDod = scanner.nextLine();
        if (newDod.equals("")) {newDod=null;}
        System.out.println("Enter new gender.Male или Female.(or press enter to skip)");
        String newGender = scanner.nextLine();
        System.out.println("Enter new father id(or press enter to skip)");
        String newFather = scanner.nextLine();
        if (newFather.equals("")) {newFather=null;}
        System.out.println("Enter new mother id(or press enter to skip)");
        String newMother = scanner.nextLine();
        if (newMother.equals("")) {newMother=null;}
        presenter.famredacto(redactID,newName,newDob,newDod, Gender.valueOf(newGender),newFather,newMother);
    }
    public void savetree(){
        presenter.saver();
    }
    public void loadtree(){
        presenter.loader();
    }
    public void closeprogram(){
        scanner.close();
        System.out.println("Program finished it's work");
        work=false;
    }
}
