package org.example.mappers;

import org.example.DTO.LineItemDTO;
import org.example.entities.LineItem;
import org.example.entities.Order;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LineItemMapper {
    @Mapping(source = "order", target = "orderId", qualifiedByName = "toId")
    LineItemDTO toDTO(LineItem lineItem);

    @Named("toId")
    static Integer toId(Order order){
        return order.getId();
    }
}
