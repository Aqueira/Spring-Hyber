import org.example.DTO.LineItemDTO;
import org.example.DTO.OrderDTO;
import org.example.controllers.OrderController;
import org.example.entities.Customer;
import org.example.entities.LineItem;
import org.example.services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class orderControllerTest {
    private OrderController orderController;

    @Mock
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        orderController = new OrderController(orderService);
    }

    @Test
    public void getOrderById() {
        Integer searchId = 1;
        Customer customer = new Customer(1, "name", "sector", null);
        List<LineItemDTO> lineItems = new ArrayList<>();
        OrderDTO mockDTO = new OrderDTO(searchId,  "test", customer.getId(), lineItems);
        when(orderService.get(searchId)).thenReturn(mockDTO);

        ResponseEntity<OrderDTO> result = orderController.get(searchId);
        assertNotNull(result);
        assertEquals(200, result.getStatusCodeValue());
        assertEquals(1, result.getBody().id());
        assertEquals("test", result.getBody().deliverTo());

        verify(orderService, times(1)).get(searchId);
    }
}
