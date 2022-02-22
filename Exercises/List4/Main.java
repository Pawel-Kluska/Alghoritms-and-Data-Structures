package glowny;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        int[] tablica = new int[]{5,8,4,7,3,3,63,76,2,11,23,5,4,12,76};


        Sort sort = new Sort(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<o2) return -1;
                if(o1>o2) return 1;

                return 0;
            }
        }) ;

        System.out.println(sort.sortOnlyCheck(tablica));
        System.out.println(sort.sortCheck(tablica));


        sort.insertSort(tablica);

        for(int i=0; i<tablica.length; i++){
            System.out.print(tablica[i] + " ");
        }


    }
}
