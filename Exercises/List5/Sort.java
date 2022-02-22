package glowny;

import java.util.Comparator;

public class Sort<T> {

    private Comparator<T> _comparator;

    public Sort(Comparator<T> comparator) {
        _comparator = comparator;
    }


    public T[] insertSort(T[] tab){

        for(int i=1; i<tab.length; i++){
            T val = tab[i];
            int j;
            for(j=i;j>0 && _comparator.compare(val,tab[j-1])<0; j--){
                tab[j]=tab[j-1];
                }
                tab[j]=val;
            }
        return tab;
        }

    public T[] selectSort(T[] tab) {
        int size = tab.length;
        for (int slot = 0; slot < size - 1; ++slot) {
            int smallest = slot;
            for (int check = slot + 1; check < size; ++check)
                if (_comparator.compare(tab[check], tab[smallest]) < 0)
                    smallest = check;
            swap(tab, smallest, slot);
        }
        return tab;
    }
    private void swap(T[] tab, int left, int right) {
        if (left != right) {
            T temp = tab[left];
            tab[left]= tab[right];
            tab[right]=temp;
        }
    }


    public T[] shellSort(T[] tab) {
        int n = tab.length;

        for (int gap = n/2; gap > 0; gap /= 2)
        {

            for (int i = gap; i < n; i += 1)
            {
                T temp = tab[i];
                int j;
                for (j = i; j >= gap && _comparator.compare(temp,tab[j-1])<0; j -= gap)
                    tab[j] = tab[j - gap];

                tab[j] = temp;
            }
        }
        return tab;
    }

    public void set_comparator(Comparator<T> comparator) {
        _comparator=comparator;
    }

}

