package com.blountmarquis.datastructures;

/**
 * Created by MLBlount on 10/12/2014.
 */
public class LinkedList<T extends Comparable<T>> {

    private Node head;
    private Node tail;
    public LinkedList(){
        return;
    }

    public static class Node<T extends Comparable<T>> implements Comparable<T>{
        public Node(T val){
            this.value = val;
        }
        private Node next;
        private T value;

        public Node getNext() {
            return next;
        }

        public T getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        @Override
        public int compareTo(T o) {
            return value.compareTo(o);
        }


        public int compareTo(Node<T> node) {
            return value.compareTo(node.value);
        }
    }

    public <T extends Comparable<T>> void insert(T value){
        Node temp = new Node(value);
        temp.next = this.head;
        if(this.head == null)
            this.tail = temp;
        this.head = temp;

    }

    public <T extends Comparable<T>> void partition(T val){
        if(this.head == null)return;
        Node<T> ws = this.head;
        while (ws != null){
            if(ws.compareTo(val) < 0){
                Node temp = delete(ws);
                ws = temp.next;
                temp.next = this.head;
                head = temp;
            }else{
                ws = ws.next;
            }
        }
    }

    public Node<T> delete(T value){
        if(this.head == null) return null;

        Node node = search(value);
        if(node == null) return null;

        return delete(node);
    }

    public Node search(T value){
        if(this.head == null)return null;

        Node ws = this.head;
        while (ws != null){
            if(ws.value == value)
                return ws;
            else ws = ws.next;
        }
        return null;
    }

    public Node search(Node<T> node){
        if (this.head == null) return null;
        Node<T> ws = this.head;
        while (ws != null){
            if(ws == node)
                return ws;
            else
                ws = ws.next;
        }
        return null;
    }

    public Node<T> delete(Node node) {
        if(node == this.head){
            this.head = this.head.next;
            node = null;
            return node;
        }
        Node ws = this.head;
        while (ws != null && ws.next != node){
            ws = ws.next;
        }
        ws.next = node.next;
        //node = null;
        if(ws.next == null)
            this.tail = ws;
        return node;
    }

    public LinkedList<T> set(LinkedList s2){
        this.tail.next = s2.head;
        return this;
    }

    public void reverse(){
        if (this.head == null) return;

        Node current = this.head;
        Node next = null;
        Node prev = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        this.head = prev;

    }

    @Override
    public String toString(){
        if (this.head == null) return "";

        StringBuilder sb = new StringBuilder();
        Node ws = this.head;

        while (ws != null){
            if(ws.next == null)
                sb.append(ws.value);
            else
                sb.append(ws.value + ", ");
            ws = ws.next;
        }
        return  sb.toString();
    }

    public Node<T> rotateRight(int k){
        return rotateRight(head, k);
    }

    private Node<T> rotateRight(Node n, int k){
        if(head == null) return head;

        Node start = head;
        Node kthNode = head;
        int size = getSizeAndCirculateList(kthNode);
        int rotations = k % size;

        if(rotations == 0) return head;

        for(int i = 0; i < rotations; i++){
            kthNode = kthNode.next;
        }

        Node ws = kthNode;
        while(ws.next != null) ws = ws.next;

        ws.next = start;

        Node newHead = kthNode.next;
        kthNode.next = null;


        return newHead;

    }

    private int getSizeAndCirculateList(Node n){
        int i = 1;
        while(n.next != null){
            i++;
            n = n.next;
        }
        return i;
    }


    public Node getHead(){
        return this.head;
    }

    public Node getTail(){
        return this.tail;
    }


}

class testPrivateClass{

}
