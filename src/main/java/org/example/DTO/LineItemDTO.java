package org.example.DTO;

public record LineItemDTO(Long id, String productName, Integer quantity, Double price, Integer orderId) {
}
