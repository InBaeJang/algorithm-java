package acmicpc.queue;

import java.io.*;
import java.util.StringTokenizer;

public class Q10845 {
    public static String solve(BufferedReader br) throws IOException {
        StringBuilder sb = new StringBuilder();
        Queue queue = new Queue();

        int N = Integer.parseInt(br.readLine());

        while (N-- != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    int data = Integer.parseInt(st.nextToken());
                    queue.push(data); break;
                case "pop":
                    sb.append(queue.pop()).append("\n"); break;
                case "size":
                    sb.append(queue.size()).append("\n"); break;
                case "empty":
                    sb.append(queue.isEmpty()).append("\n"); break;
                case "front":
                    sb.append(queue.front()).append("\n"); break;
                case "back":
                    sb.append(queue.back()).append("\n"); break;
            }
        }
        br.close();
        return sb.toString().trim();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = Q10845.solve(br);
        System.out.println(answer);
    }
}

class Queue {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private int size = 0;
    private Node first;
    private Node last;

    public void push(int data) {
        Node newNode = new Node(data);

        if(size == 0) {
            first = newNode;
            last = first;
        }else{
            last.next = newNode;
            last = last.next;
        }
        size++;
    }

    public int pop() {
        if (isEmpty() == 1) {
            return -1;
        }

        int data = first.data;
        first = first.next;
        size--;

        return data;
    }

    public int isEmpty() {
        return size == 0 ? 1 : 0;
    }

    public int front() {
        if (isEmpty() == 1) return -1;
        return first.data;
    }

    public int back() {
        if (isEmpty() == 1) return -1;
        return last.data;
    }

    public int size(){
        return this.size;
    }
}