package com.ctrloption.bolareportservices.restmodels;

import com.ctrloption.bolareportservices.restmodels.commons.HeaderResponse;

/**
 *
 * @author aahwi
 */
public class LoginResponse {

    private HeaderResponse headerResponse;
    private String company;
    private String affiliateName;
    private String terminalId;
    private String terminalName;
    private String branchCode;
    private String merchantName;
    private String merchantId;
    private String emailAddress;
    private String lastLoginDate;
    private String authourization;
    private String token;
    private String deviceId;
    private String fcmToken;
    private Boolean merchantAcct;

    //<editor-fold defaultstate="collapsed" desc="GETTERS AND SETTERS">
    public HeaderResponse getHeaderResponse() {
        return headerResponse;
    }

    public void setHeaderResponse(HeaderResponse headerResponse) {
        this.headerResponse = headerResponse;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAffiliateName() {
        return affiliateName;
    }

    public void setAffiliateName(String affiliateName) {
        this.affiliateName = affiliateName;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public Boolean getMerchantAcct() {
        return merchantAcct;
    }

    public void setMerchantAcct(Boolean merchantAcct) {
        this.merchantAcct = merchantAcct;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getAuthourization() {
        return authourization;
    }

    public void setAuthourization(String authourization) {
        this.authourization = authourization;
    }

//</editor-fold>
}
