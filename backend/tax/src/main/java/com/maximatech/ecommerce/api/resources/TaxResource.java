package com.maximatech.ecommerce.api.resources;

import com.google.common.base.Preconditions;
import com.maximatech.ecommerce.api.mappers.ClientMapper;
import com.maximatech.ecommerce.api.mappers.ProductMapper;
import com.maximatech.ecommerce.api.models.dto.ClientDto;
import com.maximatech.ecommerce.api.models.dto.ProductDto;
import com.maximatech.ecommerce.api.models.entities.Client;
import com.maximatech.ecommerce.api.models.entities.Product;
import com.maximatech.ecommerce.api.services.ClientService;
import com.maximatech.ecommerce.api.services.MaximaService;
import com.maximatech.ecommerce.api.services.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<ProductDto> getAllProducts(@RequestBody Pageable body) {
        Preconditions.checkNotNull(body);
        List<ProductDto> productDtos = new ArrayList<>();
        return productDtos;
    }
}
