package Family.Interfaces;

import java.io.Serializable;

public interface Writeable {
    boolean savetoFile(Serializable serializable,String filepath);
    Object loadFromFile(String filepath);
}
