package com.maximatech.ecommerce.api.models.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

/**
 * Order Dto for returning data from Entity.
 * @author Brenno Fagundes
 */
@Data
public class OrderDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID uuid;
    @NotNull
    private String code;
    @NotNull
    private double totalValue;
    @NotNull
    private int productQuantity;
    @NotNull
    private double taxValue;
}
