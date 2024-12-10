package com.currency.exchange.repository;

import com.currency.exchange.entity.CurrencyRate;
import com.currency.exchange.response.CurrencyRateResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<CurrencyRate, Integer> {
    CurrencyRateResponse findByFromAndTo(String from, String to);
}
