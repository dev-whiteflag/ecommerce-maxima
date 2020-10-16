package com.maximatech.ecommerce.api.services;

import com.maximatech.ecommerce.api.models.dto.ClientDto;
import com.maximatech.ecommerce.api.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class ClientService {
    private final ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public boolean saveClient(ClientDto data) {
        return false;
    }

}
