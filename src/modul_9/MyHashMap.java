package modul_9;

import javax.imageio.ImageIO;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyHashMap {
    /*
    Написати свій клас MyHashMap як аналог класу HashMap.

Потрібно робити за допомогою однозв'язної Node.

Не може зберігати дві ноди з однаковими ключами.

Методи

put(Object key, Object value) додає пару ключ + значення
remove(Object key) видаляє пару за ключем
clear() очищає колекцію
size() повертає розмір колекції
get(Object key) повертає значення (Object value) за ключем
     */
    private Entry[] table;
    public int size;
    private int capacity;

    public static class Entry {
        Object key;
        Object value;
        Entry next;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;

        }

    }

    public MyHashMap() {
        capacity = 16;
        table = new Entry[capacity];
        size = 0;
    }

    public Object get(Object key) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && table[i].key.equals(key)) {
                return table[i].value;
            }
        }
        return null;
    }

    private int hash(Object key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public void put(Object key, Object value) {
        int index = hash(key);
        Entry newNode = new Entry(key, value);

        Entry current = table[index];


        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        newNode.next = table[index];
        table[index] = newNode;
        size++;
    }


    public void remove(Object key) {

        int index = hash(key);
        Entry current = table[index];
        Entry prev = null;


        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }

        throw new NoSuchElementException("Key not found");
    }


    public void clear() {
        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{ ");
        boolean first = true;

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                if (!first) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(table[i].key).append(" = ").append(table[i].value);
                first = false;

            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();

    }


}

