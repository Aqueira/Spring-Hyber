package org.example.controllers;

import org.example.DTO.CustomerDTO;
import org.example.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main")
public class HTMLCustomerController {
    private final CustomerService customerService;

    @Autowired
    public HTMLCustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/customer/show/{id}")
    public String show(@PathVariable(value = "id") Integer id, Model model){
        CustomerDTO customer = customerService.get(id);
        model.addAttribute("customer", customer);
        model.addAttribute("orders", customer.ordersDTO());
        return "/customers/withOrders";
    }
}
