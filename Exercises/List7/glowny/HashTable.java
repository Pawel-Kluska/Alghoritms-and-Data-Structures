package glowny;

import linkedList.TwoWayCycledList;

public class HashTable <T> {

    TwoWayCycledList<T>[] tab;
    private final int size=10;

    @SuppressWarnings("unchecked")
    public HashTable() {
        tab = new TwoWayCycledList[size];
    }

    public void add(T elem) {

        int hashCode = Math.abs(elem.hashCode() % tab.length);

        if (tab[hashCode] == null) {

            TwoWayCycledList<T> lin = new TwoWayCycledList<>();
            lin.add(elem);
            tab[hashCode] = lin;
        } else {
            tab[hashCode].add(elem);
        }

    }

    public void remove(T elem) {

        int hashCode = Math.abs(elem.hashCode() % tab.length);

        if (tab[hashCode] == null) {
            System.out.println("Nie ma takiej wartosci");
        } else {
            if(tab[hashCode].removeVal(elem)==true) System.out.println("Usunieto");
          else System.out.println("Nie ma takiego elementu");
            }
        }

    public boolean contains(T elem){
        int hashCode = Math.abs(elem.hashCode() % tab.length);

            if(tab[hashCode]!=null && tab[hashCode].contains(elem))
                return true;

            else
                return false;
    }

    public void showArray() {

        for (int j = 0; j < tab.length; j++)

            if (tab[j] != null) {
                for (int i = 0; i < tab[j].size(); i++) {
                    System.out.println(tab[j].get(i));
                }
            }
    }
}



