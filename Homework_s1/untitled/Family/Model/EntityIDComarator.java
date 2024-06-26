package Family.Model;

import java.util.Comparator;

public class EntityIDComarator<T extends Entity> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getId(),o2.getId());
    }
}
