package Family.ServiceClasses;

import Family.FamilyTree.Human;
import Family.Interfaces.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToUserCommunication {

    public int mainmenu() {
        int actionVariable=-1;
            System.out.println("Choose an action(number 1 to 6):\n");
            System.out.println("1 Overview family tree\n");
            System.out.println("2 Search family member by name\n");
            System.out.println("3 Search who lived in a year x\n");
            System.out.println("4 Remove from tree\n");
            System.out.println("5 View children\n");
            System.out.println("6 Redact member data\n");
            System.out.println("7 Save tree to file");
            System.out.println("8 Load tree from file");
            System.out.println("9 Exit\n");
            Scanner sc = new Scanner(System.in);
            actionVariable = Integer.parseInt(sc.next());
        return actionVariable;
    }

    public void sorttree(Service sv){
        System.out.println("would you like to sort the tree by name or age?\n");
        System.out.println("1: by name\n");
        System.out.println("2: by age\n");
        System.out.println("any other key: no sort\n");
        Scanner sc = new Scanner(System.in);
        int sortvar = Integer.parseInt(sc.next());
        switch (sortvar){
            case 1: {
                sv.getTree().sortByName();
                System.out.println(sv.getTreeInfo());
                break;
            }
            case 2: {
                sv.getTree().sortByAge();
                System.out.println(sv.getTreeInfo());
                break;
            }
            default: {
                System.out.println(sv.getTreeInfo());
                break;
            }
        }

    }

    public void search(Service sv){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name for search");
        String name = sc.next();
        Entity fam = sv.getTree().searchHumanByName(name);
        System.out.println(fam);
    }

    public void yearslived(Service sv){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter year of interest");
        int yearofinterest = Integer.parseInt(sc.next());
        ArrayList<Human> res = sv.getTree().searchHumanByDate(yearofinterest);
        for (Human smbd : res) {
            System.out.println(smbd);
        }
    }
    public void remover(Service sv){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of family member to erase");
        String name = sc.next();
        sv.getTree().removeRelative(name);
    }

    public void childrenviewer(Service sv){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a member name to view children");
        String name = sc.next();
        List<Entity> lst = sv.getTree().getHumanList();
        for (Entity child : lst) {
            if (child.getName().equals(name)) {
                System.out.println(child.getChildren());
            }
        }
    }

    public void famredacto(Service sv){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a member name to redact");
        String name = sc.next();
        Entity target = (sv.getTree().searchHumanByName(name));
        if ((target) != null) {
            System.out.println("Enter new data for this family member:\n");
            System.out.println(target);
            System.out.println("Enter new name (or press enter to skip)");
            String newName = sc.next();
            System.out.println("Enter new date of birth.Format is yyyy-mm-dd(or press enter to skip)");
            String newDob = sc.next();
            System.out.println("Enter new date of death.Format is yyyy-mm-dd(or press enter to skip)");
            String newDod = sc.next();
            System.out.println("Enter new gender.Male или Female.(or press enter to skip)");
            String newGender = sc.next();
            System.out.println("Enter new father name(or press enter to skip)");
            String newFather = sc.next();
            System.out.println("Enter new mother name(or press enter to skip)");
            String newMother = sc.next();
            sv.getTree().redactRelative(target, newName, newDob, newDod, newGender, newFather, newMother);
        }
        else System.out.println("No family member with such name exists");
    }
}
