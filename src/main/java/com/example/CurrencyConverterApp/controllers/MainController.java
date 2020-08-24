package com.example.CurrencyConverterApp.controllers;

import com.example.CurrencyConverterApp.dao.CcyAmtDAO;
import com.example.CurrencyConverterApp.data.CcyAmt;
import com.example.CurrencyConverterApp.data.ConversionCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private CcyAmtDAO ccyAmtDAO;

    @GetMapping("/")
    public ModelAndView Converter() {
        ModelAndView mav = new ModelAndView("Converter");
        mav.addObject("list", ccyAmtDAO.findAll());
        return mav;
    }

//    @GetMapping("/user")
//    public String user() {
//        System.out.println("ok");
//        return ("<h1>Welcome User</h1>");
//    }
//
//    @GetMapping("/admin")
//    public String admin() {
//        return ("<h1>Welcome Admin</h1>");
//    }

    @PostMapping("/result")
    public ResponseEntity<Double> convertCurrency(
            @RequestParam(name = "from", required = false) String from,
            @RequestParam(name = "to", required = false) String to,
            @RequestParam(name = "value", required = false) double value
    ) {
        ConversionCurrency currency;
        currency = new ConversionCurrency();
        currency.setFrom(from);
        currency.setTo(to);
        currency.setValue(value);

        Optional<CcyAmt> fromOptional = this.ccyAmtDAO.findById(currency.getFrom());
        Optional<CcyAmt> toOptional = this.ccyAmtDAO.findById(currency.getTo());

        CcyAmt fromCurrency = fromOptional.get();
        CcyAmt toCurrency = toOptional.get();

        Double fromValue = fromCurrency.getAmt();
        Double toValue = toCurrency.getAmt();

        Double result = toValue * currency.getValue() / fromValue;

        System.out.println(currency);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}