package com.currency.exchange.rest;

import com.currency.exchange.repository.CurrencyRepository;
import com.currency.exchange.response.CurrencyRateResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyRestController {
    CurrencyRepository currencyRepository;
    public CurrencyRestController(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }


    @GetMapping("/currency-rate/from/{from}/to/{to}")  //http://localhost:8080/currency-rate/from/USD/to/INR
    CurrencyRateResponse currencyRate(@PathVariable String from, @PathVariable String to) {
        return currencyRepository.findByFromAndTo(from, to);
    }
}
