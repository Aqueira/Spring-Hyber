package org.example.services.impl;

import org.example.DTO.OrderDTO;
import org.example.entities.Customer;
import org.example.entities.LineItem;

import org.example.mappers.OrderMapper;
import org.example.repositories.OrderRepository;
import org.example.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderDTO create(Customer customer, String deliver_to, List<LineItem> lineItems) {
        return orderMapper.toDTO(orderRepository.create(customer,  deliver_to, lineItems));
    }

    @Override
    public void delete(Integer id) {
        orderRepository.delete(id);
    }

    @Override
    public OrderDTO get(Integer id) {
        return orderMapper.toDTO(orderRepository.findById(id));
    }
}
