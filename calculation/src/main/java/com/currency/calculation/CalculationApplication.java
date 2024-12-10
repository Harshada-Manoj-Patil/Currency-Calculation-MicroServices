package com.currency.calculation;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		info = @Info(
				title = "Calculation microservice REST API Documentation",
				description = "Exchange microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Harshada Patil",
						email = "test@gmail.com",
						url = "https://github.com/Harshada-Manoj-Patil"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.apache.org/licenses/LICENSE-2.0"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "Currency Calculation microservice REST API Documentation",
				url = "https://github.com/Harshada-Manoj-Patil"
		)
)
@SpringBootApplication
public class CalculationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculationApplication.class, args);
	}

}
