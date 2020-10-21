package com.maximatech.ecommerce.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
		"spring.cloud.config.enabled=false",
		"spring.cloud.config.fail-fast=false"
})
class GatewayServerApplicationTests {

	@Test
	void contextLoads() {
	}

}
