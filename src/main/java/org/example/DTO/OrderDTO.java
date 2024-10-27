package org.example.DTO;



import java.util.List;

public record OrderDTO(Integer id, String deliverTo, Integer customerId, List<LineItemDTO> lineItemsDTO) {
}
