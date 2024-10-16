package org.example.repositories;

import org.example.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    Customer create(String name, String sector);
    void delete(Integer id);
    void update(Integer id, String sector);
    Customer findById(Integer id);
    List<Customer> findAll();
}
