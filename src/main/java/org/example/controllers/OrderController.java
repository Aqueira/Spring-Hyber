package org.example.controllers;


import org.example.DTO.OrderDTO;
import org.example.entities.Customer;
import org.example.entities.LineItem;
import org.example.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> get(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        orderService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<OrderDTO> create(@RequestBody Customer customer,
                                                @RequestParam(value = "deliverTo") String deliverTo,
                                                @RequestBody List<LineItem> lineItems) {
        return ResponseEntity.ok(orderService.create(customer, deliverTo, lineItems));
    }

}

