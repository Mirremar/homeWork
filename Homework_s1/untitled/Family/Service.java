package Family;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Service {
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
        sb.append("Члены семьи:");
        for (Entity h : tree) {
            sb.append(h);
            sb.append("\n");
        }
        return sb.toString();
    }

    void sortByName(){
        tree.sortByName();

    }

    void sortByAge(){
        tree.sortByAge();
    }


}
