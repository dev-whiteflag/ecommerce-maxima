package com.maximatech.ecommerce.api.services;

import com.maximatech.ecommerce.api.models.entities.Client;
import com.maximatech.ecommerce.api.models.entities.Order;
import com.maximatech.ecommerce.api.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Order Service for Orders, this service is responsible for business logic
 * before returning the object to controller.
 * @author Brenno Fagundes
 */
@Component
public class OrderService {
    private final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Optional<Order> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public List<Order> getAllPaginated(Pageable pageable) {
        return repository.findAll(pageable).toList();
    }

    public void update(Order data){
        repository.save(data);
    }

    public UUID save(Order data) {
        Order order = repository.save(data);
        return order.getUuid();
    }

    public void delete(Order data) {
        repository.delete(data);
    }
}
