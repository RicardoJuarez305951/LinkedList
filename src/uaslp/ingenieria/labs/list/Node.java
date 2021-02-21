package uaslp.ingenieria.labs.list;

class Node {
    //Atributos
    int dato;
    Node next;
    Node previous;

    //Métodos

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public int getDato() {
        return dato;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrevious() {
        return previous;
    }
}
