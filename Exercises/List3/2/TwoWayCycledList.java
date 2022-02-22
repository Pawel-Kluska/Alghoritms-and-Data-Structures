package linkedList;

import java.util.NoSuchElementException;

public class TwoWayCycledList<E> implements IList<E> {

    private class Element {
        private E value;
        private Element next;
        private Element prev;

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

        public Element getPrev() {
            return prev;
        }

        public void setPrev(Element prev) {
            this.prev = prev;
        }

        Element(E data) {
            this.value = data;
        }

        public void insertAfter(Element elem) {
            elem.setNext(this.getNext());
            elem.setPrev(this);
            this.getNext().setPrev(elem);
            this.setNext(elem);
        }

        public void insertBefore(Element elem) {
            elem.setNext(this);
            elem.setPrev(this.getPrev());
            this.getPrev().setNext(elem);
            this.setPrev(elem);
        }

        public void remove() {
            this.getNext().setPrev(this.getPrev());
            this.getPrev().setNext(this.getNext());
        }
    }

    Element sentinel = null;

    public TwoWayCycledList() {
        sentinel = new Element(null);
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
    }

    private Element getElement(int index) {

        if (index >= 0 && index < size()) {
            Element elem = sentinel.getNext();
            int counter = 0;
            while (elem != sentinel && counter < index) {
                counter++;
                elem = elem.getNext();
            }
            if (elem == sentinel)
                throw new IndexOutOfBoundsException();
            return elem;
        }
        throw new NoSuchElementException();
    }

    private Element getElementVal(E value) {

        Element elem = sentinel.getNext();
        int counter = 0;
        while (elem != sentinel && !value.equals(elem.getValue())) {
            counter++;
            elem = elem.getNext();
        }
        if (elem == sentinel)
            return null;
        return elem;
    }

    public boolean isEmpty() {
        return sentinel.getNext() == sentinel;
    }

    public void clear() {
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
    }

    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    public E get(int index) {
        Element elem = getElement(index);
        return elem.getValue();
    }

    public E set(int index, E value) {
        Element elem = getElement(index);
        E retValue = elem.getValue();
        elem.setValue(value);
        return retValue;
    }

    public void add(E value) {
        Element newElem = new Element(value);
        sentinel.insertBefore(newElem);
    }

    public void add(int index, E value) {
        Element newElem = new Element(value);
        if (index == 0) sentinel.insertAfter(newElem);
        else {
            Element elem = getElement(index - 1);
            elem.insertAfter(newElem);
        }
    }

    public int indexOf(E value) {
        Element elem = sentinel.getNext();
        int counter = 0;
        while (elem != sentinel && !elem.getValue().equals(value)) {
            counter++;
            elem = elem.getNext();
        }
        if (elem == sentinel)
            return -1;
        return counter;
    }

    public E remove(int index) {
        Element elem = getElement(index);
        elem.remove();
        return elem.getValue();
    }

    public boolean removeVal(E value) {
        Element elem = getElementVal(value);
        if (elem == null) return false;
        elem.remove();
        return true;
    }

    public int size() {
        Element elem = sentinel.getNext();
        int counter = 0;
        while (elem != sentinel) {
            counter++;
            elem = elem.getNext();
        }
        return counter;
    }

    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E> {

        boolean wasNext=false;
        boolean wasPrevious=false;

        Element _current = sentinel;


        @Override
        public boolean hasNext() {
            return _current.getNext() != sentinel;
        }

        @Override
        public boolean hasPrevious() {
            return _current != sentinel;
        }

        @Override
        public void first() {
            _current = sentinel;
        }

        @Override
        public void last() {
            wasPrevious=true;
            wasNext=false;
            _current = sentinel.getPrev();
        }

        public E next() {

            wasNext = true;
            wasPrevious = false;

            _current = _current.getNext();
            return _current.getValue();

        }

        public E previous() {

            if (wasPrevious) {
                E retValue = _current.getValue();
                _current = _current.getPrev();

                wasNext = false;
                wasPrevious = true;
                return retValue;
            }

            if(wasNext){
                _current = _current.getPrev();

                wasNext = false;
                wasPrevious = true;
                return _current.getValue();

            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (wasNext) {
                Element curr = _current.getPrev();
                _current.remove();
                _current = curr;
                wasNext = false;
            }
            if (wasPrevious) {
                _current.getNext().remove();
                wasPrevious = false;
            }
        }
    }
}

