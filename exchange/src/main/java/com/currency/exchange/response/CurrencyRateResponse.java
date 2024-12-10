package com.currency.exchange.response;

public class CurrencyRateResponse {
    private String to;
    private String from;
    private double rate;

    public CurrencyRateResponse(String to, String from, double rate) {
        this.to = to;
        this.from = from;
        this.rate = rate;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
