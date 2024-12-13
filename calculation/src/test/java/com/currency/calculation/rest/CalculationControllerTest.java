package com.currency.calculation.rest;

import com.currency.calculation.response.CalculationResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@SpringBootTest
public class CalculationControllerTest {

    @InjectMocks
    private CalculationController calculationController;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void testCurrencyConvertSuccess() {
        // Mock REST API response
        MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", "SGD");
        uriVariables.put("to", "INR");

        ResponseEntity<CalculationResponse> responseEntity = new RestTemplate()
                .getForEntity("http://localhost:8000/currency-rate/from/{from}/to/{to}",
                        CalculationResponse.class, uriVariables);

        // Call the controller method
        ResponseEntity<CalculationResponse> response = calculationController.currencyConvert(Objects.requireNonNull(responseEntity.getBody()).getFrom(), responseEntity.getBody().getTo(), 100.0);

        // Assertions
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(Objects.requireNonNull(response.getBody()).getFrom(), is(responseEntity.getBody().getFrom()));
        assertThat(Objects.requireNonNull(response.getBody()).getTo(), is(responseEntity.getBody().getTo()));
        assertThat(response.getBody().getRate(), is(responseEntity.getBody().getRate()));
        assertThat(response.getBody().getConvertedAmount(), is(responseEntity.getBody().getRate() * 100.0));
        assertThat(response.getBody().getMessage(), is("Data found"));

        mockServer.verify();
    }


}