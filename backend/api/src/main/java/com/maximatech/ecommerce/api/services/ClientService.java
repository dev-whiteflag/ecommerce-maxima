package com.maximatech.ecommerce.api.services;

import com.maximatech.ecommerce.api.models.dto.Pageable;
import com.maximatech.ecommerce.api.models.entities.Client;
import com.maximatech.ecommerce.api.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Client Service for Clients, this service is responsible for business logic
 * before returning the object to controller.
 * @author Brenno Fagundes
 */
@Component
public class ClientService {
    private final ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public Optional<Client> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public List<Client> getAllPaginated(Pageable pageable) {
        org.springframework.data.domain.Pageable converted
                = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        return repository.findAll(converted).toList();
    }

    public void update(Client data){
        repository.save(data);
    }

    public UUID save(Client data) {
        Client client = repository.save(data);
        return client.getUuid();
    }

    public void delete(Client data) {
        repository.delete(data);
    }
}
