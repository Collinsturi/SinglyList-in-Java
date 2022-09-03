package com.Example.LinkedList;

public class SinglyList<T> {
    private int size;
    private Node<T> head = null;
    private static class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public void clear(){
        Node<T> trav =  head;

        while(trav != null){
            Node<T> next = trav.next;
            trav.data = null;
            trav.next = null;
            trav = next;
        }
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public void addLast(T element){
        if(head == null){
            head = new Node<>(element,null);
        }else{
            Node<T> trav = head;
            Node<T> temp = new Node<>(element, null);
            int j = 0;

            while (trav.next !=null){
                trav = trav.next;
            }
            trav.next = temp;
        }
        size++;
    }
    public void addFirst(T element){
        Node<T> temp = new Node<>(element, null);
        if(isEmpty()){
            head = temp;
            size++;
            return;
        }

        temp.next = head;
        head = temp;
        size++;
    }
    public T peekFirst(){
        if(isEmpty()) throw new RuntimeException("Empty list");
        return head.data;
    }

    public T peekLast(){
        if(isEmpty()) throw new RuntimeException("Empty list");
        Node<T> temp = head;

        while(temp.next!=null){
            temp= temp.next;
        }
        return temp.data;
    }
    public void removeFirst(){
        if(isEmpty()) throw new RuntimeException("Empty List");
        head = head.next;
        size--;
    }
    public void removeLast(){
        if(isEmpty()) throw  new RuntimeException("Empty list");

        Node<T> temp = head;
        int i = 0;

        while(temp!= null){
            if (i == size - 2 ){
                temp.next = null;
            }
            temp = temp.next;
            i++;
        }

        size--;
    }
    public void removeAt(int index){
        Node<T> temp = head;
        int j = 0;
        if(isEmpty()) throw new RuntimeException("Empty list");

        if(index == 0){
            head = head.next;
        }
        while(temp != null){
            if(j == index-1){
                temp.next = (temp.next).next;
            }
            temp = temp.next;
            j++;
        }
        size--;
    }
    public void remove(T data){
        Node<T> temp = head;
        if(isEmpty()) throw new RuntimeException("Empty list");

        while (temp!=null){
            if(temp. data == data){
                temp.data = null;
                return;
            }
            temp = temp.next;
        }
        size--;
    }
    public int indexOf(T data){
        Node<T> temp = head;
        int j = 0;
        if(isEmpty()) throw new RuntimeException("Empty list");

        while(temp!=null){
            if(temp.data == data) return j;
            temp = temp.next;
            j++;
        }
        return 0;
    }
    public boolean contains(T data){
        Node<T> temp = head;
        int j = 0;
        if(isEmpty()) throw new RuntimeException("Empty list");

        while(temp!=null){
            if(temp.data == data) return true;
            temp = temp.next;
            j++;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node<T> trav = head;
        while(trav != null){
            sb.append(trav.data).append(", ");
            trav = trav.next;
        }
        sb.append("]");

        return sb.toString();
    }
}
