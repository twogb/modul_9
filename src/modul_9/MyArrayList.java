package modul_9;

import java.util.*;

public class MyArrayList<T> {

    private final static int DEFAULT_CAPACITY = 10; // стартовые размеры ArrayList (дефолтная емкость)
    private Object[] array;  // место для хранения данных
    private int size;        // наш размер

    public MyArrayList() {

        array = new Object[DEFAULT_CAPACITY]; // указали длину массива с помощью DEFAULT_CAPACITY
        size = 0;
    }

    public int size() {     // получения длины списка
        return size;
    }

    public void clear() {   // очистка всего списка
        for (int i = 0; i < size; i++) {
            array[i] = null; // убираем знамения, оставляем null
        }
        size = 0;            // сброс длины списка
    }

    public T get(int index) {    // получения элемента по индексу
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вышел за пределы массива");
        }
        return (T) array[index];
    }

    public void add(Object value) {           // добавляем значения
        updateCapacity(size + 1); // 11
        array[size++] = value; // добавление элемента в массив
    }

    public void remove(int index) {          // удаляем наши значения

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вышел за пределы массива");
        }

        for(int i = index + 1; i < size; i++){ // сдвиг влево
            array[i - 1] = array[i];
        }
        array[--size] = null;
    }

    public void updateCapacity(int minCapacity) {  // обновление старого размера массива на новый

        if (minCapacity > array.length) {            // проверка на увеличение размера массива
            int maxCapacity = Math.max(minCapacity, array.length * 2); // увеличение размера массива в два раза
            array = Arrays.copyOf(array, maxCapacity); // обновления старого массива на новый
        }
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("[ ");          // создаем строку
        for (int i = 0; i < size; i++) { // проходимся по длине списка
            builder.append(array[i]);  // добавляем элементы нашего списка
            if (i < size - 1) {          // проверка, что текущий элемент не является последним элементом
                builder.append(", ");  // добавляем после каждого элемента запятую
            }
        }
        builder.append(" ]");          // закрываем нашу строку
        return builder.toString();
    }


}
