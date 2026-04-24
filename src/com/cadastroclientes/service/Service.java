package com.cadastroclientes.service;

import com.cadastroclientes.datastructures.LinkedList;
import com.cadastroclientes.model.Customer;
import com.cadastroclientes.repository.Repository;
import com.cadastroclientes.util.Validator;

public class Service {
    private Repository repository;
    private int counter = 1;

    public Service(Repository repository){
        this.repository = repository;
    }

    public String generateId(){
        return String.valueOf(counter++);
    }

    public Customer create(String name, String email, String phone) {
        validateEmailForCreate(email.trim());
        String id = generateId();
        Customer customer = new Customer(id, name.trim(), email.trim(), phone.trim());

        repository.save(customer);

        return customer;

    }

    public LinkedList<Customer> listAll(){
        LinkedList<Customer> customers = repository.findAll();
        if (customers.isEmpty()){
            throw new IllegalArgumentException("Nenhum cliente foi cadastrado");
        } else {
            return customers;
        }
    }

    public void update(String id, String name, String email, String phone){
        Customer customer = repository.findById(id.trim());
        if (customer == null){
            throw new IllegalArgumentException("ID não encontrado");
        } else {
            validateEmailForUpdate(id.trim(), email.trim());
            repository.updateById(id.trim(), name.trim(), email.trim(), phone.trim());
        }
    }

    public void delete(String id){
        Customer customer = repository.findById(id.trim());
        if (customer == null){
            throw new IllegalArgumentException("ID não encontrado");
        } else {
            repository.deleteById(id.trim());
        }
    }

    public Customer findById(String id){
        Customer customer = repository.findById(id.trim());
        if (customer == null){
            throw new IllegalArgumentException("ID não encontrado");
        } else {
            return customer;
        }
    }

    public void validateEmailForCreate(String email){
        Validator.validateEmail(email.trim());

        if (repository.existsByEmail(email)) {
            throw new IllegalArgumentException("Já existe um cliente com esse E-mail.");
        }
    }

    public void validateEmailForUpdate(String id, String email){
        Validator.validateEmail(email.trim());

        for (Customer customer : repository.findAll()){
            if (customer.getEmail().equalsIgnoreCase(email) && !customer.getId().equalsIgnoreCase(id)){
                throw new IllegalArgumentException("Já existe um cliente com esse E-mail.");
            }
        }
    }


}
