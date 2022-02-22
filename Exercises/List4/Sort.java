package glowny;

import java.util.Comparator;

public class Sort {

    private final Comparator _comparator;

    public Sort(Comparator comparator) {
        _comparator = comparator;
    }


    public int[] insertSort(int[] tab){

        for(int i=1; i<tab.length; i++){
            int val = tab[i];
            int j;
            for(j=i;j>0 && _comparator.compare(val,tab[j-1])<0; j--){
                tab[j]=tab[j-1];
                }
                tab[j]=val;
            }
        return tab;
        }

    public int sortCheck(int[] tab){

    int l=0;

        for(int i=1; i<tab.length; i++){
            int val = tab[i];
            int j;

            for(j=i;j>0 && _comparator.compare(val,tab[j-1])<0; j--){
                tab[j]=tab[j-1];
                l++;
            }
            tab[j]=val;
        }

    return l;
    }

    public int sortOnlyCheck(int[] tab){

        int l=0;

        for(int i=1; i<tab.length; i++){
            for(int j=i; j>0; j--){
                if(_comparator.compare(tab[i], tab[j-1])<0){
                    l++;
                }
            }
        }

        return l;
    }


}

