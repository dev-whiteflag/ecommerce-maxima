package com.maximatech.ecommerce.api.models.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

/**
 * Client Dto for returning data from Entity.
 * @author Brenno Fagundes
 */
@Data
public class ClientDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID uuid;
    @NotNull
    private String name;
    private String code;
}
