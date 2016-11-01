package model;

import java.util.Random;

public class MySet<E> implements SimpleSet<E> {

    private E[] items;
    private int itemCount;
    private String message;

    public MySet() {
        items = (E[]) new Object[10];
        itemCount = 0;
    }

    public boolean add(E e) {
        if (!(contains(e))) {
            if (items.length == itemCount) {
                E[] tempArray = (E[]) new Object[items.length * 2];
                for (int i = 0; i < items.length; i++) {
                    tempArray[i] = items[i];
                }
                items = tempArray;
            }
            items[itemCount] = e;
            itemCount++;
            return true;
        }
        return false;
    }

    public E remove(E e) throws ElementDoesNotExistException {
        if (!contains(e)) {
            throw new ElementDoesNotExistException(e.toString()
                + " does not exist!");
        }
        E removeElem = null;
        for (int i = 0; i < itemCount; i++) {
            if (e.equals(items[i])) {
                removeElem = items[i];
                items[i] = null;
                for (int j = i; j < itemCount; j++) {
                    if (j == (itemCount - 1)) {
                        items[j] = null;
                    } else {
                        items[j] = items[j + 1];
                    }
                }
                itemCount--;
            }
        }
        return removeElem;
    }

    public boolean contains(E e) {
        for (int i = 0; i < items.length; i++) {
            if (e.equals(items[i])) {
                return true;
            }
        }
        return false;
    }

    public E[] removeAll(E[] e) throws ElementDoesNotExistException {
        int count = 0;
        for (E elem : e) {
            if (contains(elem)) {
                count++;
            }
        }
        if (count == e.length) {
            E[] removeArray = (E[]) new Object[count];
            int pos = 0;
            for (int i = 0; i < e.length; i++) {
                removeArray[pos] = remove(e[i]);
                pos++;
            }
            return removeArray;
        } else {
            throw new ElementDoesNotExistException("At least one element"
                + " does not exist!");
        }
    }

    public void clear() {
        items = (E[]) new Object[10];
        itemCount = 0;
    }

    public int size() {
        return itemCount;
    }

    public boolean isEmpty() {
        return (itemCount == 0);
    }

    public E getRandomElement() throws ElementDoesNotExistException {
        Random pos = new Random();
        if (isEmpty()) {
            throw new ElementDoesNotExistException("There are no"
            + " elements in the set");
        }
        return items[pos.nextInt(items.length - 1)];
    }

    public E[] toArray() {
        int pos = 0;
        E[] noNullArray = (E[]) new Object[itemCount];
        for (int i = 0; i < itemCount; i++) {
            noNullArray[pos] = items[i];
            pos++;
        }
        return noNullArray;
    }

    @Override
    public String toString() {
        for (int i = 0; i < itemCount; i++) {
            if (i == 0) {
                message = "[" + items[i] + ", ";
            } else if (i == (itemCount - 1)) {
                message = message + items[i] + "]";
            } else {
                message = message + items[i] + ", ";
            }
        }
        return message;
    }
}