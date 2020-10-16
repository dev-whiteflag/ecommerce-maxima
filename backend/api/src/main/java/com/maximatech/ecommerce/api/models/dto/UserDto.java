package com.maximatech.ecommerce.api.models.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private String name;
    private String code;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
