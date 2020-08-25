package com.example.CurrencyConverterApp.data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "currency")
@XmlAccessorType(XmlAccessType.FIELD)
public class CcyAmt {

    @Id
    @Column(name = "name")
    @XmlElement(name = "Ccy", namespace = "http://www.lb.lt/WebServices/FxRates")
    private String Ccy;
    @Column(name = "valueineuros")
    @XmlElement(name = "Amt", namespace = "http://www.lb.lt/WebServices/FxRates")
    private double Amt;

    public CcyAmt() {
    }

    public String getCcy() {
        return Ccy;
    }

    public void setCcy(String ccy) {
        Ccy = ccy;
    }

    public double getAmt() {
        return Amt;
    }

    public void setAmt(double amt) {
        Amt = amt;
    }

    public CcyAmt(String ccy, double amt) {
        Ccy = ccy;
        Amt = amt;
    }

    @Override
    public String toString() {
        return "CcyAmt{" +
                "Ccy='" + Ccy + '\'' +
                ", Amt=" + Amt +
                '}';
    }
}
