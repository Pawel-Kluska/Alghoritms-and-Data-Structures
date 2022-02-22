package glowny;

import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();

        Sort sort = new Sort((Comparator<Osoba>) (o1, o2) -> {
            if(o1.wiek<o2.wiek) return -1;
            if(o1.wiek>o2.wiek) return 1;

            return 0;
        }) ;

       m.check(sort);
      //  m.testShell(sort);
     //   m.testSelect(sort);

    }


    public void testShell(Sort sort){

        sort.set_comparator((Comparator<Osoba>) (o1, o2) -> o1.getNazwisko().compareTo(o2.getNazwisko()));

        Osoba[] t = new Osoba[5];
        t[0]= new Osoba("Zbigniew", "Nowak", 34);
        t[1]= new Osoba("Janina", "Kowalska", 32);
        t[2]= new Osoba("Joanna", "Bednarek", 12);
        t[3]= new Osoba("Wojtek", "Karowski", 34);
        t[4]= new Osoba("Beata", "Dudek", 39);

        sort.shellSort(t);
        for (int i=0; i<5;i++){
            System.out.println(t[i].toString());
        }
    }

    public void testSelect(Sort sort){

        sort.set_comparator((Comparator<Osoba>) (o1, o2) -> o1.getNazwisko().compareTo(o2.getNazwisko()));

        Osoba[] t = new Osoba[5];
        t[0]= new Osoba("Zbigniew", "Nowak", 34);
        t[1]= new Osoba("Janina", "Kowalska", 32);
        t[2]= new Osoba("Joanna", "Bednarek", 12);
        t[3]= new Osoba("Wojtek", "Karowski", 34);
        t[4]= new Osoba("Beata", "Dudek", 39);

        sort.selectSort(t);
        for (int i=0; i<5;i++){
            System.out.println(t[i].toString());
        }
    }

    public void check(Sort sort){
        int size=10000;
        Osoba[] o1 = new Osoba[size];
        Osoba[] o2 = new Osoba[size];
        Osoba[] o3 = new Osoba[size];
        Osoba[] o4 = new Osoba[size];

        for(int i=0; i<size; i++){
            o1[i]=new Osoba("imie","nazwisko",i);
        }

        for(int i=0; i<size; i++){
            o2[i]=new Osoba("imie","nazwisko",size-i);
        }

        Random r = new Random();

        for(int i=0; i<size; i++){
            o3[i]=new Osoba("imie","nazwisko", r.nextInt(size));
        }


        for(int i=0; i<size; i++){
            o4[i]=new Osoba("imie","nazwisko", r.nextGaussian());
        }



        long millisActualTime = System.currentTimeMillis();

        sort.insertSort(o1);
        System.out.println("insertsort op " + (System.currentTimeMillis() - millisActualTime));

        millisActualTime = System.currentTimeMillis();
        sort.insertSort(o2);
        System.out.println("insertsort pes " + (System.currentTimeMillis() - millisActualTime));

        millisActualTime = System.currentTimeMillis();
        sort.insertSort(o3);
        System.out.println("insertsort rand " + (System.currentTimeMillis() - millisActualTime));

        millisActualTime = System.currentTimeMillis();
        sort.insertSort(o4);
        System.out.println("insertsort gauss " + (System.currentTimeMillis() - millisActualTime));


        for(int i=0; i<size; i++){
            o1[i]=new Osoba("imie","nazwisko",i);
        }

        for(int i=0; i<size; i++){
            o2[i]=new Osoba("imie","nazwisko",size-i);
        }

        r = new Random();

        for(int i=0; i<size; i++){
            o3[i]=new Osoba("imie","nazwisko", r.nextInt(size));
        }


        for(int i=0; i<size; i++){
            o4[i]=new Osoba("imie","nazwisko", r.nextGaussian());
        }

        millisActualTime = System.currentTimeMillis();

        sort.shellSort(o1);
        System.out.println("shell op " + (System.currentTimeMillis() - millisActualTime));

        millisActualTime = System.currentTimeMillis();
        sort.shellSort(o2);
        System.out.println("shell pes " + (System.currentTimeMillis() - millisActualTime));

        millisActualTime = System.currentTimeMillis();
        sort.shellSort(o3);
        System.out.println("shell rand " + (System.currentTimeMillis() - millisActualTime));

        millisActualTime = System.currentTimeMillis();
        sort.shellSort(o4);
        System.out.println("shell gauss " + (System.currentTimeMillis() - millisActualTime));

        for(int i=0; i<size; i++){
            o1[i]=new Osoba("imie","nazwisko",i);
        }

        for(int i=0; i<size; i++){
            o2[i]=new Osoba("imie","nazwisko",size-i);
        }

        r = new Random();

        for(int i=0; i<size; i++){
            o3[i]=new Osoba("imie","nazwisko", r.nextInt(size));
        }


        for(int i=0; i<size; i++){
            o4[i]=new Osoba("imie","nazwisko", r.nextGaussian());
        }

        millisActualTime = System.currentTimeMillis();

        sort.selectSort(o1);
        System.out.println("select op " + (System.currentTimeMillis() - millisActualTime));

        millisActualTime = System.currentTimeMillis();
        sort.selectSort(o2);
        System.out.println("select pes " + (System.currentTimeMillis() - millisActualTime));

        millisActualTime = System.currentTimeMillis();
        sort.selectSort(o3);
        System.out.println("select rand " + (System.currentTimeMillis() - millisActualTime));

        millisActualTime = System.currentTimeMillis();
        sort.selectSort(o4);
        System.out.println("select gauss " + (System.currentTimeMillis() - millisActualTime));

    }



}
