package com.example.CurrencyConverterApp.dao;

import com.example.CurrencyConverterApp.data.ConversionCurrency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversionCurrencyDAO extends JpaRepository<ConversionCurrency, Integer> {

}
