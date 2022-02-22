package glowny;

import java.util.NoSuchElementException;

public interface Iterator <T>{

    void first();
    void last();
    T current();
    void next() throws NoSuchElementException;
    void previous();
    boolean hasNext();
    boolean hasPrevious();
}
