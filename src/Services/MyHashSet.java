package Services;

import java.util.LinkedList;

public class MyHashSet<T> {
    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<T>[] buckets;
    private int size;

    public MyHashSet() {
        buckets = new LinkedList[INITIAL_CAPACITY];
    }

    // Метод для добавления элемента
    public void add(T value) {
        int index = getIndex(value);

        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        if (!buckets[index].contains(value)) {
            buckets[index].add(value);
            size++;
        }
    }

    // Метод для удаления элемента
    public void remove(T value) {
        int index = getIndex(value);

        if (buckets[index] != null && buckets[index].remove(value)) {
            size--;
        }
    }

    // Метод для отображения содержимого множества
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (LinkedList<T> bucket : buckets) {
            if (bucket != null) {
                for (T item : bucket) {
                    sb.append(item).append(", ");
                }
            }
        }
        if (sb.length() > 1) sb.setLength(sb.length() - 2); // убрать последнюю запятую
        sb.append("}");
        return sb.toString();
    }

    // Текущий размер множества
    public int size() {
        return size;
    }

    // Вспомогательный метод: получение индекса в массиве по хешу
    private int getIndex(T value) {
        return Math.abs(value.hashCode() % buckets.length);
    }
}
