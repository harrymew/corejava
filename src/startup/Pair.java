package startup;

import java.io.Serializable;
import java.lang.Comparable;

public class Pair<T extends Comparable & Serializable, U> {
    T name;
    U id;
    Pair(T m, U n)
    {
        name = m;
        id = n;
    }
}
