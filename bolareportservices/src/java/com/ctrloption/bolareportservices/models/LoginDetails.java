/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ctrloption.bolareportservices.models;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author aahwi
 */
@Getter
@Setter
public class LoginDetails {
    private String company;
    private String affiliateName;
    private String terminalId;
    private String terminalName;
    private String branchCode;
    private String merchantName;
    private String merchantId;
    private String emailAddress;
    private String lastLoginDate;
    private Boolean type;
    private String deviceId;
    private String fcmToken;
    private Boolean merchantAcct;
}
