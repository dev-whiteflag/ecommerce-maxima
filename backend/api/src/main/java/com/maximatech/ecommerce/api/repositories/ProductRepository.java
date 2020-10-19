package com.maximatech.ecommerce.api.repositories;

import com.maximatech.ecommerce.api.models.entities.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Paging and Sorting Capable Repository for Clients.
 * @author Brenno Fagundes
 */
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, UUID> {}
