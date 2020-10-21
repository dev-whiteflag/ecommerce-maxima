package com.maximatech.ecommerce.api.models.dto;

import lombok.Data;

/**
 * Object for requesting a Pageable response from Repository.
 * @author Brenno Fagundes
 */
@Data
public class Pageable {
    private int pageNumber;
    private int pageSize;
}
