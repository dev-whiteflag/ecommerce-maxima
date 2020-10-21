package com.maximatech.ecommerce.api.resources;

import com.google.common.base.Preconditions;
import com.maximatech.ecommerce.api.mappers.ClientMapper;
import com.maximatech.ecommerce.api.mappers.OrderMapper;
import com.maximatech.ecommerce.api.models.dto.ClientDto;
import com.maximatech.ecommerce.api.models.dto.OrderDto;
import com.maximatech.ecommerce.api.models.entities.Client;
import com.maximatech.ecommerce.api.models.entities.Order;
import com.maximatech.ecommerce.api.services.ClientService;
import com.maximatech.ecommerce.api.services.MaximaService;
import com.maximatech.ecommerce.api.services.OrderService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Rest Controller (resource) for Orders, this controller includes Paginated Endpoints.
 * @author Brenno Fagundes
 */
@RestController
@RequestMapping(value = "/v1/clients", produces = { MediaType.APPLICATION_JSON_VALUE })
public class OrderResource {

    private final OrderService service;
    private final OrderMapper mapper = Mappers.getMapper(OrderMapper.class);

    @Autowired
    public OrderResource(OrderService service) {
        this.service = service;
    }

    @GetMapping("/{uuid}")
    public OrderDto findById(@PathVariable UUID uuid) {
        Optional<Order> optional = service.findById(uuid);
        if(optional.isPresent())
            return mapper.toDto(optional.get());
        throw new EntityNotFoundException("Requested Order was not Found");
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> getAllOrders(@RequestBody Pageable body) {
        Preconditions.checkNotNull(body);
        List<OrderDto> orderDtos = new ArrayList<>();
        service.getAllPaginated(body).parallelStream()
                .forEach(order -> orderDtos.add(mapper.toDto(order)));
        return orderDtos;
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public UUID createOrder(@RequestBody OrderDto order){
        Preconditions.checkNotNull(order);
        return service.save(mapper.toEntity(order));
    }

    @PutMapping(value = "/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable UUID uuid, @RequestBody OrderDto resource) {
        Preconditions.checkNotNull(resource);
        Optional<Order> optional = service.findById(uuid);
        if(optional.isPresent()){
            Order order = optional.get();
            order.setUpdatedAt(ZonedDateTime.now());
            service.update(order);
        } else {
            throw new EntityNotFoundException("Requested Order was not Found");
        }
    }

    @DeleteMapping(value = "/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable UUID uuid) {
        Preconditions.checkNotNull(uuid);
        Optional<Order> optional = service.findById(uuid);
        if(optional.isPresent()){
            service.delete(optional.get());
        } else {
            throw new EntityNotFoundException("Requested Order was not Found");
        }
    }
}
