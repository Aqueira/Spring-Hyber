package org.example.mappers;

import org.example.DTO.CustomerDTO;
import org.example.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = OrderMapper.class)
public interface CustomerMapper {
    @Mapping(source = "orders", target = "ordersDTO")
    CustomerDTO toDTO(Customer customer);

    List<CustomerDTO> toDTOs(List<Customer> customers);
}
