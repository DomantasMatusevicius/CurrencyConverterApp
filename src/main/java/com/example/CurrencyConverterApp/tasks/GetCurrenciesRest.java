package com.example.CurrencyConverterApp.tasks;

import com.example.CurrencyConverterApp.dao.CcyAmtDAO;
import com.example.CurrencyConverterApp.data.CcyAmt;
import com.example.CurrencyConverterApp.data.FxRate;
import com.example.CurrencyConverterApp.data.FxRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GetCurrenciesRest {

    @Autowired
    private CcyAmtDAO ccyAmtDAO;

    @Value("${apiKey}")
    private String urlLbApi;

    @Scheduled(fixedRate = 6 * 1000 * 60 *60)
    private void getRatesTask() {

        RestTemplate restTemplate = new RestTemplate();
        FxRates forObject = restTemplate.getForObject(urlLbApi, FxRates.class);
        CcyAmt currencyEur = new CcyAmt();
        currencyEur.setCcy(forObject.getFxRates().get(0).getCcyAmts().get(0).getCcy());
        currencyEur.setAmt(forObject.getFxRates().get(0).getCcyAmts().get(0).getAmt());
        ccyAmtDAO.save(currencyEur);

        for (FxRate rate : forObject.getFxRates()) {
            for (CcyAmt currency : rate.getCcyAmts()) {
                if (currency.getAmt() != 1.0 && currency.getCcy() != "EUR") {
                    this.ccyAmtDAO.save(currency);
                }
            }
        }
    }
}
