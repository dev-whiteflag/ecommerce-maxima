package com.maximatech.ecommerce.api.mappers;

import com.maximatech.ecommerce.api.models.dto.ClientDto;
import com.maximatech.ecommerce.api.models.dto.ClientMaxima;
import com.maximatech.ecommerce.api.models.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * A Mapper for converting Dto, MaximaDto to Entity and vice-versa.
 * @author Brenno Fagundes
 */
@Mapper
public interface ClientMapper {

    @Mappings({
            @Mapping(source = "id", target = "uuid"),
            @Mapping(source = "codigo", target = "code"),
            @Mapping(source = "nome", target = "name")
    })
    Client toEntity(ClientMaxima data);

    Client toEntity(ClientDto data);
    ClientDto toDto(Client data);

}
