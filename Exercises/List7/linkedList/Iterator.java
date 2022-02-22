package linkedList;

import java.util.NoSuchElementException;

public interface Iterator <E> {

     void first();
     void last();
     E next() throws NoSuchElementException;
     E previous();
     boolean hasNext();
     boolean hasPrevious();
     void remove();

}

