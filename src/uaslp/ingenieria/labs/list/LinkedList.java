package uaslp.ingenieria.labs.list;

import static uaslp.ingenieria.labs.list.Position.AFTER;
import static uaslp.ingenieria.labs.list.Position.BEFORE;

/**
 * Lista doblemente ligada
 */
public class LinkedList<G> implements List<G> {

    private static class Node<T>{
        private final T data;
        private Node<T> previous;
        private Node<T> next;

        Node(T data){
            this.data = data;
        }
    }

    public class ForwardIterator implements Iterator<G> {
        private Node<G> currentNode;

        public ForwardIterator(){
            this.currentNode = head;
        }

        @Override
        public boolean hasNext(){
            return currentNode != null;
        }

        @Override
        public G next(){
            G data = currentNode.data;
            currentNode = currentNode.next;
            return data;
        }
    }

    public class ReverseIterator implements Iterator<G>{
        private Node<G> currentNode;

        public ReverseIterator(){
            this.currentNode = tail;
        }

        @Override
        public boolean hasNext(){
            return currentNode != null;
        }

        @Override
        public G next(){
            G data = currentNode.data;
            currentNode = currentNode.previous;
            return data;
        }
    }

    private Node<G> head;
    private Node<G> tail;
    private int size;
    private static int listsCount = 0;

    public LinkedList(){
        listsCount++;
    }

    public static int getListsCount(){
        return listsCount;
    }

    /***
     * Inserts data at the end of the list
     * @param data Data to be inserted
     */
    @Override
    public void add(G data){
        Node<G> node = new Node<>(data);
        node.previous = tail;

        if(tail != null){
            tail.next = node;
        }

        if(head == null){
            head = node;
        }

        tail = node;
        size++;
    }

    /**
     * @param index 0-index
     * @return data in index
     */
    @Override
    public G get(int index){
        Node<G> currentNode = head;
        int currentindex = 0;

        while(currentindex < index){
            currentNode = currentNode.next;
            currentindex++;
        }

        return currentNode.data;
    }

    /**
     * @param index 0-index
     */
    @Override
    public void delete(int index) throws MyIndexOutOfBoundsException{
        Node<G> currentNode = head;
        int currentIndex = 0;

        if(index < 0 || index >= size){
            throw new MyIndexOutOfBoundsException();
        }
        size--;

        if(size == 0){
            head = null;
            tail = null;
            return;
        }

        if(index == 0){
            head = head.next;
            head.previous = null;
        }

        if(index == size){
            tail = tail.previous;
            tail.next = null;
        }

        if(index > 0 && index < size){
            while(currentIndex < index){
                currentNode = currentNode.next;
                currentIndex++;
            }
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
        }
    }

    @Override
    public ForwardIterator getIterator(){
        return new ForwardIterator();
    }

    @Override
    public ReverseIterator getReverseIterator(){
        return new ReverseIterator();
    }

    @Override
    public void insert(G data, Position position, Iterator<G> it) {


        Node<G> newNode = new Node<>(data);
        Node<G> currentNode =((ForwardIterator)it).currentNode;

        if (position == AFTER) {
            newNode.next = currentNode.next;
            newNode.previous = currentNode;
            currentNode.next = newNode;
            if (newNode.next != null) {
                newNode.next.previous = newNode;
            } else {
                tail = newNode;
            }
        } else if (position == BEFORE) {
            newNode.previous = currentNode.previous;
            newNode.next = currentNode;
            currentNode.previous = newNode;
            if (newNode.previous != null) {
                newNode.previous.next = newNode;
            } else {
                head = newNode;
            }
        } else {
            System.out.println("No conozco el valor de position");
        }
        size++;
    }

    @Override
    public int getSize() {
        return size;
    }
}