package org.example.mappers;

import org.example.DTO.CustomerDTO;
import org.example.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = OrderMapper.class)
public interface CustomerMapper {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "sector", target = "sector"),
        @Mapping(source = "orders", target = "ordersDTO")
    })
    CustomerDTO toDTO(Customer customer);
}
