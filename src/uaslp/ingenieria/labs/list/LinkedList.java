package uaslp.ingenieria.labs.list;

import static uaslp.ingenieria.labs.list.Position.AFTER;
import static uaslp.ingenieria.labs.list.Position.BEFORE;

/**
 * Lista doblemente ligada
 */
public class LinkedList<G> {

    private static class Node<T>{
        private final T data;
        private Node<T> previous;
        private Node<T> next;

        Node(T data){
            this.data = data;
        }

    }

    private Node<G> head;
    private Node<G> tail;
    private int size;

    public LinkedList() {
        listsCount ++;
    }

    private static int listsCount = 0;

    public static int getListsCount(){
        return listsCount;
    }




    public class Iterator {
        private Node<G> currentNode;

        public Iterator() {
            this.currentNode = head;
        }

        public Iterator(Iterator iterator){
            currentNode = iterator.currentNode;
        }

        public boolean hasNext(){
            return currentNode != null;
        }

        public G next(){
            G data = currentNode.data; // A pesar de que data es private, la outer class (LinkedList) tiene acceso al campo

            currentNode = currentNode.next;

            return data;
        }

        Node<G> getCurrentNode() {  // modificador de acceso se llama -> package-private
            return currentNode;
        }
    }

    public class ReverseIterator {

        private Node<G> currentNode;

        public ReverseIterator() {
            this.currentNode = tail;
        }


        public boolean hasNext(){
            return currentNode != null;
        }

        public G next(){
            G data = currentNode.data;

            currentNode = currentNode.previous;

            return data;
        }
    }

    /**
     * Inserts data at the end of the list
     *
     * @param data Data to be inserted
     */
    public void add(G data) {
        Node<G> node = new Node<>(data);

        node.previous = tail;

        if (tail != null) {
            tail.next = node;
        }

        if (head == null) {
            head = node;
        }

        tail = node;
        size++;
    }

    /**
     * @param index 0-index
     * @return data in index
     */
    public G get(int index) {
        Node<G> currentNode = head;
        int currentIndex = 0;

        while (currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
        }

        return currentNode.data;
    }

    public void delete(int index) {
        Node<G> currentNode = head;
        int currentIndex = 0;

        if (index < 0 || index >= size) {
            return;
        }

        size--;

        if (size == 0) {
            head = null;
            tail = null;
            return;
        }

        if (index == 0) {
            head = head.next;
            head.previous = null;
        }

        if (index == size) {
            tail = tail.previous;
            tail.next = null;
        }

        if (index > 0 && index < size) {
            while (currentIndex < index) {
                currentNode = currentNode.next;
                currentIndex++;
            }
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
        }


    }

    public Iterator getIterator() {
        return new Iterator();
    }

    public void insert(G data, Position position, Iterator it) {


        Node<G> newNode = new Node<>(data);
        Node<G> currentNode = it.getCurrentNode();

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

    public int getSize() {
        return size;
    }

    public ReverseIterator getReverseIterator() {
        return new ReverseIterator();
    }
}