package com.maximatech.ecommerce.api.models.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A Dto for returning data from Maxima API entity.
 * @author Brenno Fagundes
 */
@Data
public class ProductMaxima implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private String id;
    @NotNull
    private String codigo;
    @NotNull
    private String nome;
    @NotNull
    private String precoUnitario;
    private String imagemUrl;
}
