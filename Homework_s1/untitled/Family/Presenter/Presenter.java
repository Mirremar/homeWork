package Family.Presenter;

import Family.Model.Gender;
import Family.Model.Human;
import Family.Model.Service;
import Family.View.View;

import java.io.Serializable;
import java.util.Scanner;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view)
    {
        this.view=view;
        service=new Service();
    }

    public void sortTreeByName(){
        service.sortByName();
    }

    public void sortTreeByAge(){
        service.sortByAge();
    }

    public void addHuman(String name, String dateofbirth, String dateofdeath, Gender gender,
                         Integer father, Integer mother) {
        var fad = service.searchHumanByID(father);
        var mad = service.searchHumanByID(mother);
        service.addHuman(name,dateofbirth,dateofdeath,gender,(Human)fad,(Human)mad);
    }

    public void searchByName(String name){
        System.out.println(service.searchHumanByName(name));

    }
    public void searchById(Integer ID){
        service.searchHumanByID(ID);
    }

    public void searchByYearsLived(Integer year){
        System.out.println(service.searchHumanByDate(year));

    }
    public void remover(Integer ID) {
        service.remove(ID);
    }

    public void childrenviewer(Integer ID){
        service.getChildren(ID);
    }

    public void famredacto(Integer ID,String newname,String dob,String dod,Gender gender,String fid,String mid) {
        service.redactor(ID,newname,dob,dod,gender,fid,mid);

    }

    public void getTreeInfo() {
        String s = service.getTreeInfo();
        view.printInfo(s);

    }

    public void saver(){
        service.savetree(service.getTree());

    }
    public void loader(){
        service.readtree();
    }

}
