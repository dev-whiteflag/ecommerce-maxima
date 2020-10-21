package com.maximatech.ecommerce.api.services;

import com.maximatech.ecommerce.api.models.dto.Pageable;
import com.maximatech.ecommerce.api.models.entities.Product;
import com.maximatech.ecommerce.api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Product Service for Product, this service is responsible for business logic
 * before returning the object to controller.
 * @author Brenno Fagundes
 */
@Component
public class ProductService {
    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Optional<Product> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public List<Product> getAllPaginated(Pageable pageable) {
        org.springframework.data.domain.Pageable converted
                = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        return repository.findAll(converted).toList();
    }

    public void update(Product data) {
        repository.save(data);
    }

    public UUID save(Product data) {
        Product product = repository.save(data);
        return product.getUuid();
    }

    public void delete(Product data) {
        repository.delete(data);
    }
}
