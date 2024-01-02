package datastructures;

public class LinkList<T> {
    private LinkNode<T> head;
    private LinkNode<T> tail;

    void addFirst(T value) {
        head = new LinkNode<>(value, head);
        if(tail == null) { tail = head; }
    }

    void addBack(T value) {
        LinkNode<T> node = new LinkNode<>(value);
        tail.next = node;
        node.previous = tail;
        tail = node;
    }

    void removeFirst(T value) {}
    void removeBack(T value) {}
}
