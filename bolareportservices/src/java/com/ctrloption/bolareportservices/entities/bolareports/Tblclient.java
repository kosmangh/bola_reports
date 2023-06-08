package com.ctrloption.bolareportservices.entities.bolareports;

import java.io.Serializable;
import java.math.BigDecimal;
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

@Table(name = "Tblclient")
@NamedQueries({
    @NamedQuery(name = "Tblclient.findAll", query = "SELECT t FROM Tblclient t")})
public class Tblclient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ClientID")
    private String clientID;
    @Size(max = 10)
    @Column(name = "Clientnumber")
    private String clientnumber;
    @Column(name = "Dateregistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateregistered;
    @Column(name = "Servicestart")
    @Temporal(TemporalType.TIMESTAMP)
    private Date servicestart;
    @Size(max = 40)
    @Column(name = "Company")
    private String company;
    @Size(max = 30)
    @Column(name = "Contact")
    private String contact;
    @Column(name = "AreaID")
    private Integer areaID;
    @Size(max = 30)
    @Column(name = "Postaladdress")
    private String postaladdress;
    @Size(max = 50)
    @Column(name = "Physicaladdress")
    private String physicaladdress;
    @Size(max = 25)
    @Column(name = "Telphone")
    private String telphone;
    @Size(max = 15)
    @Column(name = "Faxnumber")
    private String faxnumber;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "Email")
    private String email;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Balance")
    private BigDecimal balance;
    @Size(max = 3)
    @Column(name = "Currency")
    private String currency;
    @Column(name = "Active")
    private Boolean active;
    @Column(name = "SubmetroID")
    private Integer submetroID;
    @Column(name = "LocID")
    private Integer locID;
    @Size(max = 10)
    @Column(name = "streetid")
    private String streetid;
    @Size(max = 1)
    @Column(name = "Billing")
    private String billing;
    @Size(max = 2)
    @Column(name = "classid")
    private String classid;
    @Size(max = 2)
    @Column(name = "catid")
    private String catid;
    @Size(max = 20)
    @Column(name = "Creator")
    private String creator;
    @Size(max = 20)
    @Column(name = "lastmodifiedby")
    private String lastmodifiedby;
    @Column(name = "vatclient")
    private Boolean vatclient;
    @Column(name = "wtax")
    private Boolean wtax;
    @Size(max = 1)
    @Column(name = "servicelevel")
    private String servicelevel;

    public Tblclient() {
    }

    public Tblclient(String clientID) {
        this.clientID = clientID;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getClientnumber() {
        return clientnumber;
    }

    public void setClientnumber(String clientnumber) {
        this.clientnumber = clientnumber;
    }

    public Date getDateregistered() {
        return dateregistered;
    }

    public void setDateregistered(Date dateregistered) {
        this.dateregistered = dateregistered;
    }

    public Date getServicestart() {
        return servicestart;
    }

    public void setServicestart(Date servicestart) {
        this.servicestart = servicestart;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getAreaID() {
        return areaID;
    }

    public void setAreaID(Integer areaID) {
        this.areaID = areaID;
    }

    public String getPostaladdress() {
        return postaladdress;
    }

    public void setPostaladdress(String postaladdress) {
        this.postaladdress = postaladdress;
    }

    public String getPhysicaladdress() {
        return physicaladdress;
    }

    public void setPhysicaladdress(String physicaladdress) {
        this.physicaladdress = physicaladdress;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getFaxnumber() {
        return faxnumber;
    }

    public void setFaxnumber(String faxnumber) {
        this.faxnumber = faxnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getSubmetroID() {
        return submetroID;
    }

    public void setSubmetroID(Integer submetroID) {
        this.submetroID = submetroID;
    }

    public Integer getLocID() {
        return locID;
    }

    public void setLocID(Integer locID) {
        this.locID = locID;
    }

    public String getStreetid() {
        return streetid;
    }

    public void setStreetid(String streetid) {
        this.streetid = streetid;
    }

    public String getBilling() {
        return billing;
    }

    public void setBilling(String billing) {
        this.billing = billing;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getLastmodifiedby() {
        return lastmodifiedby;
    }

    public void setLastmodifiedby(String lastmodifiedby) {
        this.lastmodifiedby = lastmodifiedby;
    }

    public Boolean getVatclient() {
        return vatclient;
    }

    public void setVatclient(Boolean vatclient) {
        this.vatclient = vatclient;
    }

    public Boolean getWtax() {
        return wtax;
    }

    public void setWtax(Boolean wtax) {
        this.wtax = wtax;
    }

    public String getServicelevel() {
        return servicelevel;
    }

    public void setServicelevel(String servicelevel) {
        this.servicelevel = servicelevel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientID != null ? clientID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblclient)) {
            return false;
        }
        Tblclient other = (Tblclient) object;
        if ((this.clientID == null && other.clientID != null) || (this.clientID != null && !this.clientID.equals(other.clientID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ctrloption.bolareportservices.entities.bolareports.Tblclient[ clientID=" + clientID + " ]";
    }

}
