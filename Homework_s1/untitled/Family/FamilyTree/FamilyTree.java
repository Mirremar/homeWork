package Family.FamilyTree;

import Family.Comparators.EntityNameComparator;
import Family.Comparators.HumanAgeComparator;
import Family.Interfaces.Entity;
import Family.Iterators.HumanIterator;

import java.time.LocalDate;
import java.util.*;

public class FamilyTree<T extends Entity<T>> implements Iterable<T> {
    private List<T> humanList;

    public List<T> getHumanList() {
        return humanList;
    }

    public FamilyTree() {
        this.humanList = new ArrayList<>();
    }

    public void addHuman(T human){
        humanList.add(human);
    }

    public void addRelatives(T[] humans) { //добавить сразу много
        for(T h:humans)
        {
            humanList.add(h);
            T somemother = searchHumanByName(h.getMother().getName());
            if (somemother!=null) {somemother.getChildren().add(h);}
            T somefather = searchHumanByName(h.getFather().getName());
            if (somefather!=null) {somefather.getChildren().add(h);}
        }
    }

    public T searchHumanByName(String somename) {
        for (T hu : humanList) {
            if (hu.getName().equals(somename)) {
                return hu;
            }
        }
        return null;

    }

    public ArrayList<T> searchHumanByDate(int someyear) //Кто был жив на период определённого года?
    {
        ArrayList<T> results = new ArrayList<>();
        //(periodStart.compareTo(hu.getDob())>0)
        LocalDate periodStart = LocalDate.of(someyear, 01, 01);
        LocalDate periodEnd = LocalDate.of(someyear, 12, 31);
        for (T hu : humanList)  //25-05-1994  //31-12-1994
        {
            switch (datesPosition(hu, periodStart, periodEnd)) {
                case 1: {
                    results.add(hu);
                    break;
                }
                case 2: {
                    results.add(hu);
                    break;
                }
                case 3: {
                    results.add(hu);
                    break;
                }
                case 4: {
                    results.add(hu);
                    break;
                }
                default:
                    break;
            }

        }
        return results;
    }

    private int datesPosition(T h, LocalDate ps, LocalDate pe) { //Вспомогательный метод,определяет,
        //накладывается ли определённый год на время жизни кого-то из семейного дерева?
        int caseresult = -1;
        boolean IsDobAfterOrEqualsPS = (h.getDob().isAfter(ps));
        boolean IsDobBeforeOrEqualsPE = (h.getDob().isBefore(ps));
        boolean IsDodNull = (h.getDod() == null);
        boolean IsDobBeforePS = (h.getDob().isBefore(ps));
        boolean IsDodBeforeOrEqualsPE = (h.getDod().isBefore(pe));
        boolean IsDodAfterPS = (h.getDod().isAfter(ps));
        boolean IsDodAfterOrEqualsPE = (h.getDod().isAfter(pe));
        boolean IsDobAfterPS = (h.getDob().isAfter(ps));
        boolean IsDodBeforePE = (h.getDod().isBefore(pe));

        if ((IsDobAfterOrEqualsPS && IsDobBeforeOrEqualsPE) && (IsDodAfterOrEqualsPE || IsDodNull)) {
            caseresult = 1;
        }
        if (IsDobBeforePS && (IsDodAfterPS || IsDodNull)) {
            caseresult = 1;
        }
        if (IsDobBeforePS && IsDodBeforeOrEqualsPE) {
            caseresult = 1;
        }
        if (IsDobAfterPS && IsDodBeforePE) {
            caseresult = 1;
        }

        return caseresult;
    }

    public void redactRelative(T h, String newName, String newDob, String newDod, String newGender, String newFather,
                               String newMother) {

        if (!(newName==null)) {
            h.setName(newName);
        }

        if (!(newDob==null)) {
            h.setDob(LocalDate.parse(newDob));
        }

        if (!(newDod==null)) {
            h.setDob(LocalDate.parse(newDod));
        }

        if (!(newGender==null)) {
            if (newGender.equals("Male")) {
                h.setGender(Gender.Male);
            } else {
                h.setGender(Gender.Female);
            }
        }

        if (!(newFather==null)) {
            h.getFather().getChildren().remove(h);
            T father = searchHumanByName(newFather);
            h.setFather(father);
            father.getChildren().add(h);
        }

        if (!(newMother==null)) {
            h.getMother().getChildren().remove(h);
            T mother = searchHumanByName(newMother);
            h.setMother(mother);
            mother.getChildren().add(h);
        }
    }

     public void removeRelative(String name) {
        T del = searchHumanByName(name);
        del.getFather().getChildren().remove(del);
        del.getMother().getChildren().remove(del);
        for (T delchild:del.getChildren())
        {
            if (delchild.getFather().equals(del)) {delchild.setFather(null);}
            if (delchild.getMother().equals(del)) {delchild.setMother(null);}
        }
        humanList.remove(del);
    }
    @Override
    public Iterator<T> iterator() {
        return new HumanIterator(humanList);
    }

    public void sortByName(){
        Collections.sort(humanList,new EntityNameComparator());

    }

    public void sortByAge(){
        Collections.sort(humanList,new HumanAgeComparator<T>());
    }
}
