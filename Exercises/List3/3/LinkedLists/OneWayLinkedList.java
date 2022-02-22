package LinkedLists;

import java.util.NoSuchElementException;

public class OneWayLinkedList<E> implements IList<E> {

    private class Element {
        private E value;
        private Element next;

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        Element(E data) {
            this.value = data;
        }
    }

    Element head = null;

    @Override
    public boolean isEmpty() {
        return head == null;
    }


    @Override
    public void clear() {
        head = null;
    }

    @Override
    public int size() {
        int pos = 0;
        Element actElem = head;
        while (actElem != null) {
            pos++;
            actElem = actElem.getNext();
        }
        return pos;
    }

    private Element getElement(int index) {
        Element actElem = head;
        while (index > 0 && actElem != null) {
            index--;
            actElem = actElem.getNext();
        }
        return actElem;
    }

    @Override
    public void add(E e) {
        Element newElem = new Element(e);
        if (head == null) {
            head = newElem;
        } else {
            Element tail = head;
            while (tail.getNext() != null)
                tail = tail.getNext();

            tail.setNext(newElem);
        }
    }

    public void add(int index, E data) {
        if (index < 0) throw new NoSuchElementException();

        Element newElem = new Element(data);
        if (index == 0) {
            newElem.setNext(head);
            head = newElem;
        }
        Element actElem = getElement(index - 1);
        if (actElem == null)
            throw new NoSuchElementException();

        newElem.setNext(actElem.getNext());
        actElem.setNext(newElem);
    }

    @Override
    public int indexOf(E data) {
        int pos = 0;
        Element actElem = head;
        while (actElem != null) {
            if (actElem.getValue().equals(data))
                return pos;
            pos++;
            actElem = actElem.getNext();
        }
        return -1;
    }

    @Override
    public boolean contains(E data) {
        return indexOf(data) >= 0;
    }

    @Override
    public E get(int index) {
        Element actElem = getElement(index);
        return actElem.getValue();
    }

    @Override
    public E set(int index, E data) {
        Element actElem = getElement(index);
        if (actElem == null)
            return null;
        E elemData = actElem.getValue();
        actElem.setValue(data);
        return elemData;
    }

    @Override
    public E remove(int index) {
        if (head == null)
            return null;
        if (index == 0) {
            E retValue = head.getValue();
            head = head.getNext();
            return retValue;
        }
        Element actElem = getElement(index - 1);
        if (actElem == null || actElem.getNext() == null)
            return null;
        E retValue = actElem.getNext().getValue();
        actElem.setNext(actElem.getNext().getNext());
        return retValue;
    }

    @Override
    public boolean remove(E value) {
        if (head == null)
            return false;
        if (head.getValue().equals(value)) {
            head = head.getNext();
            return true;
        }
        Element actElem = head;

        while (actElem.getNext() != null && !actElem.getNext().getValue().equals(value))
            actElem = actElem.getNext();

        if (actElem.getNext() == null)
            return false;

        actElem.setNext(actElem.getNext().getNext());
        return true;
    }

    private class InnerIterator implements Iterator<E> {
        Element actElem;
        Element befElem;

        public InnerIterator() {
            actElem = head;
        }

        @Override
        public boolean hasNext() {
            return actElem != null;
        }

        @Override
        public E next() {
           if(actElem==head){
               befElem=head;
           }
           else{
               befElem=befElem.getNext();
           }
            E value = actElem.getValue();
            actElem = actElem.getNext();
            return value;
        }

        public E remove(){

            if (head == null)
                return null;
            if (head == actElem) {
                E retValue = head.getValue();
                head = head.getNext();
                return retValue;
            }

            if (befElem == null || befElem.getNext() == null)
                return null;
            E retValue = befElem.getNext().getValue();
            befElem.setNext(befElem.getNext().getNext());
            return retValue;
        }

    }

    public Iterator<E> iterator() {
        return new InnerIterator();
    }

}

