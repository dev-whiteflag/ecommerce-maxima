package com.maximatech.ecommerce.api;

import com.maximatech.ecommerce.api.models.dto.ProductDto;
import com.maximatech.ecommerce.api.services.TaxService;
import org.junit.Test;
import org.assertj.core.api.WithAssertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestPropertySource(properties = {
        "spring.cloud.config.enabled=false",
        "spring.cloud.config.fail-fast=false"
})
public class TaxCalculationUnitTests implements WithAssertions {

    @Autowired
    private final TaxService service = new TaxService();

    @Test
    public void whenCalculateTax_thenReturnValue() {
        // Given
        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(new ProductDto(2)); // A
        productDtoList.add(new ProductDto(1)); // B

        // When
        double tax = service.calculate(productDtoList);

        // Then
        assertThat(tax).isNotNull();
        assertThat(tax).isGreaterThan(5).isLessThan(30);
    }
}
