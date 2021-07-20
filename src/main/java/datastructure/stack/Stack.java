package datastructure.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private static final int PEAK_INDEX = 0;
    private int capacity;
    private List<Integer> list;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.list = new ArrayList();
    }

    public int push(int data) {
        if(isFull()) return -1;
        list.add(PEAK_INDEX,data);
        return data;
    }

    public int peek() {
        if(isEmpty()) return -1;
        int result = list.get(PEAK_INDEX);
        return result;
    }

    public int pop() {
        if(isEmpty()) return -1;
        int result = list.get(PEAK_INDEX);
        list.remove(PEAK_INDEX);
        return result;
    }

    public void clear() {
        list.clear();
    }

    public int getSize() {
        return list.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isFull() {
        return list.size() == capacity;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public String toString() {
        if(isEmpty()) return "";
        int size = list.size();
        String result = "";
        for (int i = 0; i < size - 1; i++) {
            result += list.get(i).toString() + ",";
        }
        result += list.get(size - 1);
        return result;
    }
}