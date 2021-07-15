package datastructure.linkedlist;

public class DoublyLinkedList {
    private int size;
    private DoublyLinkedListNode head;
    private DoublyLinkedListNode tail;

    public DoublyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public DoublyLinkedListNode add(char data, int index) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(data);
        if(isEmpty()){
            if(index == 0){
                this.head = node;
                this.tail = node;
            }else{
                return null;
            }
        }else{
            if(index == 0){
                this.head.setPrev(node);
                node.setNext(this.head);
                this.head = node;
            }else if(index > 0 && index < getSize()){  // 3개, index 1
                DoublyLinkedListNode targetNode = getNode(index);
                DoublyLinkedListNode targetPrevNode = targetNode.getPrev();

                node.setNext(targetNode);
                targetNode.setPrev(node);

                targetPrevNode.setNext(node);
                node.setPrev(targetPrevNode);
            }else if(index == getSize()){
                node.setPrev(this.tail);
                this.tail.setNext(node);
                this.tail = node;
            }else{
                return null;
            }
        }
        this.size++;
        return node;
    }

    public DoublyLinkedListNode delete(int index) {
        if(isEmpty()) return null;
        if(index < 0 || index >= getSize()) return null;

        DoublyLinkedListNode node = getNode(index);
        if(getSize() == 1){
            this.head = null;
            this.tail = null;
        }else{
            if(index == 0){
                DoublyLinkedListNode nextNode = getNode(index).getNext();
                nextNode.clearPrev();
                this.head = this.head.getNext();
            }else if(index == getSize() - 1){
                DoublyLinkedListNode prevNode = getNode(index).getPrev();
                prevNode.clearNext();
                this.tail = prevNode;
            }else{
                DoublyLinkedListNode prevNode = node.getPrev();
                DoublyLinkedListNode nextNode = node.getNext();
                prevNode.setNext(nextNode);
                nextNode.setPrev(prevNode);
            }
        }
        this.size--;
        return node;
    }

    public DoublyLinkedListNode deleteItem(char data) {
        DoublyLinkedListNode node = getHead();
        for(int i = 0 ; node != null ; i++){
            if(node.getData() == data){
                delete(i);
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    public boolean contains(char data) {
        DoublyLinkedListNode node = getHead();
        while(node != null){
            if(node.getData() == data) return true;
            node = node.getNext();
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public DoublyLinkedListNode getHead() {
        return head;
    }

    public DoublyLinkedListNode getTail() {
        return tail;
    }

    public int getIndex(char data) {
        DoublyLinkedListNode node = getHead();
        for(int i = 0 ; node != null ; i++){
            if(node.getData() == data){
                return i;
            }
            node = node.getNext();
        }
        return -1;
    }

    public DoublyLinkedListNode getNode(int index) {
        if(isEmpty()) return null;
        if(index < 0 || index >= getSize()) return null;

        DoublyLinkedListNode node = getHead();
        for(int i = 1 ; i <= index ;i++){
            node = node.getNext();
        }
        return node;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public String toString() {
        String str = "";
        DoublyLinkedListNode node = getHead();
        while(node != null){
            str += node.toString();
            node = node.getNext();
        }
        str = str.replaceAll(" ","");
        return str;
    }

    public String toStringReverse() {
        String str = "";
        DoublyLinkedListNode node = getTail();
        while(node != null){
            str += node.toString();
            node = node.getPrev();
        }
        str = str.replaceAll(" ","");
        return str;
    }
}

class DoublyLinkedListNode {
    private char data;
    private DoublyLinkedListNode prev;
    private DoublyLinkedListNode next;

    public DoublyLinkedListNode(char data) {
        this.data = data;
        next = null;
        prev = null;
    }
    public char getData() {
        return data;
    }
    public void setData(char data) {
        this.data = data;
    }

    public DoublyLinkedListNode getPrev() {
        return prev;
    }
    public void setPrev(DoublyLinkedListNode node) {
        prev = node;
    }
    public DoublyLinkedListNode getNext() {
        return next;
    }
    public void setNext(DoublyLinkedListNode node) {
        next = node;
    }
    public void clearPrev() {
        prev = null;
    }
    public void clearNext() {
        next = null;
    }
    public String toString() {
        return String.valueOf(data);
    }
}