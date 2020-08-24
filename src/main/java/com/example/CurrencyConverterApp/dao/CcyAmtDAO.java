package com.example.CurrencyConverterApp.dao;

import com.example.CurrencyConverterApp.data.CcyAmt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CcyAmtDAO extends JpaRepository<CcyAmt, String> {

    @Override
    List<CcyAmt> findAll();

}
