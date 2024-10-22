package org.example.services.impl;

import jakarta.transaction.Transactional;
import org.example.DTO.CustomerDTO;
import org.example.entities.Customer;
import org.example.mappers.CustomerMapper;
import org.example.repositories.CustomerRepository;
import org.example.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Transactional
    @Override
    public CustomerDTO create(Customer customer) {
        return customerMapper.toDTO(customerRepository.create(customer.getName(), customer.getSector()));
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        customerRepository.delete(id);
    }

    @Transactional
    @Override
    public CustomerDTO get(Integer id) {
        return customerMapper.toDTO(customerRepository.findById(id));
    }

    @Transactional
    @Override
    public List<CustomerDTO> getAll() {
        return customerMapper.toDTOs(customerRepository.findAll());
    }

    @Transactional
    @Override
    public void update(Integer id, String sector) {
        customerRepository.update(id, sector);
    }
}
