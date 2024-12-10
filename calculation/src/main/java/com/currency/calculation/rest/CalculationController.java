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
    public CalculationResponse currencyConvert(@PathVariable String from, @PathVariable String to, @PathVariable double amount) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CalculationResponse> responseEntity=new RestTemplate()
                .getForEntity("http://localhost:8000/currency-rate/from/{from}/to/{to}", CalculationResponse.class, uriVariables);
        CalculationResponse currencyExchangeResponse = new CalculationResponse();

            currencyExchangeResponse.setTo(to);
            currencyExchangeResponse.setFrom(from);
            currencyExchangeResponse.setAmount(amount);
        if(null !=responseEntity.getBody()) {
            currencyExchangeResponse.setRate(Objects.requireNonNull(responseEntity.getBody()).getRate());
            currencyExchangeResponse.setConvertedAmount(Objects.requireNonNull(responseEntity.getBody()).getRate() * amount);
            currencyExchangeResponse.setMessage("data found");
        } else {
          currencyExchangeResponse.setRate(0);
          currencyExchangeResponse.setConvertedAmount(0);
          currencyExchangeResponse.setMessage("No data found");

        }
        return currencyExchangeResponse;
    }

}
