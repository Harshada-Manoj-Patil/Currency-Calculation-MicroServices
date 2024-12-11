package com.currency.exchange.rest;

import com.currency.exchange.response.CurrencyRateResponse;
import com.currency.exchange.repository.CurrencyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CurrencyExchangeController.class)
public class CurrencyExchangeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrencyRepository currencyRepository;

    @BeforeEach
    void setUp() {
        Mockito.reset(currencyRepository);
    }

    @Test
    void testCurrencyRate_Success() throws Exception {
        // Arrange
        String from = "USD";
        String to = "INR";
        CurrencyRateResponse mockResponse = new CurrencyRateResponse(from, to, 74.85);
        when(currencyRepository.findByFromAndTo(from, to)).thenReturn(mockResponse);

        // Act & Assert
        mockMvc.perform(get("/currency-rate/from/{from}/to/{to}", from, to))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.from").value(from))
                .andExpect(jsonPath("$.to").value(to))
                .andExpect(jsonPath("$.rate").value(74.85));
    }

    @Test
    void testCurrencyRate_NotFound() throws Exception {
        // Arrange
        String from = "USD";
        String to = "JPY";
        when(currencyRepository.findByFromAndTo(from, to)).thenReturn(null);

        // Act & Assert
        mockMvc.perform(get("/currency-rate/from/{from}/to/{to}", from, to))
                .andExpect(status().isNotFound()) // Assuming the API returns null instead of 404
                .andExpect(content().string("Currency rate not found"));
    }
}
