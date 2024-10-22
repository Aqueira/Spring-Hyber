package org.example.repositories;

import org.example.entities.Customer;
import org.example.entities.LineItem;
import org.example.entities.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order create(Integer customerId, String deliver_to, List<LineItem> lineItems);
    void delete(Integer id);
    Order findById(Integer id);
}
