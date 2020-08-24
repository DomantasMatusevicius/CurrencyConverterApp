package com.example.CurrencyConverterApp.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

//@XmlRootElement(namespace = "http://www.lb.lt/WebServices/FxRates", name = "FxRates") <-- Anotacija naudota bandant
// valiutų kursus gauti su RestTemplate.

@XmlRootElement(name = "FxRates")
@XmlAccessorType(XmlAccessType.FIELD)
public class FxRates {

    @XmlElement(name = "FxRate")
    List<FxRate> fxRates;

    public FxRates() {
    }

    public List<FxRate> getFxRates() {
        return fxRates;
    }

    public void setFxRates(List<FxRate> fxRates) {
        this.fxRates = fxRates;
    }

    public FxRates(List<FxRate> fxRates) {
        this.fxRates = fxRates;
    }

    @Override
    public String toString() {
        return "FxRates{" +
                "fxRates=" + fxRates +
                '}';
    }
}
