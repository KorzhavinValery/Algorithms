package pro.sky.algorithms.service.impl;

import pro.sky.algorithms.exceptions.InvalidIndexException;
import pro.sky.algorithms.exceptions.NullItemException;
import pro.sky.algorithms.exceptions.StorageIsFullException;
import pro.sky.algorithms.service.StringList;

import java.util.Arrays;

public class StringListImpl implements StringList {
 private  final String [] stringList;
 private int size;

    public StringListImpl() {
        stringList = new String[12];
    }
    public StringListImpl(int intSize) {
        stringList = new String[intSize];
    }

    @Override
    public String add(String item) {
        checkSize();
        checkItem(item);
        stringList[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        checkSize();
        checkIndex(index);
        checkItem(item);
        if (index == size) {
            stringList[size++] = item;
            return item;
        }
        System.arraycopy(stringList, index, stringList, index + 1, size - index);
        return  item;
    }

    @Override
    public String set(int index, String item) {
        checkIndex(index);
        checkItem(item);
        stringList[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        checkItem(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public String remove(int index) {
        checkIndex(index);
        String item = stringList[index];
        if (index != size) {
            System.arraycopy(stringList, index, stringList, index, size - 1 - index);
        }
        size--;

        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            String s = stringList[i];
            if (s.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size -1; i >= 0; i--) {
            if (stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIndex(index);

        return stringList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(stringList, size);
    }

    private void checkSize() {
        if (size == stringList.length) {
            throw new StorageIsFullException();
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }

    private void checkItem(String item) {
        if (item == null) {
            throw new NullItemException();
        }
    }
}
