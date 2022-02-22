package LinkedLists;

import java.util.NoSuchElementException;

public interface IteratorTwo<E> {

     void first();
     void last();
     E next() throws NoSuchElementException;
     E previous();
     boolean hasNext();
     boolean hasPrevious();
     void remove();

}

