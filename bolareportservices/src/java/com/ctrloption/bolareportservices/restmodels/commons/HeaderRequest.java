package com.ctrloption.bolareportservices.restmodels.commons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeaderRequest {
    protected String sourceCode;
    protected String requestId;
    protected String requestToken;
    protected String requestType;
    protected String company;
    protected String ipAddress;
    protected String lang;
}
