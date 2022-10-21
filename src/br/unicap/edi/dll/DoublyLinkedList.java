package br.unicap.edi.dll;

public class DoublyLinkedList<T extends Comparable<T>> {
    private DoublyLinkedNode<T> first;
    private DoublyLinkedNode<T> last;
    private int quantity;
    private int capacity;

    public boolean isEmpty() {
        if (this.quantity == 0 || this.first == null || this.last == null) {
            return true;
        }
        return false;
    }

    public DoublyLinkedList(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        if (this.quantity == this.capacity) {
            return true;
        }
        return false;
    }

    public void insertFirst(T content) {
        DoublyLinkedNode<T> node = new DoublyLinkedNode(content);
        if (this.isEmpty()) {
            this.first = node;
            this.last = node;
            this.quantity++;
        } else {
            node.setNext(this.first);
            this.first.setPrevious(node);
            this.first = node;
            this.quantity++;
        }

    }

}
