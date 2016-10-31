package model;

import java.util.Random;

class MySet<E> implements SimpleSet<E> {

    private E[] elements;
    private int size;
    private static Random rand = new Random();

    @SuppressWarnings("unchecked")
    public MySet() {
        elements = (E[]) new Object[0];
        size = 0;
    }

    public boolean add(E e) {
        if (!(this.contains(e))) {
            incrementSet();
            elements[elements.length - 1] = e;
            size++;
            return true;
        } else {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public E remove(E e) throws ElementDoesNotExistException {
        if (!(this.contains(e))) {
            throw new ElementDoesNotExistException("Element does not exist", e);
        } else {
            E el = e;
            E[] tempArray = (E[]) new Object[elements.length - 1];
            int j = 0;
            for (int i = 0; i < elements.length; i++) {
                if (!(elements[i].equals(e))) {
                    tempArray[j] = elements[i];
                    j++;
                }
            }
            size--;
            elements = tempArray;
            return el;
        }
    }

    public boolean contains(E e) {
        for (int i = 0; i < elements.length; i++) {
            if (e == null) {
                if (elements[i] == null) {
                    return true;
                }
                return false;
            } else if (elements[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public E[] removeAll(E[] e) throws ElementDoesNotExistException {
        for (int i = 0; i < e.length; i++) {
            if (!(this.contains(e[i]))) {
                throw new ElementDoesNotExistException("Object does not exist"
                    + " in the set.", e[i]);
            }
        }

        E[] tempE = (E[]) new Object[e.length];

        for (int i = 0; i < e.length; i++) {
            tempE[i] = e[i];
            remove(e[i]);
        }

        return tempE;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        elements = (E[]) new Object[0];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                return false;
            }
        }
        return true;
    }

    public E getRandomElement() throws ElementDoesNotExistException {
        if (isEmpty()) {
            throw new ElementDoesNotExistException("Set is empty.");
        } else {
            return (E) elements[rand.nextInt(size)];
        }
    }

    public E[] toArray() {
        return elements;
    }

    @Override
    public String toString() {
        String out = "";

        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                out = out + "null ";
            } else {
                out = out + elements[i].toString() + " ";
            }
        }

        return out;
    }

    /**
     * Incremements the size of the elements array by 1
     */
    @SuppressWarnings("unchecked")
    private void incrementSet() {
        E[] elTemp = (E[]) new Object[size + 1];

        for (int i = 0; i < size; i++) {
            elTemp[i] = elements[i];
        }

        elements = elTemp;
    }
}