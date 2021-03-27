package uaslp.ingenieria.labs.list;


public class ArrayList <H> implements List<H>{

    private Object[] array;
    private int size;

    public ArrayList() {
        this.array = new Object[2];
    }

    @Override
    public void add(H data) {
        if(array.length <= size){
            Object[] arrayN = new Object[array.length + 2];
            System.arraycopy(array, 0, arrayN, 0, array.length);
            array = arrayN;
        }
        this.array[size] = data;
        size++;
    }

    @Override
    public H get(int index) {
        return (H)this.array[index];
    }

    @Override
    public void delete(int index) {
        if(index < 0 && index >= size){
            return;
        } else{

            for (int currentIndex = index + 1; currentIndex < size; currentIndex++){
                array[currentIndex - 1] = array[currentIndex];
            }
            size--;
        }
}

    @Override
    public void insert(H data, Position position, Iterator<H> it) {
    }


        public class ForwardIterator implements Iterator<H> {
            private int currentIndex;

            public boolean hasNext(){
                return currentIndex < size;
            }

            public H next(){
                return (H) array[currentIndex++];
            }
        }

        public class ReverseIterator implements Iterator<H> {
            private int currentIndex;

            public ReverseIterator(){
                currentIndex = size - 1;
            }

            public boolean hasNext(){
                return currentIndex > 0;
            }

            public H next(){
                return (H) array[currentIndex--];
            }
        }

        @Override
        public Iterator<H> getIterator() {
            return new ForwardIterator();
        }

        @Override
        public int getSize() {
            return size;
        }

        @Override
        public ReverseIterator getReverseIterator() {
            return new ReverseIterator();
        }
}

