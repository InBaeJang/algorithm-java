package datastructure.linkedlist;

public class SinglyLinkedList {
    private int size;
    private SinglyLinkedListNode head;

    public SinglyLinkedList() {
        size = 0;
        head = null;
    }

    public SinglyLinkedListNode add(char data, int index) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        if(isEmpty()){
            if(index == 0){
                head = node;
            }else{
                return null;
            }
        }else{
            if(index == 0){
                SinglyLinkedListNode indexedNode = getNode(index);
                node.setNext(indexedNode);
                head = node;
            }else if(index > 0 && index < getSize()){
                SinglyLinkedListNode indexedNode = getNode(index);
                node.setNext(indexedNode);
                SinglyLinkedListNode lastNode = getNode(index - 1);
                lastNode.setNext(node);
            }else if(index == getSize()){
                SinglyLinkedListNode lastNode = getNode(index - 1);
                lastNode.setNext(node);
            }else{
                return null;
            }
        }
        size++;
        return node;
    }

    public SinglyLinkedListNode delete(int index) {
        if(isEmpty()) return null;
        if(index < 0 || index >= getSize()) return null;

        SinglyLinkedListNode node = getNode(index);
        if(getSize() == 1)
            head = null;
        else if(index == 0)
            head = getNode(index+1);
        else;
        getNode(index-1).setNext(getNode(index).getNext());
        size--;
        return node;
    }

    public SinglyLinkedListNode deleteItem(char data) {
        SinglyLinkedListNode node = getHead();
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
        SinglyLinkedListNode node = getHead();
        while(node != null){
            if(node.getData() == data) return true;
            node = node.getNext();
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public SinglyLinkedListNode getHead() {
        return head;
    }

    public int getIndex(char data) {
        SinglyLinkedListNode node = getHead();
        for(int i = 0 ; node != null ; i++){
            if(node.getData() == data){
                return i;
            }
            node = node.getNext();
        }
        return -1;
    }

    public SinglyLinkedListNode getNode(int index) {
        if(isEmpty()) return null;
        if(index < 0 || index >= getSize()) return null;

        if(index == 0) return head;

        SinglyLinkedListNode node = getHead();
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public String toString() {
        String str = "";
        SinglyLinkedListNode node = getHead();
        while(node != null){
            str += node.toString();
            node = node.getNext();
        }
        str = str.replaceAll(" ","");
        return str;
    }
}

class SinglyLinkedListNode {
    private char data;
    private SinglyLinkedListNode next;

    public SinglyLinkedListNode(char data) {
        this.data = data;
        next = null;
    }
    public char getData() {
        return data;
    }
    public void setData(char data) {
        this.data = data;
    }

    public SinglyLinkedListNode getNext() {
        return next;
    }
    public void setNext(SinglyLinkedListNode node) {
        next = node;
    }
    public void clearNext() {
        next = null;
    }

    public String toString() {
        return String.valueOf(data);
    }
}