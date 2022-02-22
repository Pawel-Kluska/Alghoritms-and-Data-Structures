package glowny;

import java.util.NoSuchElementException;

public class ArrayIterator <T> implements Iterator<T> {

    private T[] tab;
    private int position;

    public ArrayIterator(T[] tab) {

        this.tab = tab;
    }


    @Override
    public void first() {

        position = 0;
    }

    @Override
    public void last() {

        position = tab.length - 1;
    }

    @Override
    public T current() {
        return tab[position];
    }

    @Override
    public void next() throws NoSuchElementException{
        if(hasNext()) {
            position++;
        }
        else{
            throw new NoSuchElementException("Out of range");
        }
    }

    @Override
    public void previous() {
            if(hasPrevious()) {
                position--;
            }
            else{
                throw new NoSuchElementException("Out of range");
            }

    }

    @Override
    public boolean hasNext() {
            return position < tab.length-1;
    }


    @Override
    public boolean hasPrevious() {
        return position > 0 ;
    }
}
