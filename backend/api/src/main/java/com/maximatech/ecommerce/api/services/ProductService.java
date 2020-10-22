package com.maximatech.ecommerce.api.services;

import com.maximatech.ecommerce.api.models.dto.Pageable;
import com.maximatech.ecommerce.api.models.entities.Client;
import com.maximatech.ecommerce.api.models.entities.Product;
import com.maximatech.ecommerce.api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

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

    public Page<Product> getAllPaginated(PageRequest request) {
        return repository.findAll(request);
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

    public boolean verifyIfExistsByCode(String codigo) {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .anyMatch(product -> codigo.trim().equals(product.getCode()));
    }
}
