package com.maximatech.ecommerce.api.repositories;

import com.maximatech.ecommerce.api.models.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Paging and Sorting Repository for Users.
 * @author Brenno Fagundes
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, UUID> {}
