package com.maximatech.ecommerce.api.repositories;

import com.maximatech.ecommerce.api.models.entities.Client;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Paging and Sorting Repository for Clients.
 * @author Brenno Fagundes
 */
@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client, UUID> {}
