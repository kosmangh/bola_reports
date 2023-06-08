package com.ctrloption.bolareportservices.entities.bolareports;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

@Table(name = "Revenuecollectors")
public class Revenuecollectors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "RevcollectorID")
    private String revcollectorID;
    @Size(max = 30)
    @Column(name = "Revcollector")
    private String revcollector;
    @Size(max = 30)
    @Column(name = "Revcoladdress")
    private String revcoladdress;
    @Size(max = 30)
    @Column(name = "Revcolphone")
    private String revcolphone;
    @Column(name = "Active")
    private Boolean active;
    @Size(max = 25)
    @Column(name = "createdby")
    private String createdby;
    @Size(max = 25)
    @Column(name = "modifiedby")
    private String modifiedby;
    @Column(name = "datedeleted")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedeleted;
    @Size(max = 25)
    @Column(name = "deletedby")
    private String deletedby;
    @Column(name = "Accbalance")
    private Long accbalance;

    public Revenuecollectors() {
    }

    public Revenuecollectors(String revcollectorID) {
        this.revcollectorID = revcollectorID;
    }

    public String getRevcollectorID() {
        return revcollectorID;
    }

    public void setRevcollectorID(String revcollectorID) {
        this.revcollectorID = revcollectorID;
    }

    public String getRevcollector() {
        return revcollector;
    }

    public void setRevcollector(String revcollector) {
        this.revcollector = revcollector;
    }

    public String getRevcoladdress() {
        return revcoladdress;
    }

    public void setRevcoladdress(String revcoladdress) {
        this.revcoladdress = revcoladdress;
    }

    public String getRevcolphone() {
        return revcolphone;
    }

    public void setRevcolphone(String revcolphone) {
        this.revcolphone = revcolphone;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(String modifiedby) {
        this.modifiedby = modifiedby;
    }

    public Date getDatedeleted() {
        return datedeleted;
    }

    public void setDatedeleted(Date datedeleted) {
        this.datedeleted = datedeleted;
    }

    public String getDeletedby() {
        return deletedby;
    }

    public void setDeletedby(String deletedby) {
        this.deletedby = deletedby;
    }

    public Long getAccbalance() {
        return accbalance;
    }

    public void setAccbalance(Long accbalance) {
        this.accbalance = accbalance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (revcollectorID != null ? revcollectorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Revenuecollectors)) {
            return false;
        }
        Revenuecollectors other = (Revenuecollectors) object;
        if ((this.revcollectorID == null && other.revcollectorID != null) || (this.revcollectorID != null && !this.revcollectorID.equals(other.revcollectorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ctrloption.bolareportservices.entities.bolareports.Revenuecollectors[ revcollectorID=" + revcollectorID + " ]";
    }

}
