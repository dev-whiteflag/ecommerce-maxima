package com.maximatech.ecommerce.api;

import com.maximatech.ecommerce.api.models.entities.Client;
import com.maximatech.ecommerce.api.repositories.ClientRepository;
import org.junit.Test;
import org.assertj.core.api.WithAssertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.UUID;

@DataJpaTest
@RunWith(value = SpringRunner.class)
@TestPropertySource(properties = {
        "spring.cloud.config.enabled=false",
        "spring.cloud.config.fail-fast=false"
})
public class ClientRepositoryIntegrationTests implements WithAssertions {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private ClientRepository repository;

    @Test
    public void whenFindByUUID_thenReturnClient() {
        // Given
        Client alex = new Client(UUID.randomUUID().toString(), "Brenno");
        em.persist(alex);
        em.flush();

        // When
        Optional<Client> optional = repository.findById(alex.getUuid());
        Client found = null;
        if (optional.isPresent())
            found = optional.get();

        // Then
        assertThat(found).isNotNull();
        assertThat(found.getUuid()).isEqualTo(alex.getUuid());
    }
}
