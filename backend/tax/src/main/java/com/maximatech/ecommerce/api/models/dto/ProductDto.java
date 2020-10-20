package com.maximatech.ecommerce.api.models.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Product Dto for returning data from Entity.
 * @author Brenno Fagundes
 */
@Data
public class ProductDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private String code;
    @NotNull
    private String name;
    @NotNull
    private Double unitPrice;
    private String imageUrl;
}
