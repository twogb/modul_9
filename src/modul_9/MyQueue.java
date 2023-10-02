package modul_9;


public class MyQueue<T> {

    /*
    Написати свій клас MyQueue як аналог класу Queue, який буде працювати за принципом FIFO (first-in-first-out).

Можна робити за допомогою Node або використати масив.

Методи

add(Object value) додає елемент в кінець
clear() очищає колекцію
size() повертає розмір колекції
peek() повертає перший елемент з черги
poll() повертає перший елемент з черги і видаляє його з колекції
     */
    private int size;
    private Node <T> head;
    private Node <T> tail;

    public void add(Object value) { // метод добавления элементов
        T data = (T) value; // конвертирования обджекта дженерика
        Node<T> newNode = new Node<>(data); // создаем этот элемент
        if (head == null) { // проверка на пустой список
            head = newNode; // если он пустой, то newNode становится начальным значением списка
            tail = newNode;
        } else {
            tail.next = newNode; // назначения для последнего элемента --->  следующего
            newNode.previous = tail; // назначения previous элемента
            tail = newNode;
        }
        size++; // при добавлении каждого элемента размер увеличивается
    }
    public  void clear(){
        head = null;
        tail = null;
    }
    public int size(){
        return  size;
    }
    public Node<T> peek(){
        if(head == null){
            throw new IllegalStateException("Queue is empty");
        }
        return (Node<T>) head.data;
    }
    public Node<T> poll(){
        if(head == null){
            throw new IllegalStateException("Queue is empty");
        }
        Node current = head.next;
        current.previous = null;
        head = null;
        size--;
        return (Node<T>) current.data;
    }


}


