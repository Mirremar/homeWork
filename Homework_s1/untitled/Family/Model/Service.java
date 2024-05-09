package Family.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Service implements Serializable {
    //класс для работы с информацией.Позволяет избежать работы со статикой
    private int idCounter = 0;
    private FamilyTree<Human> tree;

    public FamilyTree getTree(){
        return  tree;
    }

    public void setTree(FamilyTree tree) {
        this.tree = tree;
    }


    public Service(){
        this.tree = new FamilyTree();
    }

    public void addHuman(String name, String dateofbirth, String dateofdeath, Gender gender,
                         Human father, Human mother){
        Human newHuman = new Human(idCounter++,name,dateofbirth,dateofdeath,gender,mother,father);
        tree.addHuman(newHuman);
    }

    public String getTreeInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Family members:");
        for (Human h : tree) {
            sb.append(h);
            sb.append("\n");
        }
        return sb.toString();
    }
    public void sortByName() {tree.sortByName();}
    public void sortByAge() {tree.sortByAge();}
    public Entity searchHumanByID(Integer ID){return tree.searchHumanByID(ID);}
    public Human searchHumanByName(String somename) {return tree.searchHumanByName(somename);}
    public ArrayList<Human> searchHumanByDate(Integer year) {return tree.searchHumanByDate(year);}
    public void remove(Integer ID) {tree.removeRelative(ID);}
    public List<Human> getChildren(Integer ID) { List<Human> ch = tree.getChildren(ID);
    if (ch.size()==0) {
            System.out.println("This parent has no children");
        }
    return ch;}
    public void redactor(Integer ID,String newname,String dob,String dod,Gender gender,String fid,String mid) {
        tree.redactRelative(ID,newname,dob,dod, gender,fid,mid);

    }

    public FamilyTree readtree(){
        SaveLoadToFile sltf = new SaveLoadToFile();
        return (FamilyTree) sltf.loadFromFile("C:\\Обучение\\Java\\Homework_s1\\untitled\\Family.tree");
    }
    public void savetree(FamilyTree tree){
        SaveLoadToFile sltf = new SaveLoadToFile();
        sltf.savetoFile((Serializable) tree,"C:\\Обучение\\Java\\Homework_s1\\untitled\\Family.tree");
    }
}
