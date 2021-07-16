package datastructure.linkedlist;

public class CircularBuffer {
    private int size;
    private int capacity;
    private CircularBufferNode head;
    private CircularBufferNode tail;
    private boolean overflow;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = null;
        this.tail = null;
        this.overflow = false;
    }

    public CircularBufferNode add(char data) {
        CircularBufferNode node = new CircularBufferNode(data);
        if(isEmpty()){
            fillBufferWithOneNode(node);
            size++;
            configOverflow();
            return node;
        }
        if(isOverflow()){
            if(size == 1){
                fillBufferWithOneNode(node);
                return node;
            }
            CircularBufferNode nextHead = head.getNext();
            setHead(nextHead);
            node.setNext(nextHead);

            tail.setNext(node);
            setTail(node);
            return node;
        }

        tail.setNext(node);
        setTail(node);
        node.setNext(head);

        size++;
        configOverflow();
        return node;
    }
    private void configOverflow(){
        setOverflow(isBufferFull());
    }
    private boolean isBufferFull() {
        return this.size == this.capacity;
    }
    private void setOverflow(boolean overflow) {
        this.overflow = overflow;
    }
    private void fillBufferWithOneNode(CircularBufferNode node){
        setHead(node);
        setTail(node);
        node.setNext(node);
    }

    public CircularBufferNode delete() {
        if(isEmpty()) return null;
        CircularBufferNode node;
        if(this.size == 1){
            node = getHead();
            clear();
            return node;
        }
        node = getNode(size - 2);
        setTail(node);
        node.setNext(getHead());

        size--;
        configOverflow();
        return node;
    }

    public boolean contains(char data) {
        CircularBufferNode node = getHead();
        while(true){
            if(node.getData() == data) return true;
            node = node.getNext();
            if(node == getHead()) break;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public CircularBufferNode getHead() {
        return head;
    }

    private void setHead(CircularBufferNode head) {
        this.head = head;
    }

    public CircularBufferNode getTail() {
        return tail;
    }

    private void setTail(CircularBufferNode tail) {
        this.tail = tail;
    }

    public int getIndex(char data) {
        CircularBufferNode node = getHead();
        for(int i = 0 ; ; i++){
            if(node.getData() == data){
                return i;
            }
            node = node.getNext();
            if(node == getHead()) break;
        }
        return -1;
    }

    public CircularBufferNode getNode(int index) {
        if(isEmpty()) return null;
        if(index < 0 || index >= getSize()) return null;

        CircularBufferNode node = getHead();
        for(int i = 1 ; i <= index ;i++){
            node = node.getNext();
        }
        return node;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isOverflow() {
        return overflow;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
        overflow = false;
    }

    public String toString() {
        if(isEmpty()) return "";

        String str = "";
        CircularBufferNode node = getHead();
        while(true){
            str += node.toString();
            node = node.getNext();
            if(node == getHead()) break;
        }
        str = str.replaceAll(" ","");
        return str;
    }
}

class CircularBufferNode {
    private char data;
    private CircularBufferNode next;

    public CircularBufferNode(char data) {
        this.data = data;
        next = null;
    }

    public char getData() {
        return data;
    }
    public void setData(char data) {
        this.data = data;
    }
    public CircularBufferNode getNext() {
        return next;
    }
    public void setNext(CircularBufferNode node) {
        next = node;
    }
    public void clearNext() {
        next = null;
    }
    public String toString() {
        return String.valueOf(data);
    }
}
