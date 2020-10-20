package com.maximatech.ecommerce.api.resources;

import com.google.common.base.Preconditions;
import com.maximatech.ecommerce.api.models.dto.ProductDto;
import com.maximatech.ecommerce.api.services.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest Controller (resource) for calculating Taxes.
 * @author Brenno Fagundes
 */
@RestController
@RequestMapping(value = "/v1/tax", produces = { MediaType.APPLICATION_JSON_VALUE })
public class TaxResource {

    private final TaxService service;

    @Autowired
    public TaxResource(TaxService service) {
        this.service = service;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public double getTaxForProducts(@RequestBody List<ProductDto> body) {
        Preconditions.checkNotNull(body);
        return service.calculate(body);
    }
}
