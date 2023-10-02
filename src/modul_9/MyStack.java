package modul_9;

public class MyStack<T> {

    private int size;
    private Node <T> head;
    private Node <T> tail;

    public void push(Object value) { // метод добавления элементов
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
        return (Node<T>) tail.data;
    }
    public Node<T> pop(){
        if(head == null){
            throw new IllegalStateException("Queue is empty");
        }
        Node current = tail.previous;
        current.next = null;
        tail = null;
        size--;
        return (Node<T>) current.data;
    }

}
