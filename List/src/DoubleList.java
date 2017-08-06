import java.util.Iterator;

public class DoubleList<Item> implements Iterable<Item> {
    private DoubleNode first = null;
    private DoubleNode last = null;
    private int number = 0;

    @Override
    public Iterator<Item> iterator() {
        return new MyIterator();
    }
    private class MyIterator implements Iterator<Item> {
        private DoubleNode current = first;

        public boolean hasNext() {
            return current.following != null;
        }

        public void remove() {}

        public Item next() {
            Item item = current.item;
            current = current.following;

            return item;
        }
    }
    private class DoubleNode {
        Item item;
        DoubleNode previous;
        DoubleNode following;
    }

    public boolean isEmpty() {
        return number == 0;
    }

    public int size(){
        return number;
    }

    public void addFront(Item item) {
        DoubleNode oldFirst = first;

        first = new DoubleNode();
        first.item = item;
        first.following = oldFirst;
        first.previous = null;

        if (isEmpty()) last = first;
        else oldFirst.previous = first;

        number++;
    }

    public void addEnd(Item item) {
        DoubleNode oldLast = last;

        last = new DoubleNode();
        last.item = item;
        last.previous = oldLast;
        last.following = null;

        if (isEmpty()) first = last;
        else oldLast.following = last;

        number++;
    }

    public void add(int index, Item item) {
        if (index < 0 || index > number) {
            throw new IndexOutOfBoundsException();
        }
        else if (index == 0) {
            addFront(item);
        }
        else if (index == number){
            addEnd(item);
        }
        else {
            DoubleNode current;

            if (index <= number / 2) {
                current = first;

                for(int i = 1; i < index; i++) {
                    current = current.following;
                }

                DoubleNode follow = current.following;

                DoubleNode add = new DoubleNode();
                add.item = item;
                add.previous = current;
                add.following = follow;
                current.following = add;
                follow.previous = add;

                number++;
            }
            else {
                current = last;

                for(int i = number - 1; i > index; i--) {
                    current = current.previous;
                }

                DoubleNode previous = current.previous;

                DoubleNode add = new DoubleNode();
                add.item = item;
                add.following = current;
                add.previous = previous;
                current.previous = add;
                previous.following = add;

                number++;
            }
        }

    }

    public Item removeFront() {
        Item item;
        DoubleNode oldFirst = first;

        first = oldFirst.following;
        first.previous = null;
        item = oldFirst.item;
        oldFirst.following = null;

        number--;

        if (isEmpty()) last = null;

        return item;
    }

    public Item removeEnd() {
        Item item;
        DoubleNode oldLast = last;

        last = oldLast.previous;
        last.following = null;
        item = oldLast.item;
        oldLast.previous = null;

        number--;

        if (isEmpty()) first = null;

        return item;
    }

    public Item remove(int index) {
        if (index < 0 || index >= number) {
            throw new IndexOutOfBoundsException();
        }
        else if (index == 0) {
            return removeFront();
        }
        else if (index == number - 1) {
            return removeEnd();
        }
        else {
            DoubleNode current;
            Item item;

            if (index < number / 2) {
                current = first;

                for(int i = 0; i < index; i++) {
                    current = current.following;
                }

                DoubleNode previous = current.previous;
                DoubleNode follow = current.following;

                previous.following = follow;
                follow.previous = previous;
                item = current.item;
                current.previous = null;
                current.following = null;

                number--;

                return item;
            }
            else {
                current = last;

                for(int i = number - 1; i > index; i--) {
                    current = current.previous;
                }

                DoubleNode previous = current.previous;
                DoubleNode follow = current.following;

                previous.following = follow;
                follow.previous = previous;
                item = current.item;
                current.previous = null;
                current.following = null;

                number--;

                return item;
            }
        }
    }

    public static void main(String[] agrs) {
        DoubleList<String> myList = new DoubleList<>();

        myList.addFront("Hello ");
        myList.addEnd("World! ");
        myList.addEnd("hhh ");
        myList.add(3, "Oh ");

        myList.remove(0);

        for (DoubleList.DoubleNode x = myList.first; x != null; x = x.following){
            System.out.print(x.item);
        }
    }
}