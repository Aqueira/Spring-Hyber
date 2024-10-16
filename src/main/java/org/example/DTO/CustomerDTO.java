package org.example.DTO;


import java.util.List;

public record CustomerDTO(Integer id, String name, String sector, List<OrderDTO> ordersDTO) {
}
