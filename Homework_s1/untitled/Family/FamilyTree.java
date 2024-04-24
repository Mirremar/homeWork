package Family;

import java.time.LocalDate;
import java.util.*;

public class FamilyTree implements Iterable<Human> {
    private List<Human> humanList;

    public List<Human> getHumanList() {
        return humanList;
    }

    public FamilyTree() {
        this.humanList = new ArrayList<Human>();
    }

    public void addHuman(Human human){
        humanList.add(human);
        //search for children?
    }

    public void addRelatives(Human[] humans) { //добавить сразу много
        for(Human h:humans)
        {
            humanList.add(h);
            try {
                Human somemother = searchHumanByName(h.getMother().getName());
                somemother.getChildren().add(h);
            }
            catch (NullPointerException e) {

            }
            try {
                Human somefather = searchHumanByName(h.getFather().getName());
                somefather.getChildren().add(h);

            }
            catch (NullPointerException e) {

            }
        }
    }

    public Human searchHumanByName(String somename) {
        for (Human hu : humanList) {
            if (hu.getName().equals(somename)) {
                return hu;
            }
        }
        return null;

    }

    public ArrayList<Human> searchHumanByDate(int someyear) //Кто был жив на период определённого года?
    {
        ArrayList<Human> results = new ArrayList<>();
        //(periodStart.compareTo(hu.getDob())>0)
        LocalDate periodStart = LocalDate.of(someyear, 01, 01);
        LocalDate periodEnd = LocalDate.of(someyear, 12, 31);
        for (Human hu : humanList)  //25-05-1994  //31-12-1994
        {
            switch (DatesPosition(hu, periodStart, periodEnd)) {
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

    private int DatesPosition(Human h, LocalDate ps, LocalDate pe) { //Вспомогательный метод,определяет,
        //накладывается ли определённый год на время жизни кого-то из семейного дерева?
        int caseresult = -1;
        boolean IsDobAfterOrEqualsPS = (h.getDob().compareTo(ps) <= 0);
        boolean IsDobBeforeOrEqualsPE = (h.getDob().compareTo(ps) >= 0);
        boolean IsDodNull = (h.getDod() == null);
        boolean IsDobBeforePS = (h.getDob().compareTo(ps) > 0);
        boolean IsDodBeforeOrEqualsPE = (h.getDod().compareTo(pe) >= 0);
        boolean IsDodAfterPS = (h.getDod().compareTo(ps) < 0);
        boolean IsDodAfterOrEqualsPE = (h.getDod().compareTo(pe) <= 0);
        boolean IsDobAfterPS = (h.getDob().compareTo(ps) < 0);
        boolean IsDodBeforePE = (h.getDod().compareTo(pe) > 0);

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

    public void redactRelative(Human h, String newName, String newDob, String newDod, String newGender, String newFather,
                               String newMother) {

        if (!(newName.equals(">"))) {
            h.setName(newName);
        }

        if (!(newDob.equals(">"))) {
            h.setDob(LocalDate.parse(newDob));
        }

        if (!(newDod.equals(">"))) {
            h.setDob(LocalDate.parse(newDod));
        }

        if (!(newGender.equals(">"))) {
            if (newGender.equals("Male")) {
                h.setGender(Gender.Male);
            } else {
                h.setGender(Gender.Female);
            }
        }

        if (!(newFather.equals(">"))) {
            h.getFather().getChildren().remove(h);
            Human father = searchHumanByName(newFather);
            h.setFather(father);
            father.getChildren().add(h);
        }

        if (!(newMother.equals(">"))) {
            h.getMother().getChildren().remove(h);
            Human mother = searchHumanByName(newMother);
            h.setMother(mother);
            mother.getChildren().add(h);
        }
    }

    public void removeRelative(String name) {
        Human del = searchHumanByName(name);
        del.getFather().getChildren().remove(del);
        del.getMother().getChildren().remove(del);
        for (Human delchild:del.getChildren())
        {
            if (delchild.getFather().equals(del)) {delchild.setFather(null);}
            if (delchild.getMother().equals(del)) {delchild.setMother(null);}
        }
        humanList.remove(del);
    }
    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }

    void sortByName(){
        Collections.sort(humanList);

    }

    void sortByAge(){
        Collections.sort(humanList,new HumanAgeComparator());
    }
}
