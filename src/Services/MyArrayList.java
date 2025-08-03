package Services;

import java.util.Arrays;

public class MyArrayList<T> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Добавление одного элемента
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    // Получение элемента по индексу
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    // Удаление по индексу
    public void remove(int index) {
        checkIndex(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // очистка последнего элемента
    }

    // Добавление всех элементов из другого MyArrayList
    public void addAll(MyArrayList<T> otherList) {
        for (int i = 0; i < otherList.size(); i++) {
            this.add(otherList.get(i));
        }
    }

    // Возвращает текущий размер
    public int size() {
        return size;
    }

    // Вспомогательный метод: увеличение массива при необходимости
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    // Вспомогательный метод: проверка индекса
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Переопределим toString для удобства вывода
    @Override
    public String toString() {
        Object[] actual = Arrays.copyOf(elements, size);
        return Arrays.toString(actual);
    }
}