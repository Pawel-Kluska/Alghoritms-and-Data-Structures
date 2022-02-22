package Stack;

public class ArrayStack<T> implements IStack<T> {

    T array[];
    int topIndex;
    int valinc;
    int valdec;


    @SuppressWarnings("unchecked")
    public ArrayStack (int initialSize){
        array=(T[])(new Object[initialSize]);
        topIndex=0;
        valinc=10;
        valdec=15;
    }

    public ArrayStack (){
        this(10);
    }

    @Override
    public boolean isEmpty() {
        return topIndex==0;}

    @Override
    public boolean isFull() {
        return topIndex==array.length;}

    @Override
    public T pop() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException();

        if(topIndex==array.length-valdec){

            T array2[] = array;

            array = (T[])(new Object[array2.length-valdec+5]);


            for(int i=0; i<topIndex; i++){
                array[i]=array2[i];
            }
        }
        return array[--topIndex];}

    @Override
    public void push(T elem) {
        if(isFull()){

           T array2[] = array;

           array = (T[])(new Object[array2.length+valinc]);

           for(int i=0; i<array2.length; i++){
               array[i]=array2[i];
           }
        }

        array[topIndex++]=elem;}

    @Override
    public int size() {
        return topIndex;}

    @Override
    public T top() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException();
        return array[topIndex-1];}


}
