//package com.example.CurrencyConverterApp.tasks;
//
//import com.example.CurrencyConverterApp.dao.CcyAmtDAO;
//import com.example.CurrencyConverterApp.data.CcyAmt;
//import com.example.CurrencyConverterApp.data.FxRate;
//import com.example.CurrencyConverterApp.data.FxRates;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Unmarshaller;
//import java.io.File;
//
//@Component
//public class GetCurrenciesJaxb {
//
//    @Autowired
//    private CcyAmtDAO ccyAmtDAO;
//
//    @Scheduled(fixedRate = 24 * 1000 * 60 * 60)
//    private void unMarshal() throws JAXBException {
//        JAXBContext jaxbContext = JAXBContext.newInstance(FxRates.class);
//        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//
//        FxRates rates = (FxRates) jaxbUnmarshaller.unmarshal(new File("C:\\Users\\doman\\Desktop\\JAVA\\CurrencyConverterApp\\getCurrentFxRates.xml"));
//        CcyAmt currencyEur = new CcyAmt();
//        currencyEur.setCcy(rates.getFxRates().get(0).getCcyAmts().get(0).getCcy());
//        currencyEur.setAmt(rates.getFxRates().get(0).getCcyAmts().get(0).getAmt());
//        ccyAmtDAO.save(currencyEur);
//
//        for (FxRate rate : rates.getFxRates()) {
//            for (CcyAmt currency : rate.getCcyAmts()) {
//                if (currency.getAmt() != 1.0 && currency.getCcy() != "EUR") {
//                    this.ccyAmtDAO.save(currency);
//                }
//            }
//        }
//    }
//}
