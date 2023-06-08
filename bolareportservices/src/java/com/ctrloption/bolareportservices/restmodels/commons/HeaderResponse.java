package com.ctrloption.bolareportservices.restmodels.commons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeaderResponse {
    private String sourceCode;
    private String requestId;
    private String company;
    private String responseCode;
    private String responseMessage;
}
