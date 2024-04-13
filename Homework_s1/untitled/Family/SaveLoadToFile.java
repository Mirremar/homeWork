package Family;

import java.io.Serializable;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SaveLoadToFile implements Writeable {
    private final String path = "C:\\Обучение\\Java\\Homework_s1\\untitled\\Family.tree";
    public boolean savetoFile(Serializable serializable,String filepath){
        filepath = path;
        try {
            FileOutputStream toFile = new FileOutputStream(filepath);
            ObjectOutputStream objOutStr = new ObjectOutputStream(toFile);
            objOutStr.writeObject(serializable);
            objOutStr.close();
            toFile.close();
            System.out.println("The tree was saved");
            return true;
        }
        catch (IOException i){
            System.out.println("got an exception");
            return false;
        }

    }

    public Object loadFromFile(String filepath) {
        Serializable tree = null;
        try {
            FileInputStream fromFile = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fromFile);
            tree = (Serializable) ois.readObject();
            ois.close();
            fromFile.close();
            // return tree;
            System.out.println("The tree was loaded");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException c) {
            System.out.println("got ClassNotFoundException");
            c.printStackTrace();
        }
        return tree;
    }


}
