package Family.Model;

import java.util.Comparator;

public class EntityNameComparator<T extends Entity> implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            return o1.getName().compareTo(o2.getName());
        }


}
