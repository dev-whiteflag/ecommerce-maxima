package com.maximatech.ecommerce.api.services;

import com.maximatech.ecommerce.api.models.dto.ClientMaxima;
import com.maximatech.ecommerce.api.models.dto.ProductMaxima;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Maxima Service is a service for communicating with maxima's products and
 * clients endpoints.
 * @author Brenno Fagundes
 */
@Component
public class MaximaService {
    private final WebClient client;

    @Value("${maximatech.api.url}")
    private String url;

    public MaximaService() {
        this.client = WebClient.create(url);
    }

    public List<ClientMaxima> getAllClientsFromApi() {
        WebClient.ResponseSpec response =
                client.get().uri("/cliente")
                        .headers(httpHeaders -> httpHeaders.add("Content-Type", "application/json"))
                        .retrieve();
        ClientMaxima[] result = response.bodyToMono(ClientMaxima[].class).block();
        Objects.requireNonNull(result);
        return Arrays.stream(result).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public List<ProductMaxima> getAllProductsFromApi() {
        WebClient.ResponseSpec response =
                client.get().uri("/produto")
                        .headers(httpHeaders -> httpHeaders.add("Content-Type", "application/json"))
                        .retrieve();
        ProductMaxima[] result = response.bodyToMono(ProductMaxima[].class).block();
        Objects.requireNonNull(result);
        return Arrays.stream(result).filter(Objects::nonNull).collect(Collectors.toList());
    }
}
