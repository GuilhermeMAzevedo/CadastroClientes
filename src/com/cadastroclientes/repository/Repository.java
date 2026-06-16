package com.cadastroclientes.repository;

import com.cadastroclientes.datastructures.LinkedList;
import com.cadastroclientes.model.Customer;



public class Repository {
    private LinkedList<Customer> linkedList = new LinkedList<>();

    public void save(Customer customer){
        linkedList.addLast(customer);
    }

    public LinkedList<Customer> findAll(){
        return linkedList;
    }

    public Customer findById(String id){
        for (Customer customer : linkedList) {
            if (customer.getId().equals(id)){
                return customer;
            }
        }
        return null;
    }

    public void deleteById(String id){
        int index = 0;
        for (Customer customer : linkedList) {
            if (customer.getId().equals(id)){
                linkedList.remove(index);
                return;
            }
            index++;
        }
        throw new IllegalArgumentException("Cliente não encontrado");
    }

    public void updateById(String id, String name, String email, String phone){
        Customer customer = findById(id);

        if (customer == null){
            throw new IllegalArgumentException("Cliente não encontrado");
        }

        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);

    }

    public boolean existsByEmail(String email){
        for (Customer customer : linkedList){
            if (customer.getEmail().equalsIgnoreCase(email)){
                return true;
            }
        }
        return false;
    }
}
