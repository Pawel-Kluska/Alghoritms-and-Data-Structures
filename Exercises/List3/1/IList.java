package glowny;

public interface IList <E>{

    void add(E e);
    void add(int index, E element);
    void clear();
    boolean contains(E element);
    E get(int index);
    E set(int index, E element);
    int indexOf(E element);
    boolean isEmpty();
    Iterator<E> iterator();
    E remove(int index);
    boolean remove(E element);
    int size();
}
