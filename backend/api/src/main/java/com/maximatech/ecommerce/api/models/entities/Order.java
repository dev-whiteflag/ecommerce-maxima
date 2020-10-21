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
 * Entity that describes data of a Order. This uses Lombok.
 * @author Brenno Fagundes
 */
@Data
@Entity
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String code;
    private double totalValue;
    private int productQuantity;
    private double taxValue;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public Order() {}

    public Order(String code, double totalValue, int productQuantity, double taxValue) {
        this.code = code;
        this.totalValue = totalValue;
        this.productQuantity = productQuantity;
        this.taxValue = taxValue;
        this.createdAt = ZonedDateTime.now();
        this.updatedAt = createdAt;
    }
}
