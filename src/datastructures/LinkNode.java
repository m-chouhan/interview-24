package datastructures;

public class LinkNode<T> {
    public T val;
    public LinkNode<T> next;
    public LinkNode<T> previous;
    public LinkNode() {}
    public LinkNode(T val) { this.val = val; }
    public LinkNode(T val, LinkNode<T> next) {
        this.val = val;
        this.next = next;
        next.previous = this;
    }
}