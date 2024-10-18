package org.example.services;

import org.example.DTO.OrderDTO;
import org.example.entities.Customer;
import org.example.entities.LineItem;

import java.util.List;

public interface OrderService {
    OrderDTO create(Customer customer, String deliver_to, List<LineItem> lineItems);
    void delete(Integer id);
    OrderDTO get(Integer id);
}
