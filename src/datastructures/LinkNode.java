package datastructures;

public class LinkList {
    public int val;
    public LinkList next;
    public LinkList() {}
    public LinkList(int val) { this.val = val; }
    public LinkList(int val, LinkList next) { this.val = val; this.next = next; }
}