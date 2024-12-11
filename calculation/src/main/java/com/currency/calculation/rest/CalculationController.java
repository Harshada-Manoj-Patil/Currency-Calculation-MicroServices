package com.currency.calculation.rest;


import com.currency.calculation.response.CalculationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Tag(
        name = "REST API",
        description = "REST APIs for Calculation microservice for currency calculation"
)
@RestController
public class CalculationController {
    @Operation(
            summary = "Calculate Currency",
            description = "Calculate Currency based on exchange rate retrieved from currency-exchange API"
    )


    @GetMapping("/currency-calculation/from/{from}/to/{to}/amount/{amount}")
    public ResponseEntity<CalculationResponse> currencyConvert(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable double amount) {

        // Define the URI variables
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        // Initialize response object
        CalculationResponse currencyExchangeResponse = new CalculationResponse();
        currencyExchangeResponse.setFrom(from);
        currencyExchangeResponse.setTo(to);
        currencyExchangeResponse.setAmount(amount);

        try {
            // Call the currency exchange API
            ResponseEntity<CalculationResponse> responseEntity = new RestTemplate()
                    .getForEntity("http://localhost:8000/currency-rate/from/{from}/to/{to}",
                            CalculationResponse.class, uriVariables);

            // If the response body is present, process the exchange rate
            if (responseEntity.getBody() != null) {
                double rate = Objects.requireNonNull(responseEntity.getBody()).getRate();
                currencyExchangeResponse.setRate(rate);
                currencyExchangeResponse.setConvertedAmount(rate * amount);
                currencyExchangeResponse.setMessage("Data found");
            } else {
                throw new RuntimeException("Empty response from currency exchange API");
            }
        } catch (Exception ex) {
            // Handle case where API fails or record is not found
            currencyExchangeResponse.setRate(0.0);
            currencyExchangeResponse.setConvertedAmount(0.0);
            currencyExchangeResponse.setMessage("No data found: " + ex.getMessage());
        }

        // Return the response entity
        return ResponseEntity.ok(currencyExchangeResponse);
    }

    }
