package Family.Model;

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

    public T searchHumanByName(String somename) {
        for (T hu : humanList) {
            if (hu.getName().equals(somename)) {
                return hu;
            }
        }
        return null;

    }

    public T searchHumanByID(Integer someid) {
        for (T hu : humanList) {
            if (hu.getId()==someid) {
                return hu;
            }
        }
        return null;

    }

    public ArrayList<T> searchHumanByDate(Integer someyear) //Кто был жив на период определённого года?
    {
        ArrayList<T> results = new ArrayList<>();
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

    public void redactRelative(Integer id, String newName, String newDob, String newDod, Gender newGender,String fid,String mid) {
        int newfid =-1;
        int newmid = -1;
        T h = searchHumanByID(id);
        try {
            if (fid != null) {
                newfid = Integer.parseInt(fid);
            }
            if (mid != null) {
                newmid = Integer.parseInt(mid);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if (!(newName==null)) {
            h.setName(newName);
        }

        if (!(newDob==null)) {
            h.setDob(LocalDate.parse(newDob));
        }

        if (!(newDod==null)) {
            h.setDob(LocalDate.parse(newDod));
        }

        if ((!(newGender==null))) {
            if (newGender==Gender.Male) {
                h.setGender(Gender.Male);
            } else {
                h.setGender(Gender.Female);
            }
        }
        if (searchHumanByID(newfid)!=null) {
            if (h.getFather()!=null) {
                h.getFather().getChildren().remove(h);
            }
            T father = searchHumanByID(newfid);
            h.setFather(father);
            father.getChildren().add(h);
        }

        if (searchHumanByID(newmid)!=null) {
            if (h.getMother()!=null) {
                h.getMother().getChildren().remove(h);
            }
            T mother = searchHumanByID(newmid);
            h.setMother(mother);
            mother.getChildren().add(h);
        }
        System.out.println(h);
    }

     public void removeRelative(Integer ID) {
        T del = searchHumanByID(ID);
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
    public List<T> getChildren(Integer ID) {
        T chelik = searchHumanByID(ID);
        ArrayList<T> children = new ArrayList<>();
        for (T h : humanList) {
            if (h.getFather() != null) {
                if ((h.getFather().equals(chelik))) {
                    children.add(h);
                }
            }
            if (h.getFather() != null) {
                if ((h.getMother()).equals(chelik)) {
                    children.add(h);
                }
            }

        }
        return children;
    }
}
