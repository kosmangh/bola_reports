package com.ctrloption.bolareportservices.models;

import com.ctrloption.bolareportservices.entities.bolareports.Payments;
import com.ctrloption.bolareportservices.utils.AppLogger;
import java.util.Date;
import org.apache.log4j.Logger;

/**
 * @author Daud Ainoo
 * @Company CtrlOpton
 * @Contact 0245 293945
 * @Website ctrlOpton.com
 * @date Sat 01 Apr, 2023
 * @time 12.31.34 pm
 */
public class ReportsModel {

    private static final Logger log = Logger.getLogger(ReportsModel.class.getName());

    private String clientId;
    private String clientName;
    private String receiptNo;
    private Date receiptDate;
    private String chequeCash;
    private Double amount;
    private String remarks;
    private String revenueCollectorName;
    private String operationalSector;

    public ReportsModel() {
    }

    public ReportsModel(Payments p) {
        try {
            this.clientId = p.getClient().getClientID();
            this.clientName = p.getClient().getCompany();
            this.amount = p.getAmount().doubleValue();
            this.chequeCash = p.getCashchq();
            this.operationalSector = "";
            this.receiptDate = p.getDatepaid();
            this.receiptNo = p.getReciept();
            this.remarks = "";
            this.revenueCollectorName = p.getRevcollector().getRevcollector();
        } catch (Exception e) {
            AppLogger.error(log, e, "Error constructing payment report model");
        }

    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getChequeCash() {
        return chequeCash;
    }

    public void setChequeCash(String chequeCash) {
        this.chequeCash = chequeCash;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRevenueCollectorName() {
        return revenueCollectorName;
    }

    public void setRevenueCollectorName(String revenueCollectorName) {
        this.revenueCollectorName = revenueCollectorName;
    }

    public String getOperationalSector() {
        return operationalSector;
    }

    public void setOperationalSector(String operationalSector) {
        this.operationalSector = operationalSector;
    }

}
