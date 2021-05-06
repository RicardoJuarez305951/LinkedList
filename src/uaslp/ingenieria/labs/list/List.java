package uaslp.ingenieria.labs.list;

public interface List <T> {

    void add(T data);

    T get(int index);

    void delete(int index) throws MyIndexOutOfBoundsException;

    int getSize();

    Iterator<T> getIterator();

    Iterator<T> getReverseIterator();

    void insert(T data, Position position, Iterator<T> it);
}