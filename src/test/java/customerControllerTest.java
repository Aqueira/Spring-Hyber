import org.example.DTO.CustomerDTO;
import org.example.controllers.CustomerController;
import org.example.entities.Customer;
import org.example.entities.LineItem;
import org.example.entities.Order;
import org.example.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class customerControllerTest {
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    @BeforeEach void setUp(){
        MockitoAnnotations.openMocks(this);
        customerController = new CustomerController(customerService);
    }

    @Test
    public void testAddCustomer(){
        List<Order> orders = new ArrayList<>();
        List<LineItem> lineItems = new ArrayList<>();
        Order order = new Order(1, "deliver_to", null, lineItems);
        orders.add(order);
        Customer customer = new Customer(1, "name", "sector", orders);
        CustomerDTO mockCustomerDTO = new CustomerDTO(1, "name", "sector", null);
        when(customerService.create(any(Customer.class))).thenReturn(mockCustomerDTO);
        ResponseEntity<CustomerDTO> response = customerController.create(customer);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().id());
        assertEquals("name", response.getBody().name());
        verify(customerService).create(any(Customer.class));
    }

}
