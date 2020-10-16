package com.maximatech.ecommerce.api.resources;

import com.google.common.base.Preconditions;
import com.maximatech.ecommerce.api.models.dto.ClientDto;
import com.maximatech.ecommerce.api.models.entities.Client;
import com.maximatech.ecommerce.api.services.ClientService;
import com.maximatech.ecommerce.api.services.MaximaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Rest Controller (resource) for Clients, this controller
 * includes Paginated Endpoints.
 * @author Brenno Fagundes
 */
@RestController
@RequestMapping(value = "/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ClientResource {

    private final ClientService service;
    private final MaximaService maxService;

    @Autowired
    public ClientResource(ClientService service, MaximaService maxService) {
        this.service = service;
        this.maxService = maxService;
    }

    @GetMapping("/clients/sync")
    public void syncWithMaxima() {
        /* ENHANCE: this will be called by frontend everytime 'Clients' screen is
        *           opened, this is not the smartest way to sync them but will work for now.
        *           Probably a Messaging Service like RabbitMQ and Kafka would do the job
        *           nicely.
        */

        maxService.getAllClientsFromApi().parallelStream();
    }

    @PostMapping("/users")
    public Iterable<Client> getAllUsers(@RequestBody Pageable body) {
        return null;
    }

    @PostMapping("/users/new")
    public UUID createUser(@RequestBody ClientDto user){
        Preconditions.checkNotNull(user);
        return null;
    }
}
