package MyQueue;

public class ArrayQueue<T> implements IQueue<T> {

    T[] array;
    int beginIndex=0;
    int endIndex=0;
    int amountEl;
    int valinc;
    int valdec;

    @SuppressWarnings("unchecked")

    public ArrayQueue(int size) {
        array=(T[]) new Object[size];
        amountEl=0;
        valinc = 10;
        valdec=15;
    }

    public ArrayQueue() {
        this(10);
    }
    @Override
    public boolean isEmpty() {
        return amountEl==0;
    }
    @Override
    public boolean isFull() {
        return amountEl==array.length;
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if(isEmpty())
            throw new EmptyQueueException();

        if(amountEl==array.length-valdec && amountEl!=0){

            T[] array2 = array;

            array = (T[])(new Object[array2.length-valdec+5]);

            for(int i=0; i<amountEl; i++){

                array[i]=array2[beginIndex++];
                beginIndex%=array2.length;
            }
            beginIndex=0;
            endIndex= amountEl;
        }

        T retValue=array[beginIndex++];
        beginIndex%=array.length;
        amountEl--;
        return retValue;
    }
    @Override
    public void enqueue(T elem) {
        if(isFull()){

            T[] array2 = array;

            array = (T[])(new Object[array2.length+valinc]);

            for(int i=0; i<array2.length; i++){

                array[i]=array2[beginIndex++];
                beginIndex%=array2.length;
            }
            beginIndex=0;
            endIndex=(array2.length);

        }

        array[endIndex++]=elem;
        endIndex%=array.length;
        amountEl++;
    }
    @Override
    public int size() {
        return amountEl;
    }
    @Override
    public T first() throws EmptyQueueException {
        if(isEmpty())
            throw new EmptyQueueException();
        return array[beginIndex];
    }

}

