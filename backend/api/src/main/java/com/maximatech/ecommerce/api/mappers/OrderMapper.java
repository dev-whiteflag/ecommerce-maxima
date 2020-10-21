package com.maximatech.ecommerce.api.mappers;

import com.maximatech.ecommerce.api.models.dto.ClientDto;
import com.maximatech.ecommerce.api.models.dto.ClientMaxima;
import com.maximatech.ecommerce.api.models.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.UUID;

/**
 * A Mapper for converting Dto, MaximaDto to Entity and vice-versa.
 * @author Brenno Fagundes
 */
@Mapper
public interface ClientMapper {
    @Mappings({
            @Mapping(source = "id", target = "uuid", qualifiedByName = "fromStringToUUID"),
            @Mapping(source = "codigo", target = "code"),
            @Mapping(source = "nome", target = "name")
    })
    Client toEntity(ClientMaxima data);
    Client toEntity(ClientDto data);
    ClientDto toDto(Client data);

    @Named("fromStringToUUID")
    static UUID fromStringToUUID(String value){
        return UUID.fromString(value);
    }
}
