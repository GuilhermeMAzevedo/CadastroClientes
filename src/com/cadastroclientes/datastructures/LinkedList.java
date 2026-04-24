package com.cadastroclientes.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<Customer> implements Iterable<Customer> {
    private Node<Customer> head;
    private Node<Customer> tail;
    private int size;

    private class Node <Customer>{
        Customer data;
        Node<Customer> next;
        Node(Customer data){
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    public void addLast(Customer customer){
        if (isEmpty()){
            addFirst(customer);
        } else {
            tail.next = new Node<>(customer);
            tail = tail.next;
            size++;
        }
    }

    public void addFirst(Customer customer){
        Node<Customer> newNode = new Node<>(customer);
        if (isEmpty()){
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void add(Customer data, int index){
        if (index == 0){
            addFirst(data);
        } else if (index == size){
            addLast(data);
        } else if (index < 0 || index > size) {
            throw new IllegalArgumentException("posição inválida");
        } else {
            Node<Customer> current = head;
            for (int i = 0; i < index - 1; i++){
                current = current.next;
            }
            Node<Customer> node = new Node<Customer>(data);
            node.next = current.next;
            current.next = node;
            size++;
        }
    }

    public Customer remove(int index){
        if (isEmpty()) {
            throw new IllegalStateException("Lista vazia");
        } else if (index > (size - 1) || index < 0) {
            throw new IllegalArgumentException("Posição inválida");
        } else if (index == 0) {
            return removeFirst();
        } else if (index == (size - 1)) {
            return removeLast();
        } else {
            Node<Customer> current = head;
            for (int i = 0; i < (index - 1); i++) {
                current = current.next;
            }
            Customer removed = current.next.data;
            current.next = current.next.next;
            size--;
            return removed;
        }
    }

    public Customer removeLast(){
        if (isEmpty()){
            throw new IllegalStateException("Lista vazia");
        } else {
            if (head == tail){
                return removeFirst();
            } else {
                Node<Customer> current = head;
                Customer removed = tail.data;
                while (current.next != tail){
                    current = current.next;
                }
                current.next = null;
                tail = current;
                size--;
                return removed;
            }
        }
    }


    public Customer removeFirst(){
        if (isEmpty()){
            throw new IllegalStateException("Lista vazia");
        } else {
            Customer removed = head.data;
            if (head == tail){
                head = tail = null;
            } else {
                head = head.next;
            }
            size--;
            return removed;
        }
    }

    public int search(Customer customer){
        if (isEmpty()){
            throw new IllegalStateException("Lista vazia");
        } else {
            Node<Customer> current = head;
            int index = 0;
            while (current != null) {
                if (current.data.equals(customer)){
                    return index;
                }
                current = current.next;
                index++;
            }
            return -1;
        }
    }

    public Customer get(int index){
        if (isEmpty()){
            throw new IllegalStateException("Lista vazia");
        } else if (index < 0 || index > (size - 1)) {
            throw new IllegalArgumentException("Posição inválida");
        } else {
            Node<Customer> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }
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
            StringBuilder stringBuilder = new StringBuilder("Lista de Clientes: \n");
            Node<Customer> current = head;
            while (current != null) {
                stringBuilder.append(current.data).append("\n");
                current = current.next;
            }
            return stringBuilder.toString();
        }
    }

    @Override
    public Iterator<Customer> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Customer>{
        private Node<Customer> current = head;

        @Override
        public boolean hasNext(){
            return current != null;
        }

        @Override
        public Customer next(){
            if (hasNext()){
                Customer data = current.data;
                current = current.next;
                return data;
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}