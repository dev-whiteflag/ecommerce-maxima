package com.maximatech.ecommerce.api.mappers;

import com.maximatech.ecommerce.api.models.dto.ClientDto;
import com.maximatech.ecommerce.api.models.dto.ClientMaxima;
import com.maximatech.ecommerce.api.models.dto.OrderDto;
import com.maximatech.ecommerce.api.models.entities.Client;
import com.maximatech.ecommerce.api.models.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.UUID;

/**
 * A Mapper for converting Dto to Entity and vice-versa.
 * @author Brenno Fagundes
 */
@Mapper
public interface OrderMapper {
    Order toEntity(OrderDto data);
    OrderDto toDto(Order data);
}
