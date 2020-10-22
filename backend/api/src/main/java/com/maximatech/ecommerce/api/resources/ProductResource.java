package com.maximatech.ecommerce.api.resources;

import com.google.common.base.Preconditions;
import com.maximatech.ecommerce.api.mappers.ProductMapper;
import com.maximatech.ecommerce.api.models.dto.ClientDto;
import com.maximatech.ecommerce.api.models.dto.Pageable;
import com.maximatech.ecommerce.api.models.dto.ProductDto;
import com.maximatech.ecommerce.api.models.entities.Client;
import com.maximatech.ecommerce.api.models.entities.Product;
import com.maximatech.ecommerce.api.services.MaximaService;
import com.maximatech.ecommerce.api.services.ProductService;
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
 * Rest Controller (resource) for Products, this controller includes Paginated Endpoints.
 * @author Brenno Fagundes
 */
@RestController
@RequestMapping(value = "/v1/products", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ProductResource {

    private final ProductService service;
    private final MaximaService maxService;
    private final ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @Autowired
    public ProductResource(ProductService service, MaximaService maxService) {
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

        maxService.getAllProductsFromApi().parallelStream()
                .forEach(product -> {
                    if (!service.verifyIfExistsByCode(product.getCodigo()))
                        service.save(mapper.toEntity(product));
                });
    }

    @GetMapping("/{uuid}")
    public ProductDto findById(@PathVariable UUID uuid) {
        Optional<Product> optional = service.findById(uuid);
        if(optional.isPresent())
            return mapper.toDto(optional.get());
        throw new EntityNotFoundException("Requested Product was not Found");
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Page<ProductDto> getAllClients(@RequestBody Pageable body) {
        Preconditions.checkNotNull(body);
        PageRequest pageRequest = PageRequest.of(body.getPageNumber(), body.getPageSize());
        Page<Product> pageResult = service.getAllPaginated(pageRequest);
        List<ProductDto> clients = pageResult.stream().map(mapper::toDto).collect(Collectors.toList());
        return new PageImpl<>(clients, pageRequest, pageResult.getTotalElements());
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public UUID createProduct(@RequestBody ProductDto product){
        Preconditions.checkNotNull(product);
        Product entity = mapper.toEntity(product);
        entity.setCreatedAt(ZonedDateTime.now());
        entity.setUpdatedAt(ZonedDateTime.now());
        return service.save(entity);
    }

    @GetMapping(value = "/update/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable UUID uuid, @RequestBody ProductDto resource) {
        Preconditions.checkNotNull(resource);
        Optional<Product> optional = service.findById(uuid);
        if(optional.isPresent()){
            Product product = optional.get();
            product.setUpdatedAt(ZonedDateTime.now());
            service.update(product);
        } else {
            throw new EntityNotFoundException("Requested Product was not Found");
        }
    }

    @GetMapping(value = "/delete/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable UUID uuid) {
        Preconditions.checkNotNull(uuid);
        Optional<Product> optional = service.findById(uuid);
        if(optional.isPresent()){
            service.delete(optional.get());
        } else {
            throw new EntityNotFoundException("Requested Product was not Found");
        }
    }
}
