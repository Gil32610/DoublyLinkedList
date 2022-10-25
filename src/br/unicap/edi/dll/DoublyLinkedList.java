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

    public void insertLast(T content) {
        DoublyLinkedNode<T> node = new DoublyLinkedNode(content);
        if (this.isEmpty()) {
            this.first = node;
            this.last = node;
            this.quantity++;
        } else {
            this.last.setNext(node);
            node.setPrevious(this.last);
            this.last = node;
            this.quantity++;
        }
    }

    public void showAll() {
        DoublyLinkedNode<T> current;
        if (this.isEmpty()) {
            System.out.println("Empty List");
        } else {
            current = this.first;
            while (current != null) {
                System.out.println(current.getContent() + " ");
                current = current.getNext();
            }
        }
    }

    public void reverseShowAll() {
        DoublyLinkedNode<T> current;
        if (this.isEmpty()) {
            System.out.println("Empty List");
        } else {
            current = this.last;
            while (current != null) {
                System.out.println(current.getContent() + " ");
                current = current.getPrevious();
            }
        }
    }

    public void removeFirst() {
        if (this.isEmpty()) {
            System.out.println("Empty list");
        } else if (this.quantity == 1) {
            this.first = null;
            this.last = null;
            this.quantity = 0;
        } else {
            this.first = this.first.getNext();
            this.first.setPrevious(null);
            this.quantity--;
        }
    }

    public void removeLast() {
        if (this.isEmpty()) {
            System.out.println("Empty list");
        } else if (this.quantity == 1) {
            this.first = null;
            this.last = null;
            this.quantity = 0;
        } else {
            this.last = this.last.getPrevious();
            this.last.setNext(null);
            this.quantity--;
        }
    }

    public void removeNode(T content) {

    }

    public void insertionSort(T content) {
        DoublyLinkedNode<T> current;
        DoublyLinkedNode<T> node = new DoublyLinkedNode<>(content);
        if (this.isEmpty()) {
            this.first = node;
            this.last = node;
            this.quantity++;
        } else if (content.compareTo(this.first.getContent()) < 0) {
            this.first.setPrevious(node);
            node.setNext(this.first);
            this.first = node;
            this.quantity++;
        } else if (content.compareTo(this.last.getContent()) > 0) {
            this.last.setNext(node);
            node.setPrevious(this.last);
            this.last = node;
            this.quantity++;
        } else {
            current = this.first.getNext();

            while (current != null) {
                if (content.compareTo(current.getContent()) < 0) {
                    node.setNext(current);
                    current.getPrevious().setNext(node);
                    current.setPrevious(node);
                    this.quantity++;
                }
                else{
                    current = current.getNext();
                }
            }
        }
    }
}
