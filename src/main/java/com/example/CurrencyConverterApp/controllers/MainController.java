package com.example.CurrencyConverterApp.controllers;

import com.example.CurrencyConverterApp.dao.CcyAmtDAO;
import com.example.CurrencyConverterApp.dao.ConversionCurrencyDAO;
import com.example.CurrencyConverterApp.data.CcyAmt;
import com.example.CurrencyConverterApp.data.ConversionCurrency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private CcyAmtDAO ccyAmtDAO;

    @Autowired
    private ConversionCurrencyDAO conversionCurrencyDAO;

    @GetMapping("/")
    public ModelAndView Converter() {
        logger.info("Home method accessed");
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
        logger.info("user have started converting currencies");
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
        currency.setResult(result);

        logger.info("user have choosed to convert: " + currency.getValue() + " " + currency.getFrom() + " to " + currency.getTo() + ". The result is: " + result + " " + currency.getTo());

        conversionCurrencyDAO.save(currency);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}