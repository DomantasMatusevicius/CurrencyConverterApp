package com.example.CurrencyConverterApp.services;

import com.example.CurrencyConverterApp.dao.CcyAmtDAO;
import com.example.CurrencyConverterApp.data.CcyAmt;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CurrencyService {

    private CcyAmtDAO ccyAmtDAO;

    public CurrencyService(CcyAmtDAO ccyAmtDAO) {
        this.ccyAmtDAO = ccyAmtDAO;
    }

    public List<CcyAmt> getAllCurrencies() {
        List<CcyAmt> currencyList = this.ccyAmtDAO.findAll();
        currencyList.sort(Comparator.comparing(CcyAmt::getCcy));
        return currencyList;
    }
}
