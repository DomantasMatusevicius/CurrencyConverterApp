//package com.example.CurrencyConverterApp.tasks;
////
////import com.example.CurrencyConverterApp.data.FxRates;
////import org.springframework.scheduling.annotation.Scheduled;
////import org.springframework.stereotype.Component;
////import org.springframework.web.client.RestTemplate;
////
////@Component
////public class GetCurrenciesRest {
////
////    @Scheduled(fixedRate = 24 * 1000 * 60 *60)
////    private void getRatesTask() {
////
////        RestTemplate restTemplate = new RestTemplate();
////        FxRates forObject = restTemplate.getForObject("http://lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=EU", FxRates.class);
////        System.out.println(forObject.getFxRates());
////
////    }
////}
