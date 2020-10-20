package com.maximatech.ecommerce.api.models.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Product Dto for returning data from Entity.
 * @author Brenno Fagundes
 */
@Data
public class ProductDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer quantity;

    public ProductDto() {}

    public ProductDto(@NotNull Integer quantity) {
        this.quantity = quantity;
    }
}
