package glowny;


import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {

        Integer[] tablica = new Integer[10];

        for(int i=0; i<tablica.length; i++){
            tablica[i] = i;
        }

        Iterator <Integer> ite = makeArrayIterator(tablica);

        try {
            simulation(ite);
        }catch(NoSuchElementException e){
            e.printStackTrace();
        }

        ArrayList<Integer> tab2 = new ArrayList<>();

        for(int i=0; i<10; i++){
            tab2.add(i);
        }

        Iterator <Integer> ite2 = makeArrayListIterator(tab2);
        try {
            Thread.sleep(100);
            simulation(ite2);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static <T> ArrayIterator<T>  makeArrayIterator(T[] tab ) {

        if(tab.length>0) {
            ArrayIterator<T> ite = new ArrayIterator<>(tab);
            return ite;
        }
        else{
            throw new NoSuchElementException("The Array has a length equal to 0");
        }
    }

    public static <T> ArrayListIt<T> makeArrayListIterator(ArrayList<T> list ) {
        if(list.size()>0) {
            ArrayListIt<T> ite = new ArrayListIt<>(list);
            return ite;
        }
        else{
            throw new NoSuchElementException("The Array has a length equal to 0");
        }

    }

    public static void simulation (Iterator ite) throws NoSuchElementException{

        System.out.println(ite.current());
        ite.next();
        ite.next();
        System.out.println(ite.current());
        ite.last();
        System.out.println(ite.current());
        ite.previous();
        System.out.println(ite.current());
        ite.first();
        System.out.println(ite.current());
        ite.last();
        ite.next();
        System.out.println(ite.hasNext());
        System.out.println(ite.current());

    }



}
