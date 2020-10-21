package com.maximatech.ecommerce.api.resources;

import com.google.common.base.Preconditions;
import com.maximatech.ecommerce.api.mappers.ClientMapper;
import com.maximatech.ecommerce.api.models.dto.ClientDto;
import com.maximatech.ecommerce.api.models.dto.Pageable;
import com.maximatech.ecommerce.api.models.entities.Client;
import com.maximatech.ecommerce.api.services.ClientService;
import com.maximatech.ecommerce.api.services.MaximaService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Rest Controller (resource) for Clients, this controller includes Paginated Endpoints.
 * @author Brenno Fagundes
 */
@RestController
@RequestMapping(value = "/v1/clients", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ClientResource {

    private final ClientService service;
    private final MaximaService maxService;
    private final ClientMapper mapper = Mappers.getMapper(ClientMapper.class);

    @Autowired
    public ClientResource(ClientService service, MaximaService maxService) {
        this.service = service;
        this.maxService = maxService;
    }

    @GetMapping("/sync")
    @ResponseStatus(HttpStatus.OK)
    public void syncWithMaxima() {
        /* ENHANCE: this will be called by frontend everytime 'Clients' screen is
        *           opened, this is not the smartest way to sync them but will work for now.
        *           Probably a Messaging Service like RabbitMQ and Kafka would do the job
        *           nicely.
        */

        maxService.getAllClientsFromApi().parallelStream()
                .forEach(client -> service.save(mapper.toEntity(client)));
    }

    @GetMapping("/{uuid}")
    public ClientDto findById(@PathVariable UUID uuid) {
        Optional<Client> optional = service.findById(uuid);
        if(optional.isPresent())
            return mapper.toDto(optional.get());
        throw new EntityNotFoundException("Requested Client was not Found");
    }

    // new pagination method
    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Page<ClientDto> getAllClients(@RequestBody Pageable body) {
        Preconditions.checkNotNull(body);
        PageRequest pageRequest = PageRequest.of(body.getPageNumber(), body.getPageSize());
        Page<Client> pageResult = service.getAllPaginated(pageRequest);
        List<ClientDto> clients = pageResult.stream().map(mapper::toDto).collect(Collectors.toList());
        return new PageImpl<>(clients, pageRequest, pageResult.getTotalElements());
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public UUID createUser(@RequestBody ClientDto user){
        Preconditions.checkNotNull(user);
        return service.save(mapper.toEntity(user));
    }

    @PutMapping(value = "/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable UUID uuid, @RequestBody ClientDto resource) {
        Preconditions.checkNotNull(resource);
        Optional<Client> optional = service.findById(uuid);
        if(optional.isPresent()){
            Client client = optional.get();
            client.setUpdatedAt(ZonedDateTime.now());
            service.update(client);
        } else {
            throw new EntityNotFoundException("Requested Client was not Found");
        }
    }

    @DeleteMapping(value = "/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable UUID uuid) {
        Preconditions.checkNotNull(uuid);
        Optional<Client> optional = service.findById(uuid);
        if(optional.isPresent()){
            service.delete(optional.get());
        } else {
            throw new EntityNotFoundException("Requested Client was not Found");
        }
    }
}
