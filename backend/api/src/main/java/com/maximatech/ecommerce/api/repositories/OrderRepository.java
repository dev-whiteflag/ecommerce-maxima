package com.maximatech.ecommerce.api.repositories;

import com.maximatech.ecommerce.api.models.entities.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Paging and Sorting Capable Repository for Orders.
 * @author Brenno Fagundes
 */
@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, UUID> {}
