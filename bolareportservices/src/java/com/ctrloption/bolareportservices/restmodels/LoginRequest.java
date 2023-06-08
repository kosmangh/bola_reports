/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ctrloption.bolareportservices.restmodels;

import com.ctrloption.bolareportservices.restmodels.commons.HeaderRequest;

/**
 *
 * @author aahwi
 */
public class LoginRequest {

    private com.ctrloption.bolareportservices.restmodels.commons.HeaderRequest headerRequest;
    private String merchantId;
    private String pin;
    private String deviceId;
    private String fcmToken;

    public HeaderRequest getHeaderRequest() {
        return headerRequest;
    }

    public void setHeaderRequest(HeaderRequest headerRequest) {
        this.headerRequest = headerRequest;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
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

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }
    
    

}
