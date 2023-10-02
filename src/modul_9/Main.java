package modul_9;

public class Main {
    public static void main(String[] args) {

    /*    MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(5);
        myArrayList.add(5);
        myArrayList.add(5);
        myArrayList.add(5);
        myArrayList.add(5);
      //  System.out.println(myArrayList);
        myArrayList.remove(0);
        System.out.println(myArrayList);

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(6);
        myLinkedList.add(3);
        myLinkedList.add(1);

        System.out.println(myLinkedList);
        myArrayList.remove(0);
        System.out.println(myLinkedList);*/



        MyHashMap myHashMap = new MyHashMap();

        myHashMap.put(1,"Example1");
        myHashMap.put(2,"Example2");

        System.out.println(myHashMap);
        System.out.println(myHashMap.size);

        System.out.println(myHashMap.get(1));
        myHashMap.remove(1);
        System.out.println(myHashMap);;

    }
}
