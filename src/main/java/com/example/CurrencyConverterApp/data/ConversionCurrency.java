package com.example.CurrencyConverterApp.data;

import javax.persistence.*;

@Entity
@Table(name = "useractivity")
public class ConversionCurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "toCurrency")
    private String to;
    @Column(name = "fromCurrency")
    private String from;
    @Column(name = "value")
    private double value;
    @Column(name = "result")
    private double result;

    public ConversionCurrency() {
    }

    public ConversionCurrency(String to, String from, double value) {
        this.to = to;
        this.from = from;
        this.value = value;
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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ConversionCurrency{" +
                "to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", value=" + value +
                '}';
    }
}
