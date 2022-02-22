package glowny;

import java.util.Comparator;
import java.util.Random;

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

    public T[] mergeSort(T[] tab){
        return mergesort2(tab, 0, tab.length-1);
    }


    @SuppressWarnings("unchecked")
    private T[] mergesort2(T[] tab, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            T[] result = (T[])(new Object[1]);
            result[0]=tab[startIndex];
            return result;}
        int splitIndex = startIndex + (endIndex - startIndex) / 2;
        return merge(mergesort2(tab, startIndex, splitIndex),
                mergesort2(tab, splitIndex + 1, endIndex));
    }

    @SuppressWarnings("unchecked")
    public T[] merge(T[] left, T[] right) {

        T[] result = (T[])(new Object[left.length+right.length]);

        int i1=0;
        int i2=0;
        int i=0;

        while (i1<left.length && i2<right.length) {
            if (_comparator.compare(left[i1], right[i2]) <= 0) {
                result[i] = left[i1];
                i++;
                i1++;
            } else {
                result[i] = right[i2];
                i++;
                i2++;
            }
        }
            while (i1 < left.length) {
                result[i] = left[i1];
                i++;
                i1++;
            }
            while (i2 < right.length) {
                result[i] = right[i2];
                i++;
                i2++;
            }

        return result;}

    public T[] quickSort(T[] tab) {
        quicksort2(tab, 0, tab.length);
        return tab;
    }

    private void quicksort2(T[] tab, int startIndex, int endIndex) {
        if (endIndex - startIndex > 1) {
            int partition = partition(tab, startIndex, endIndex);
            quicksort2(tab, startIndex, partition );
            quicksort2(tab, partition + 1, endIndex);}}


    private int partition(T[] tab, int nFrom, int nTo) {

        Random r = new Random();
        int rnd = nFrom + r.nextInt(nTo-nFrom);
        swap(tab,nFrom,rnd);
        T value=tab[nFrom];
        int idxBigger=nFrom+1, idxLower=nTo-1;
        do{
            while(idxBigger<=idxLower && _comparator.compare(tab[idxBigger],value)<=0)
                idxBigger++;
            while(_comparator.compare(tab[idxLower],value)>0)
                idxLower--;
            if(idxBigger<idxLower)
                swap(tab,idxBigger,idxLower);
        }while(idxBigger<idxLower);
        swap(tab,idxLower,nFrom);
        return idxLower;}

    public T[] heapSort(T[] tab){
        heapsort2(tab, tab.length);
        return tab;
    }
    private void heapsort2(T[] heap, int n) {
        heapAdjustment(heap, n);
        for(int i=n-1;i>0;i--){
            swap(heap,i,0);
            sink(heap,0,i);
        }
    }

    private void sink(T[] heap,int idx, int n){
        int idxOfBigger=2*idx+1;
        if(idxOfBigger<n){
            if(idxOfBigger+1<n &&
                    _comparator.compare(heap[idxOfBigger], heap[idxOfBigger+1])<0)
                idxOfBigger++;
            if(_comparator.compare(heap[idx], heap[idxOfBigger])<0){
                swap(heap,idx,idxOfBigger);
                sink(heap,idxOfBigger,n);
            }
        }
    }
    private void heapAdjustment(T[] heap,int n)
    {
        for(int i=(n-1)/2;i>=0;i--)
            sink(heap, i, n);
    }


    public void set_comparator(Comparator<T> comparator) {
        _comparator=comparator;
    }

}



