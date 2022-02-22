package glowny;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayListIt<T> implements Iterator<T>{

    private ArrayList<T> tab;
    private int position;

    public ArrayListIt (ArrayList<T> tab) {

        this.tab = tab;
    }


    @Override
    public void first() {

        position = 0;
    }

    @Override
    public void last() {

        position = tab.size() - 1;
    }

    @Override
    public T current() {
        return tab.get(position);
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
        return position < tab.size()-1;
    }


    @Override
    public boolean hasPrevious() {
        return position > 0 ;
    }


}
