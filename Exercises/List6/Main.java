package glowny;

import java.util.Comparator;
import java.util.Random;

public class Main {

    Osoba[] o1;
    Osoba[] o2;
    Osoba[] o3;
    Osoba[] o4;
    int size=10000;


    public static void main(String[] args) {

        Main m = new Main();

        Sort sort = new Sort((Comparator<Osoba>) (o1, o2) -> {
            if(o1.wiek<o2.wiek) return -1;
            if(o1.wiek>o2.wiek) return 1;

            return 0;
        }) ;

       m.check(sort);
      // m.testSort(sort);

    }


    public void testSort(Sort sort){

        sort.set_comparator((Comparator<Osoba>) (o1, o2) -> o1.getNazwisko().compareTo(o2.getNazwisko()));

        Osoba[] t = new Osoba[5];
        t[0]= new Osoba("Zbigniew", "Nowak", 34);
        t[1]= new Osoba("Janina", "Kowalska", 32);
        t[2]= new Osoba("Joanna", "Bednarek", 12);
        t[3]= new Osoba("Wojtek", "Karowski", 34);
        t[4]= new Osoba("Beata", "Dudek", 39);

         sort.quickSort(t);
        for (int i=0; i<5; i++){
            System.out.println(t[i].toString());
        }
    }

    public void makeArray(){
         o1 = new Osoba[size];
         o2 = new Osoba[size];
         o3 = new Osoba[size];
         o4 = new Osoba[size];

        for(int i=0; i<size; i++){
            o1[i]=new Osoba("imie","nazwisko",i);
        }

        for(int i=0; i<size; i++){
            o2[i]=new Osoba("imie", "nazwisko",size-i);
        }

        Random r = new Random();

        for(int i=0; i<size; i++){
            o3[i]=new Osoba("imie","nazwisko", r.nextInt(size));
        }


        for(int i=0; i<size; i++){
            o4[i]=new Osoba("imie","nazwisko", r.nextGaussian());
        }
    }

    public void checkInsertSort(Osoba[] o, Sort sort){
        long millisActualTime = System.currentTimeMillis();

        sort.insertSort(o);
        System.out.println(": " + (System.currentTimeMillis() - millisActualTime));

    }

    public void checkSelectSort(Osoba[] o, Sort sort){
        long millisActualTime = System.currentTimeMillis();

        sort.selectSort(o);
        System.out.println(": " + (System.currentTimeMillis() - millisActualTime));

    }

    public void checkShellSort(Osoba[] o, Sort sort){
        long millisActualTime = System.currentTimeMillis();

        sort.shellSort(o);
        System.out.println(": " + (System.currentTimeMillis() - millisActualTime));

    }

    public void checkMergeSort(Osoba[] o, Sort sort){
        long millisActualTime = System.currentTimeMillis();

        sort.mergeSort(o);
        System.out.println(": " + (System.currentTimeMillis() - millisActualTime));

    }

    public void checkQuickSort(Osoba[] o, Sort sort){
        long millisActualTime = System.currentTimeMillis();

        sort.quickSort(o);
        System.out.println(": " + (System.currentTimeMillis() - millisActualTime));

    }

    public void checkheapSort(Osoba[] o, Sort sort){
        long millisActualTime = System.currentTimeMillis();

        sort.heapSort(o);
        System.out.println(": " + (System.currentTimeMillis() - millisActualTime));

    }
    public void check(Sort sort){

        makeArray();
        System.out.println("Insert sort: ");

        System.out.print("Optimistic");
        checkInsertSort(o1,sort);

        System.out.print("Pesimistic");
        checkInsertSort(o2,sort);

        System.out.print("Random");
        checkInsertSort(o3,sort);

        System.out.print("Gauss");
        checkInsertSort(o4,sort);

        System.out.println("\nSelect sort");
        makeArray();

        System.out.print("Optimistic");
        checkSelectSort(o1,sort);

        System.out.print("Pesimistic");
        checkSelectSort(o2,sort);

        System.out.print("Random");
        checkSelectSort(o3,sort);

        System.out.print("Gauss");
        checkSelectSort(o4,sort);

        System.out.println("\nShell sort");
        makeArray();

        System.out.print("Optimistic");
        checkShellSort(o1,sort);

        System.out.print("Pesimistic");
        checkShellSort(o2,sort);

        System.out.print("Random");
        checkShellSort(o3,sort);

        System.out.print("Gauss");
        checkShellSort(o4,sort);

        System.out.println("\nMerge Sort");
        makeArray();

        System.out.print("Optimistic");
        checkMergeSort(o1,sort);

        System.out.print("Pesimistic");
        checkMergeSort(o2,sort);

        System.out.print("Random");
        checkMergeSort(o3,sort);

        System.out.print("Gauss");
        checkMergeSort(o4,sort);

        System.out.println("\nQuick Sort");
        makeArray();

        System.out.print("Optimistic");
        checkQuickSort(o1,sort);

        System.out.print("Pesimistic");
        checkQuickSort(o2,sort);

        System.out.print("Random");
        checkQuickSort(o3,sort);

        System.out.print("Gauss");
        checkQuickSort(o4,sort);

        System.out.println("\nHeap sort");
        makeArray();

        System.out.print("Optimistic");
        checkheapSort(o1,sort);

        System.out.print("Pesimistic");
        checkheapSort(o2,sort);

        System.out.print("Random");
        checkheapSort(o3,sort);

        System.out.print("Gauss");
        checkheapSort(o4,sort);
    }
}
