package com.example.CurrencyConverterApp.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class FxRate {

    @XmlElement(name = "Tp", namespace = "http://www.lb.lt/WebServices/FxRates")
    private String Tp;
    @XmlElement(name = "Dt", namespace = "http://www.lb.lt/WebServices/FxRates")
    private String Dt;
    @XmlElement(name = "CcyAmt", namespace = "http://www.lb.lt/WebServices/FxRates")
    private List<CcyAmt> CcyAmts;

    public FxRate() {
    }

    public String getTp() {
        return Tp;
    }

    public void setTp(String tp) {
        Tp = tp;
    }

    public String getDt() {
        return Dt;
    }

    public void setDt(String dt) {
        Dt = dt;
    }

    public List<CcyAmt> getCcyAmts() {
        return CcyAmts;
    }

    public void setCcyAmts(List<CcyAmt> ccyAmts) {
        this.CcyAmts = ccyAmts;
    }

    public FxRate(String tp, String dt, List<CcyAmt> ccyAmts) {
        Tp = tp;
        Dt = dt;
        this.CcyAmts = ccyAmts;
    }

    @Override
    public String toString() {
        return "FxRate{" +
                "Tp='" + Tp + '\'' +
                ", Dt='" + Dt + '\'' +
                ", ccyAmts=" + CcyAmts +
                '}';
    }
}
