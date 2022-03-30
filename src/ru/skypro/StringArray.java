package ru.skypro;

import java.util.Arrays;

public class StringArray implements StringList {

    private String[] list;
    private int size;
    private static final int DEFAULT_CAPACITY = 2;

    public StringArray() {
        this.list = new String[DEFAULT_CAPACITY];
    }

    public StringArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Размер массива не может быть меньше или равным нулю");
        } else {
            this.list = new String[capacity];
        }
    }

    private void checkNull(String item) {
        if (item == null) {
            throw new ValueNullException("Параметр null");
        }
    }

    private void addSize() {
        int newCapacity = list.length * 2;
        list = Arrays.copyOf(list, newCapacity);
    }

    @Override
    public String add(String item) {
        checkNull(item);
        if (size == list.length) {
            addSize();
        }
        list[size++] = item;

        return item;
    }


    @Override
    public String add(int index, String item) {
        checkNull(item);
        if (index < 0 || index > size - 1) {
            throw new NoIndexException("Элемент индекса неверный");
        }

        if (size == list.length) {
            addSize();
        }

        System.arraycopy(list,index,list,index+1,size-index);
        size++;
        return item;
    }


    @Override
    public String set(int index, String item) {
        checkNull(item);
        if (index < 0 || index > size - 1) {
            throw new NoIndexException("Элемент индекса неверный");
        }
        return list[index] = item;

    }

    @Override
    public String remove(String item) {
        checkNull(item);
        int pos = indexOf(item);
        if (pos < 0) {
            throw new ElementNotFoundException("Такого элемента нет");
        }
        remove(pos);
        return item;
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new NoIndexException("Элемент индекса неверный");
        }

        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }

        size--;
        return list[index];
    }

    @Override
    public boolean contains(String item) {
        checkNull(item);
        for (int i = 0; i < size; i++) {
            if (item.contains(list[i]))
                return true;
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        checkNull(item);
        for (int i = 0; i < size; i++) {
            if (item.equals(list[i]))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        checkNull(item);
        for (int i = size - 1; i >= 0; i--) {
            if (item.equals(list[i]))
                return i;
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index > size - 1) {
            throw new NoIndexException("Элемент индекса неверный");
        }
        return list[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null || size != otherList.size()) {
            return false;
        }
        for (int i = 0; i <= size; i++) {
            if (!get(i).equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
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
        list = new String[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(list, size);
    }
}
