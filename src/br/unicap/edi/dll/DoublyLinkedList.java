package br.unicap.edi.dll;

public class DoublyLinkedList<T extends Comparable<T>> {
    private DoublyLinkedNode<T> first;
    private DoublyLinkedNode<T> last;
    private int quantity;
    private int capacity;

    public int getQuantity() {
        return this.quantity;
    }

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
        DoublyLinkedNode<T> wasAdded = search(content);

        if (wasAdded == null) {
            System.out.println("Was not added to the List");
        } else if (this.quantity == 1) {
            this.first = null;
            this.last = null;
            this.quantity = 0;
        } else if (this.first == wasAdded) {
            this.first = this.first.getNext();
            this.first.setPrevious(null);
            this.quantity--;
        } else if (this.last == wasAdded) {
            this.last = this.last.getPrevious();
            this.last.setNext(null);
            this.quantity--;
        } else {
            wasAdded.getPrevious().setNext(wasAdded.getNext());
            wasAdded.getNext().setPrevious(wasAdded.getPrevious());
            this.quantity--;
        }

    }

    public void insertionSort(T content) {
        DoublyLinkedNode<T> current;
        DoublyLinkedNode<T> node = new DoublyLinkedNode<>(content);
        if (this.isEmpty()) {
            this.first = node;
            this.last = node;
            this.quantity++;
            System.out.println("Content added!");
        } else if (content.compareTo(this.first.getContent()) < 0) {
            this.first.setPrevious(node);
            node.setNext(this.first);
            this.first = node;
            this.quantity++;
            System.out.println("Content added!");
        } else if (content.compareTo(this.last.getContent()) > 0) {
            this.last.setNext(node);
            node.setPrevious(this.last);
            this.last = node;
            this.quantity++;
            System.out.println("Content added!");
        } else if (content.compareTo(this.first.getContent()) == 0) {
            System.out.println("Already exists");
        } else if (content.compareTo(this.last.getContent()) == 0) {
            System.out.println("Already exists");
        } else {
            current = this.first.getNext();
            while (current != null) {
                if (content.compareTo(current.getContent()) < 0) {
                    node.setNext(current);
                    node.setPrevious(current.getPrevious());
                    current.getPrevious().setNext(node);
                    current.setPrevious(node);
                    this.quantity++;
                    System.out.println("Content added!");
                    break;
                }
                if (content.compareTo(current.getContent()) == 0) {
                    System.out.println("Already exists");
                    break;
                } else {
                    current = current.getNext();
                }
            }
        }
    }

    public DoublyLinkedNode<T> search(T content) {
        if (this.isEmpty()) {
            return null;
        } else if (content.compareTo(this.last.getContent()) > 0) {
            return null;
        } else if (content.compareTo(this.last.getContent()) == 0) {
            return this.last;
        } else {
            DoublyLinkedNode<T> current = this.first;
            while (current.getNext() != null) {
                if (content.compareTo(current.getContent()) == 0) {
                    return current;
                }
                if (content.compareTo(current.getContent()) < 0) {
                    return null;
                }
                current = current.getNext();
            }
            return null;
        }

    }

}
