package com.ctrloption.bolareportservices.entities.bolareports;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "revcollection")
@NamedQueries({
    @NamedQuery(name = "Revcollection.findAll", query = "SELECT r FROM Revcollection r")})
public class Revcollection implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "revcolid")
    private String revcolid;
    @Size(max = 4)
    @Column(name = "revcollectorID")
    private String revcollectorID;
    @Size(max = 255)
    @Column(name = "revcoldate")
    private String revcoldate;
    @Size(max = 20)
    @Column(name = "cashrecvdby")
    private String cashrecvdby;
    @Column(name = "cashrcvddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cashrcvddate;
    @Size(max = 20)
    @Column(name = "paymentvalidatedby")
    private String paymentvalidatedby;
    @Column(name = "payvaldate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date payvaldate;
    @Size(max = 20)
    @Column(name = "checkedbyfm")
    private String checkedbyfm;
    @Column(name = "checkedfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkedfmdate;
    @Size(max = 20)
    @Column(name = "postedby")
    private String postedby;
    @Column(name = "posteddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date posteddate;
    @Column(name = "closed")
    private Boolean closed;

    public Revcollection() {
    }

    public Revcollection(String revcolid) {
        this.revcolid = revcolid;
    }

    public String getRevcolid() {
        return revcolid;
    }

    public void setRevcolid(String revcolid) {
        this.revcolid = revcolid;
    }

    public String getRevcollectorID() {
        return revcollectorID;
    }

    public void setRevcollectorID(String revcollectorID) {
        this.revcollectorID = revcollectorID;
    }

    public String getRevcoldate() {
        return revcoldate;
    }

    public void setRevcoldate(String revcoldate) {
        this.revcoldate = revcoldate;
    }

    public String getCashrecvdby() {
        return cashrecvdby;
    }

    public void setCashrecvdby(String cashrecvdby) {
        this.cashrecvdby = cashrecvdby;
    }

    public Date getCashrcvddate() {
        return cashrcvddate;
    }

    public void setCashrcvddate(Date cashrcvddate) {
        this.cashrcvddate = cashrcvddate;
    }

    public String getPaymentvalidatedby() {
        return paymentvalidatedby;
    }

    public void setPaymentvalidatedby(String paymentvalidatedby) {
        this.paymentvalidatedby = paymentvalidatedby;
    }

    public Date getPayvaldate() {
        return payvaldate;
    }

    public void setPayvaldate(Date payvaldate) {
        this.payvaldate = payvaldate;
    }

    public String getCheckedbyfm() {
        return checkedbyfm;
    }

    public void setCheckedbyfm(String checkedbyfm) {
        this.checkedbyfm = checkedbyfm;
    }

    public Date getCheckedfmdate() {
        return checkedfmdate;
    }

    public void setCheckedfmdate(Date checkedfmdate) {
        this.checkedfmdate = checkedfmdate;
    }

    public String getPostedby() {
        return postedby;
    }

    public void setPostedby(String postedby) {
        this.postedby = postedby;
    }

    public Date getPosteddate() {
        return posteddate;
    }

    public void setPosteddate(Date posteddate) {
        this.posteddate = posteddate;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (revcolid != null ? revcolid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Revcollection)) {
            return false;
        }
        Revcollection other = (Revcollection) object;
        if ((this.revcolid == null && other.revcolid != null) || (this.revcolid != null && !this.revcolid.equals(other.revcolid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ctrloption.bolareportservices.entities.bolareports.Revcollection[ revcolid=" + revcolid + " ]";
    }

}
