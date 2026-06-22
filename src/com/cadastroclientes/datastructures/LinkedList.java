package com.cadastroclientes.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
    private class Node{
        private T data;
        private Node next;
        private Node prev;
        public Node(T data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(T data){
        if (isEmpty()){
            head = new Node(data);
            tail = head;
        } else {
            Node node = new Node(data);
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void add(T data, int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Posição inválida");
        } else if (index == 0){
            addFirst(data);
        } else if (index == size){
            addLast(data);
        } else if (index < size / 2){
            Node node = new Node(data);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            node.next = current.next;
            current.next.prev = node;
            current.next = node;
            node.prev = current;
            size++;
        } else {
            Node node = new Node(data);
            Node current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
            node.next = current;
            node.prev = current.prev;
            current.prev.next = node;
            current.prev = node;
            size++;
        }
    }

    public void addLast(T data){
        if (isEmpty()){
            addFirst(data);
        } else {
            Node node = new Node(data);
            tail.next = node;
            node.prev = tail;
            tail = node;
            size++;
        }
    }

    public T removeFirst(){
        if (isEmpty()){
            throw new IllegalStateException("Lista vazia");
        } else {
            T dataRemoved = head.data;
            head = head.next;
            if (head == null){
                tail = null;
            } else {
                head.prev = null;
            }
            size--;
            return dataRemoved;
        }
    }

    public T remove(int index){
        if (isEmpty()){
            throw new IllegalStateException("Lista vazia");
        } else if (index < 0 || index >= size){
            throw new IllegalArgumentException("Posição inválida");
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else if (index < size / 2){
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            T dataRemoved = current.next.data;
            current.next = current.next.next;
            current.next.prev = current;
            size--;
            return dataRemoved;
        } else {
            Node current = tail;
            for (int i = size - 1; i > index + 1; i--) {
                current = current.prev;
            }
            T dataRemoved = current.prev.data;
            current.prev = current.prev.prev;
            current.prev.next = current;
            size--;
            return dataRemoved;
        }
    }

    public T removeLast(){
        if (isEmpty()){
            throw new IllegalStateException("Lista vazia");
        } else if (size == 1){
            return removeFirst();
        } else {
            T dataRemoved = tail.data;
            tail = tail.prev;
            tail.next = null;
            size--;
            return dataRemoved;
        }
    }

    public T get(int index){
        if (isEmpty()){
            throw new IllegalStateException("Lista vazia");
        } else if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Posição inválida");
        } else if (index < size / 2){
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        } else {
            Node current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
            return current.data;
        }
    }

    public int search(T data){
        Node current = head;
        int index = 0;
        while (current != null){
            if (current.data.equals(data)){
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public boolean contains(T data){
        Node current = head;
        while (current != null){
            if (current.data.equals(data)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public String toString(){
        if (isEmpty()){
            return "Lista vazia";
        } else {
            StringBuilder stringBuilder = new StringBuilder("Lista de Clientes:");
            Node current = head;
            while (current != null){
                stringBuilder.append("\n").append(current.data);
                current = current.next;
            }
            return stringBuilder.toString();
        }
    }

    @Override
    public Iterator<T> iterator(){
        return new Iterator<T>(){
            private Node current = head;

            @Override
            public boolean hasNext(){
                return current != null;
            }

            @Override
            public T next(){
                if (hasNext()){
                    T data = current.data;
                    current = current.next;
                    return data;
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}