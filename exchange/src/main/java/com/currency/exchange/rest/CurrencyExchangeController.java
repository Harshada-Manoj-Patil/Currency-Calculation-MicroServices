package com.currency.exchange.rest;

import com.currency.exchange.repository.CurrencyRepository;
import com.currency.exchange.response.CurrencyRateResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Tag(
        name = "REST API",
        description = "REST APIs for Exchange microservice for currency calculation"
)

@RestController
public class CurrencyExchangeController {
    CurrencyRepository currencyRepository;
    public CurrencyExchangeController(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }
    @Operation(
            summary = "Fetch Currency Exchange rate details",
            description = "Fetch Currency Exchange rate details from database based on from and to currency"
    )
    /*@ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })*/


    /*@GetMapping("/currency-rate/from/{from}/to/{to}")  //http://localhost:8080/currency-rate/from/USD/to/INR
    CurrencyRateResponse currencyRate(@PathVariable String from, @PathVariable String to) {
        return currencyRepository.findByFromAndTo(from, to);
    }*/

    @GetMapping("/currency-rate/from/{from}/to/{to}")  //http://localhost:8080/currency-rate/from/USD/to/INR
    ResponseEntity<?> currencyRate(@PathVariable String from, @PathVariable String to) {
        Optional<CurrencyRateResponse> currencyRateResponse = Optional.ofNullable(currencyRepository.findByFromAndTo(from, to));

        if (currencyRateResponse.isPresent()) {
            return ResponseEntity.ok(currencyRateResponse.get());
        } else {
            return ResponseEntity.status(404).body("Currency rate not found");
        }
    }
}
