package Family;

import java.util.Comparator;

public class HumanAgeComparator implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getage(),o2.getage());
    }
}
