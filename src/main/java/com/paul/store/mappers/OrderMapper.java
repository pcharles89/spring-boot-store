package com.paul.store.mappers;

import com.paul.store.dto.OrderDto;
import com.paul.store.entities.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order order);
}
