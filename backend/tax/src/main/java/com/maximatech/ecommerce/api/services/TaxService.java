package com.maximatech.ecommerce.api.services;

import com.maximatech.ecommerce.api.models.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 * Product Service for Product, this service is responsible for business logic
 * before returning the object to controller.
 * @author Brenno Fagundes
 */
@Component
public class TaxService {

    @Autowired
    public TaxService() {
    }

    public double calculate(List<ProductDto> products) {

    }
}
