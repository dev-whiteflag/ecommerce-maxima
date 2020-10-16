package com.maximatech.ecommerce.api.resources;

import com.google.common.base.Preconditions;
import com.maximatech.ecommerce.api.models.dto.UserDto;
import com.maximatech.ecommerce.api.models.entities.User;
import com.maximatech.ecommerce.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Rest Controller (resource) for Users, this controller
 * includes Paginated Endpoints.
 * @author Brenno Fagundes
 */
@RestController
@RequestMapping(value = "/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
public class UserResource {

    private final UserService service;

    @Autowired
    public UserResource(UserService service) {
        this.service = service;
    }

    @PostMapping("/users")
    public Iterable<User> getAllUsers(@RequestBody Pageable body) {
        //TODO: validate pageable before using.
        //TODO: if doesn't exist on database, check Maxima's Endpoint.
        return repository.findAll(body);
    }

    @PostMapping("/users/new")
    public UUID createUser(@RequestBody UserDto user){
        Preconditions.checkNotNull(user);
        return repository.save(user);
    }
}
