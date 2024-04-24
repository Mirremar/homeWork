package Family;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.FileHandler;

public class Main implements Serializable {

    static FamilyTree readtree(){
        SaveLoadToFile sltf = new SaveLoadToFile();
        return (FamilyTree) sltf.loadFromFile("C:\\Обучение\\Java\\Homework_s1\\untitled\\Family.tree");
    }
    static void savetree(FamilyTree tree,String path){
        SaveLoadToFile sltf = new SaveLoadToFile();
        sltf.savetoFile((Serializable) tree,"C:\\Обучение\\Java\\Homework_s1\\untitled\\Family.tree");
    }



    public static void main(String[] args) {
        Service svc = new Service();
        svc.addHuman("And", "1856-05-12", "1906-04-13", Gender.Male, null, null);
        svc.addHuman("Bor", "1854-01-05", "1954-06-17", Gender.Male, null, null);
        svc.addHuman("Ann", "1888-05-12", "1966-04-13", Gender.Female, null, null);
        svc.addHuman("Ber", "1890-05-12", "1965-04-13", Gender.Female, null, null);
        svc.addHuman("Cat", "1858-05-12", "1916-04-13", Gender.Female, null, null);
        svc.addHuman("Con", "1858-05-12", "1916-04-13", Gender.Male, null, null);
        svc.addHuman("Der", "1858-05-12", "1916-04-13", Gender.Male, null, null);
        svc.addHuman("Dim", "1858-05-12", "1916-04-13", Gender.Male, null, null);
        svc.addHuman("Kuv", "1858-05-12", "1916-04-13", Gender.Female, null, null);
        svc.addHuman("Puj", "1858-05-12", "1916-04-13", Gender.Female, null, null);
        svc.addHuman("Lee", "1858-05-12", "1916-04-13", Gender.Female, null, null);


        while (Boolean.TRUE) {
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
            int actionVariable = Integer.parseInt(sc.next());
            switch (actionVariable) {
                case 1: {
                    System.out.println("would you like to sort the tree by name or age?\n");
                    System.out.println("1: by name\n");
                    System.out.println("2: by age\n");
                    System.out.println("any other key: no sort\n");
                    int sortvar = Integer.parseInt(sc.next());
                    switch (sortvar){
                        case 1: {
                            svc.getTree().sortByName();
                            System.out.println(svc.getTreeInfo());
                            break;
                        }
                        case 2: {
                            svc.getTree().sortByAge();
                            System.out.println(svc.getTreeInfo());
                            break;
                        }
                        default: {
                            System.out.println(svc.getTreeInfo());
                            break;
                        }
                    }

                }
                case 2: {
                    System.out.println("Enter name for search");
                    String name = sc.next();
                    Human fam = svc.getTree().searchHumanByName(name);
                    System.out.println(fam);
                    break;
                }
                case 3: {
                    System.out.println("Enter year of interest");
                    int yearofinterest = Integer.parseInt(sc.next());
                    ArrayList<Human> res = svc.getTree().searchHumanByDate(yearofinterest);
                    for (Human smbd : res) {
                        System.out.println(smbd);
                    }
                    break;
                }
                case 4: {
                    System.out.println("Enter name of family member to erase");
                    String name = sc.next();
                    svc.getTree().removeRelative(name);
                    break;
                }
                case 5: {
                    System.out.println("Enter a member name to view children");
                    String name = sc.next();
                    for (Human child : svc.getTree().getHumanList()) {
                        if (child.getName().equals(name)) {
                            System.out.println(child.getChildren());
                        }
                    }
                    break;
                }
                case 6: {
                    System.out.println("Enter a member name to redact");
                    String name = sc.next();
                    Human target = (svc.getTree().searchHumanByName(name));
                    if ((target) != null) {
                        System.out.println("Enter new data for this family member:\n");
                        System.out.println(target);
                        System.out.println("Enter new name (or type and enter > to skip)");
                        String newName = sc.next();
                        System.out.println("Enter new date of birth.Format is yyyy-mm-dd(or type and enter > to skip)");
                        String newDob = sc.next();
                        System.out.println("Enter new date of death.Format is yyyy-mm-dd(or type and enter > to skip)");
                        String newDod = sc.next();
                        System.out.println("Enter new gender.Male или Female.(or type and enter > to skip)");
                        String newGender = sc.next();
                        System.out.println("Enter new father name(or type and enter > to skip)");
                        String newFather = sc.next();
                        System.out.println("Enter new mother name(or type and enter > to skip)");
                        String newMother = sc.next();
                        svc.getTree().redactRelative(target, newName, newDob, newDod, newGender, newFather, newMother);
                    }
                    else System.out.println("No family member with such name exists");
                    break;
                }
                case 7:{
                    savetree(svc.getTree(),"C:\\Обучение\\Java\\Homework_s1\\untitled\\Family.tree");
                    break;
                }
                case 8:{
                    svc.setTree(readtree());
                    break;

                }
                case 9: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Only number from 1 to 6 are acceptable as parameters");
                    break;
                }
            }
        }

    }


}
