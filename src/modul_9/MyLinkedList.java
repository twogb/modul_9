package modul_9;


public class MyLinkedList<T> {

    private Node<T> head; // место хранения
    private Node<T> tail; // место хранения последнего элемента
    private int size; // размер

    public MyLinkedList() { // в конструкторе инициализация полей класса по дефолту
        head = null;
        size = 0;

    }


    public int size() { // метод для возвращения длины списка
        return size;
    }

    public boolean isEmpty() { // проверка пустой или нет список
        return size == 0;// == ----> возвращает true false
    }

    public void clear() { // метод для чистки, очищает
        head = null;
        size = 0;
    }

    public T get(int index) { // метод для получения элемента по индексу
        if (index < 0 || index >= size) { // проверка на наличия индекса
            throw new IndexOutOfBoundsException("Вышли за пределы длины списка");
        }

        Node<T> current = head; // хранения начального значения
        for (int i = 0; i < index; i++) { // проходимся по индексу
            current = current.next; // указатель от одного элемента к следующему
        }
        return current.data; // если такой индекс есть , то возвращается такой элемент

    }

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

    public void remove(int index) {  //
        if (index < 0 || index >= size) {// проверка на наличие индекса
            throw new IndexOutOfBoundsException("Вышли за пределы длины списка");
        }

        if (index == 0) { //  если индекс равен 0, то
            head = head.next; // устанавливаем для head первый элементы списка
        } else {
            Node<T> current = head; // создаем переменную первого значения
            for (int i = 0; i < index; i++) { // в форе мы проходимся для поиска узла
                current = current.next; // перемещение к следующему узлу на каждой итерации цикла
            }
           current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        size--; // уменьшение длины списка
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        Node<T> current = head;
        while (current != null) // если список не пустой
        {
            builder.append(current.data).append(" "); // то к значению мы добавляем пробел
            current = current.next; // указатель на следующий элемент

        }
        return builder.toString();
    }

}

class Node<T> { // реализация head
    T data; // хранилище для значения
    Node<T> next; // узел
    Node<T> previous;

    Node(T data) { // инициализация полей класса node
        this.data = data;
    }
}
