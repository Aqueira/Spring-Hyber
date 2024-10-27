package org.example.repositories.impl;

import jakarta.persistence.PersistenceContext;
import org.example.repositories.OrderRepository;
import org.example.entities.Customer;
import org.example.entities.LineItem;
import org.example.entities.Order;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @PersistenceContext
    private Session session;

    @Override
    public Order create(Integer customerId, String deliver_to, List<LineItem> lineItems) {
        Order order = Order.builder()
                .deliverTo(deliver_to)
                .customer(session.getReference(Customer.class, customerId))
                .build();
        order.setLineItems(lineItems);
        session.persist(order);
        return order;
    }

    @Override
    public void delete(Integer id) {
        session.createQuery(
            "DELETE FROM Order order " +
                "WHERE order.id = :id", null)
            .setParameter("id", id)
            .executeUpdate();
    }

    @Override
    public Order findById(Integer id) {
        return session.createQuery(
            "SELECT order " +
                "FROM Order order " +
                "LEFT JOIN FETCH order.lineItems lineitems " +
                "WHERE order.id = :id", Order.class)
            .setParameter("id", id)
            .getSingleResult();
    }
}
