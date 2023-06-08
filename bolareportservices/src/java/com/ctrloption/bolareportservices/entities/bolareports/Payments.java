package com.ctrloption.bolareportservices.entities.bolareports;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Daud Ainoo
 * @Company CtrlOpton
 * @Contact 0245 293945
 * @Website ctrlOpton.com
 * @date Sat 01 Apr, 2023
 * @time 11.58.01 am
 */
@Entity
@Cacheable(false)
@Table(name = "Payments")
public class Payments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "paymentsid")
    private String paymentsid;

    @JoinColumn(name = "ClientID")
    @ManyToOne
    private Tblclient client;

    @JoinColumn(name = "Revcolid")
    @ManyToOne
    private Revcollection revenueCollection;

    @JoinColumn(name = "RevcollectorID")
    @ManyToOne
    private Revenuecollectors revcollector;

    @Column(name = "Inputdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inputdate;
    @Column(name = "Datepaid")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datepaid;

    @Column(name = "Amount")
    private BigDecimal amount;
    @Column(name = "Vatpaid")
    private BigDecimal vatpaid;
    @Column(name = "Whtax")
    private BigDecimal whtax;
    @Size(max = 50)
    @Column(name = "Cashchq")
    private String cashchq;
    @Size(max = 20)
    @Column(name = "Reciept")
    private String reciept;

    @Column(name = "comisionrate")
    private Double comisionrate;
    @Column(name = "Dload")
    private Boolean dload;
    @Size(max = 20)
    @Column(name = "Creator")
    private String creator;

    public Payments() {
    }

    public Payments(String paymentsid) {
        this.paymentsid = paymentsid;
    }

    public String getPaymentsid() {
        return paymentsid;
    }

    public void setPaymentsid(String paymentsid) {
        this.paymentsid = paymentsid;
    }

    public Tblclient getClient() {
        return client;
    }

    public void setClient(Tblclient client) {
        this.client = client;
    }

    public Revcollection getRevenueCollection() {
        return revenueCollection;
    }

    public void setRevenueCollection(Revcollection revenueCollection) {
        this.revenueCollection = revenueCollection;
    }

    public Revenuecollectors getRevcollector() {
        return revcollector;
    }

    public void setRevcollector(Revenuecollectors revcollector) {
        this.revcollector = revcollector;
    }

    public Date getInputdate() {
        return inputdate;
    }

    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
    }

    public Date getDatepaid() {
        return datepaid;
    }

    public void setDatepaid(Date datepaid) {
        this.datepaid = datepaid;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getVatpaid() {
        return vatpaid;
    }

    public void setVatpaid(BigDecimal vatpaid) {
        this.vatpaid = vatpaid;
    }

    public BigDecimal getWhtax() {
        return whtax;
    }

    public void setWhtax(BigDecimal whtax) {
        this.whtax = whtax;
    }

    public String getCashchq() {
        return cashchq;
    }

    public void setCashchq(String cashchq) {
        this.cashchq = cashchq;
    }

    public String getReciept() {
        return reciept;
    }

    public void setReciept(String reciept) {
        this.reciept = reciept;
    }

    public Double getComisionrate() {
        return comisionrate;
    }

    public void setComisionrate(Double comisionrate) {
        this.comisionrate = comisionrate;
    }

    public Boolean getDload() {
        return dload;
    }

    public void setDload(Boolean dload) {
        this.dload = dload;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentsid != null ? paymentsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payments)) {
            return false;
        }
        Payments other = (Payments) object;
        return !((this.paymentsid == null && other.paymentsid != null) || (this.paymentsid != null && !this.paymentsid.equals(other.paymentsid)));
    }

    @Override
    public String toString() {
        return "com.ctrloption.bolareportservices.entities.bolareports.Payments[ paymentsid=" + paymentsid + " ]";
    }

}
