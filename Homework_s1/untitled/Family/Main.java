package Family;

import Family.FamilyTree.FamilyTree;
import Family.FamilyTree.Gender;
import Family.ServiceClasses.SaveLoadToFile;
import Family.ServiceClasses.Service;
import Family.ServiceClasses.ToUserCommunication;

import java.io.Serializable;

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

        ToUserCommunication communication = new ToUserCommunication();
        while (Boolean.TRUE) {
            switch (communication.mainmenu()) {
                case 1: {
                    communication.sorttree(svc);
                    break;
                }
                case 2: {
                    communication.search(svc);
                    break;
                }
                case 3: {
                    communication.yearslived(svc);
                    break;
                }
                case 4: {
                    communication.remover(svc);
                    break;
                }
                case 5: {
                    communication.childrenviewer(svc);
                    break;
                }
                case 6: {
                    communication.famredacto(svc);
                    break;
                }
                case 7: {
                    savetree(svc.getTree(), "C:\\Обучение\\Java\\Homework_s1\\untitled\\Family.tree");
                    break;
                }
                case 8: {
                    svc.setTree(readtree());
                    break;

                }
                case 9: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Only number from 1 to 9 are acceptable as parameters");
                    break;
                }
            }
        }
    }
    }

