package com.maximatech.ecommerce.api.services;

import com.maximatech.ecommerce.api.models.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Tax Service for Freight Tax, this service is responsible for business logic
 * before returning the object to controller.
 * @author Brenno Fagundes
 */
@Component
public class TaxService {

    @Autowired
    public TaxService() {
    }

    public double calculate(List<ProductDto> products) {
        double taxValue;
        int quantity = products.parallelStream().mapToInt(ProductDto::getQuantity).sum();
        taxValue = quantity * getRandomDoubleBetweenRange(5, 10);
        return taxValue;
    }

    private static double getRandomDoubleBetweenRange(double min, double max) {
        return (Math.random() * ((max-min)+1)) + min;
    }
}
