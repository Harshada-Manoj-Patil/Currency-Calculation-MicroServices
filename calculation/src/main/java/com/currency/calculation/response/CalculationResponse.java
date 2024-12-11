package com.currency.calculation.response;

public class CalculationResponse {
    private String to;
    private String from;
    private double rate;
    private double amount;
    private double convertedAmount;
    private String message;

    public CalculationResponse(String to, String from, double rate, double amount, double convertedAmount, String message) {
        this.to = to;
        this.from = from;
        this.rate = rate;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
        this.message = message;
    }

    public CalculationResponse() {

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

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
