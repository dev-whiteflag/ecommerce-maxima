package com.maximatech.ecommerce.api.models.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Entity that describes data of a Product. This uses Lombok.
 * @author Brenno Fagundes
 */
@Data
@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String code;
    private String name;
    private Double unitPrice;
    private String imageUrl;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public Product() {}

    public Product(String code, String name, Double unitPrice, String imageUrl) {
        this.code = code;
        this.name = name;
        this.unitPrice = unitPrice;
        this.imageUrl = imageUrl;
        this.createdAt = ZonedDateTime.now();
        this.updatedAt = createdAt;
    }
}
