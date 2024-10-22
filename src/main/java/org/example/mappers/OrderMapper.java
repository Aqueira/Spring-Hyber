package org.example.mappers;

import org.example.DTO.OrderDTO;
import org.example.entities.Customer;
import org.example.entities.Order;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = LineItemMapper.class)
public interface OrderMapper {

    @Mapping(source = "customer", target = "customerId", qualifiedByName = "toId")
    @Mapping(source = "lineItems", target = "lineItemsDTO")
    OrderDTO toDTO(Order order);

    @Named("toId")
    static Integer toId(Customer customer){
        return customer.getId();
    }
}
