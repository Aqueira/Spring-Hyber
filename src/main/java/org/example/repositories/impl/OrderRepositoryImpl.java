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
    public Order create(Customer customer, String deliver_to, List<LineItem> lineItems) {
        session.persist(
            Order.builder()
                .customer(customer)
                .deliverTo(deliver_to)
                .build()
        );

        return session.createQuery(
            "SELECT order " +
                "FROM Order order " +
                "ORDER BY id " +
                "DESC LIMIT 1", Order.class).getSingleResult();
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
