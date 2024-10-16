package org.example.repositories.impl;

import jakarta.persistence.PersistenceContext;
import org.example.repositories.CustomerRepository;
import org.example.entities.Customer;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    private Session session;


    @Override
    public Customer create(String name, String sector) {
        session.persist(Customer.builder().name(name).sector(sector).build());
        Customer customer = session.createQuery(
            "SELECT customer " +
                "FROM Customer customer " +
                "ORDER BY id " +
                "DESC LIMIT 1", Customer.class)
            .getSingleResult();
        return customer;
    }

    @Override
    public void delete(Integer id) {
        session.createQuery(
            "DELETE FROM Customer customer " +
                "WHERE customer.id = :customerId", null
            )
            .setParameter("customerId", id)
            .executeUpdate();
    }

    @Override
    public void update(Integer id, String sector) {
        session.createQuery(
            "UPDATE Customer customer " +
                "SET customer.sector = :sector " +
                "WHERE customer.id = :customerId", null
            )
            .setParameter("customerId", id)
            .setParameter("sector", sector)
            .executeUpdate();
    }

    @Override
    public Customer findById(Integer id) {
        return session.createQuery(
            "SELECT DISTINCT customer  " +
                "FROM Customer customer " +
                "LEFT JOIN FETCH customer.orders order " +
                "WHERE customer.id = :customerId ", Customer.class)
            .setParameter("customerId", id)
            .getSingleResult();
    }

    @Override
    public List<Customer> findAll() {
        return session.createQuery(
            "FROM Customer customer " +
                "LEFT JOIN FETCH customer.orders orders", Customer.class)
            .getResultList();
    }
}

