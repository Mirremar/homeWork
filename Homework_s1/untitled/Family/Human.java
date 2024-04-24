package Family;

import java.util.*;
import java.time.LocalDate;

public class Human implements Comparable<Human> {

    //поля
    private int id;
    private String name;
    private LocalDate dob;
    private LocalDate dod;
    private Gender gender;
    private List<Human> children;
    private Human mother, father;
    private int age;
    //конструктор
    public Human(int id,String name, String dob, String dod, Gender gender, Human mother, Human father) {
        this.id = id;
        this.name = name;
        this.dob = LocalDate.parse(dob);
        this.dod = LocalDate.parse(dod);
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        this.age = setAge();
    }

    //get\set
    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }


    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public LocalDate getDod() {
        return dod;
    }

    public List<Human> getChildren() {
        return children;
    }
    public int getage() {return age;}

    public void setName(String name) {
        this.name = name;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }



    //переопределил вывод
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("fam member: ");
        sb.append(getName() + "\n");
        sb.append("Gender: " + getGender() + "\n");
        sb.append("Years of life: " + getDob() + " to " + getDod() + " ,age " + getage() + "\n");
        if (getMother() == null) {
            sb.append("No data on the mother\n");
        } else {
            sb.append("Mother is " + getMother().getName() + "\n");
        }
        if (getFather() == null) {
            sb.append("No data on the father\n");
        } else {
            sb.append("Father is " + getFather().getName() + "\n");
        }
        return sb.toString();
    }

    //Подсчёт возраста
    public int setAge() {
        int age;
        if (!(this.dod == null)) {
            age = this.dod.getYear() - this.dob.getYear();
            if (this.dod.getMonthValue() < this.dob.getMonthValue() || (this.dod.getMonthValue() == this.dob.getMonthValue() &&
                    this.dod.getDayOfMonth() < this.dob.getDayOfMonth())) {
                age--;
            }
        } else {
            age = LocalDate.now().getYear() - this.dob.getYear();
            if (LocalDate.now().getMonthValue() < this.dob.getMonthValue() || (LocalDate.now().getMonthValue() == this.dob.getMonthValue() &&
                    LocalDate.now().getDayOfMonth() < this.dob.getDayOfMonth())) {
                age--;
            }
        }
        return age;
    }

    @Override
    public boolean equals(Object o) //Члены семьи "равны",если их имена равны
    {
        if (o instanceof Human) {
            Human c = (Human) o;
            if (this.name.equals(c.name))
                return true;
        }
        return false;
    }


    @Override
    public int compareTo(Human h) {
        return  (this.name.compareTo(h.name));
    }
}

