package org.example.services;

import org.example.DTO.CustomerDTO;
import org.example.entities.Customer;

import java.util.List;

public interface CustomerService {
    CustomerDTO create(Customer customer);
    void delete(Integer Id);
    CustomerDTO get(Integer Id);
    List<CustomerDTO> getAll();
    void update(Integer id, String sector);
}
