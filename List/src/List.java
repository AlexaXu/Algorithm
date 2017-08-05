import java.util.*;

public class List<Item> implements Iterable<Item>{
    private Node first = null;
    private Node last = null;
    private int number = 0;

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
    private class MyIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current.next != null;
        }

        public void remove() {}

        public Item next() {
            Item item = current.item;
            current = current.next;

            return item;
        }
    }

    private class Node {
        Item item;
        Node next;


    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return number;
    }

    public void add(Item item) {
        Node oldLast = last;

        last = new Node();
        last.item = item;
        last.next = null;

        if(isEmpty()) first = last;
        else oldLast.next = last;

        number++;
    }

    public void add(int index, Item item) {
        if (index > number) {
            throw new IndexOutOfBoundsException();
        }
        else if (index == 0) {
            Node oldFirst = first;

            first = new Node();
            first.item = item;
            first.next = oldFirst;

            number++;
        }
        else if (index == number) {
            add(item);
        }
        else {
            Node current = first;
            Node addItem;

            for(int i = 1; i < index; i++) {
                current = current.next;
            }

            addItem = new Node();
            addItem.item = item;
            addItem.next = current.next;
            current.next = addItem;

            number++;
        }
    }

    public Item getItem(int index) {
        if(index >= number) {
            throw new IndexOutOfBoundsException();
        }

        Node current = first;

        for(int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.item;
    }

    public Item remove(int index) {
        Item item;

        if (index >= number) {
            throw new IndexOutOfBoundsException();
        }
        else if (index == 0) {
            item = first.item;
            first = first.next;
            if(isEmpty()) last = null;
        }
        else if (index == number - 1) {
            Node current = first;

            for(int i = 1; i < number - 1; i++) {
                current = current.next;
            }

            item = current.next.item;
            current.next = null;
        }
        else {
            Node current = first;
            Node delete;

            for(int i = 1; i < index; i++) {
                current = current.next;
            }

            delete = current.next;

            item = delete.item;
            current.next = delete.next;
            delete.next = null;
        }

        number--;

        return item;
    }
    public static void main(String[] args) {
        List<String > myList = new List<>();

        myList.add("Hello ");
        myList.add("World! ");
        myList.add("Oh ");
        myList.add("hhh ");
        myList.add(3,"What ");

        myList.remove(2);


        for (List.Node x = myList.first; x != null; x = x.next){
            System.out.print(x.item);
        }
    }
}
