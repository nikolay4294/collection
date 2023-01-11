package collections.arrayList;

import java.util.Collection;

public class MyArrayList<T> {

    private final int INIT_SIZE = 6;
    private int pointer = 0;
    private Object[] array = new Object[INIT_SIZE];

    public void add(T item) {
        if (pointer == array.length)
            resize(array.length * 2);
        array[pointer++] = item;
    }

    public void add(int index, T item) {
        if (pointer == array.length)
            resize(array.length * 2);

        T[] tempArray = (T[]) new Object[array.length];
        System.arraycopy(array, index, tempArray, 0, pointer - index);

        array[index] = item;
        pointer++;

        if (tempArray.length + array.length > array.length) {
            resize(array.length + tempArray.length);
        } else
            System.arraycopy(tempArray, 0, array, index + 1, tempArray.length);
    }

    public void addAll(Collection<T> c) {
        if (array.length < pointer + c.size())
            resize(array.length * 2);
        T[] tempArray = (T[]) c.toArray();
        System.arraycopy(tempArray, 0, array, pointer, tempArray.length);
    }

    public void remove(int index) {
        for (int i = index; i < pointer; i++)
            array[i] = array[i + 1];
        array[pointer] = null;
        pointer--;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public int size() {
        return array.length;
    }

    public void update(int index, T item) {
        array[index] = item;
    }

    public int indexOf(T item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

    // в методе использую сортировку пузырьком с флагом.
    public boolean sort(int[] array) {
        boolean flag = true;

        for (int out = array.length - 1; out > 1; out--) {
            for (int in = 0; in < out; in++) {
                if (array[in] > array[in + 1]) {
                    int temp =  array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = temp;
                } else {
                    flag = false;
                    System.out.println("коллекция уже отсортирована");
                }
            }
        }
        return flag;
    }
}
