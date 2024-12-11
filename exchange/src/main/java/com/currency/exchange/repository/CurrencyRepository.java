package com.currency.exchange.repository;

import com.currency.exchange.entity.Currency;
import com.currency.exchange.response.CurrencyRateResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
    CurrencyRateResponse findByFromAndTo(String from, String to);
}
