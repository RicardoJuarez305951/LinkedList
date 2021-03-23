package uaslp.ingenieria.labs.list;

public class ArrayList <H> implements List<H>{

    private Object array[];
    private int size;

    public ArrayList() {
        this.array = new Object[2];
    }

    @Override
    public void add(H data) {

        this.array[size++] = data;
    }

    @Override
    public H get(int index) {
        return (H)this.array[index];
    }

    @Override
    public void delete(int index) {
        List<H> lista = new ArrayList<>();
        int currentIndex = 0;

        if (index < 0 || index >= size) {
            return;
        }



        if (size == 0) {
            array[0] = null;    //head = null;
            array[1] = null;    //tail = null;
            return;
        }

        if (index == 0) {
            array[0] = array[1];    //head = head.next;
            array[1] = null;      //head.previous = null;
        }

        if (index == size) {
            array[size - 1] = array[size];//tail = tail.previous;
            array[size] = null;
        }

        if (index > 0 && index < size) {

            while (currentIndex < index) {
                array[currentIndex] = array[currentIndex + 1];
                currentIndex++;
            }
            array[currentIndex+1] = array[currentIndex+1];//currentNode.previous.next = currentNode.next;
            array[currentIndex] = array[currentIndex-1];//currentNode.next.previous = currentNode.previous;
        }

        size--;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<H> getIterator() {
        return null;
    }

    @Override
    public void insert(H data, Position position, Iterator<H> it) {

    }

    @Override
    public Iterator<H> getReverseIterator() {
        return null;
    }
}